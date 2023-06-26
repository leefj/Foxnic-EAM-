package com.dt.platform.common.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.UserImportActionStatusEnum;
import com.dt.platform.constants.enums.eam.AssetDataExportColumnEnum;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.excel.*;
import org.apache.poi.ss.usermodel.*;
import org.github.foxnic.web.constants.enums.dict.EmployeeStatus;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import com.dt.platform.domain.common.UserImport;
import com.dt.platform.domain.common.UserImportVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import com.dt.platform.common.service.IUserImportService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 员工导入服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 14:16:24
*/


@Service("SysUserImportService")

public class UserImportServiceImpl extends SuperService<UserImport> implements IUserImportService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param userImport  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(UserImport userImport,boolean throwsException) {
		Result r=super.insert(userImport,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param userImport 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(UserImport userImport) {
		return this.insert(userImport,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param userImportList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<UserImport> userImportList) {
		return super.insertList(userImportList);
	}

	
	/**
	 * 按主键删除员工导入
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		UserImport userImport = new UserImport();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		userImport.setId(id);
		try {
			boolean suc = dao.deleteEntity(userImport);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除员工导入
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		UserImport userImport = new UserImport();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		userImport.setId(id);
		userImport.setDeleted(true);
		userImport.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		userImport.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(userImport,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param userImport 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(UserImport userImport , SaveMode mode) {
		return this.update(userImport,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param userImport 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(UserImport userImport , SaveMode mode,boolean throwsException) {
		Result r=super.update(userImport , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param userImportList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<UserImport> userImportList , SaveMode mode) {
		return super.updateList(userImportList , mode);
	}

	
	/**
	 * 按主键更新员工导入
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取员工导入
	 *
	 * @param id 主键
	 * @return UserImport 数据对象
	 */
	public UserImport getById(String id) {
		UserImport sample = new UserImport();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<UserImport> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<UserImport> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, UserImport> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, UserImport::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<UserImport> queryList(UserImportVO sample) {
		return super.queryList(sample);
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<UserImport> queryPagedList(UserImportVO sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<UserImport> queryPagedList(UserImport sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	@Override
	public ExcelStructure buildExcelStructure(InputStream dataInputStream,String code) {
		InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
		ExcelStructure es=new ExcelStructure();
		//	es.setDataColumnBegin(0);
		es.setDataRowBegin(2);

		Short lastNum=0;
		//从模板获取属性
		Workbook workbook;
		if ( inputStream != null) {
			try {
				workbook = WorkbookFactory.create(inputStream);
				Sheet sheet=workbook.getSheetAt(0);
				Row firstRow=sheet.getRow(0);
				Row secondRow=sheet.getRow(1);
				lastNum=firstRow.getLastCellNum();
				String charIndex="";
				for(int i=0;i<secondRow.getLastCellNum();i++){
					String asset_column=secondRow.getCell(i).toString().replaceFirst("\\{\\{\\$fe:","")
							.replaceFirst("dataList","")
							.replaceFirst("}}","")
							.replaceFirst("t.","").trim();

					String rAssetColumn="";
					rAssetColumn= EnumUtil.parseByCode(AssetDataExportColumnEnum.class,asset_column)==null?
							BeanNameUtil.instance().depart(asset_column):
							EnumUtil.parseByCode(AssetDataExportColumnEnum.class,asset_column).text();
					Logger.info("asset_column:"+asset_column+",rAssetColumn:"+rAssetColumn);
					charIndex= ExcelUtil.toExcel26(i);
					Logger.info("cell:"+charIndex+","+secondRow.getCell(i)  +","+ firstRow.getCell(i)+","+asset_column+","+rAssetColumn);
					Logger.info("addColumn:"+rAssetColumn+","+firstRow.getCell(i).toString()+ ","+ExcelColumn.STRING_CELL_READER);
					es.addColumn(charIndex,rAssetColumn,firstRow.getCell(i).toString(), ExcelColumn.STRING_CELL_READER);
				}
				//追加自定义属性部分
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
				return es;
			}
		}

//		HashMap<String,List<CatalogAttribute>> map=getPcmExtAttribute(dataInputStream);
//		Logger.info("pcm_ext_map:"+map);
//		List<CatalogAttribute> list=new ArrayList<>();
//		for(String key:map.keySet()){
//			list=map.get(key);
//			break;
//		}
//		String charIndex="";
//		for(int i=0;i<list.size();i++){
//			CatalogAttribute attribute=list.get(i);
//			charIndex=ExcelUtil.toExcel26(lastNum+i);
//			Logger.info(charIndex+",自定义属性:"+attribute.getShortName()+","+ attribute.getField());
//			es.addColumn(charIndex,attribute.getField(),attribute.getShortName(), ExcelColumn.STRING_CELL_READER);
//
//		}
		return es;
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param userImport 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(UserImport userImport) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(userImport, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}


	public InputStream buildExcelTemplate(){
		String code="common_user_import";
		InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
		Workbook workbook;
		if(inputStream!=null){
			try {
				BufferedInputStream bufferInput = new ResetOnCloseInputStream(inputStream);
				workbook = WorkbookFactory.create(bufferInput);
				CellStyle cs=workbook.createCellStyle();
				cs.setAlignment(HorizontalAlignment.CENTER);
				cs.setVerticalAlignment(VerticalAlignment.CENTER);
				Sheet sheet=workbook.getSheetAt(0);
//              if("data".equals(sheet.getSheetName())){
//              }
				Row firstRow=sheet.getRow(0);
				Row secondRow=sheet.getRow(1);
				Logger.info("SheetName:"+sheet.getSheetName());
				Logger.info("firstRow lastCellNum:"+firstRow.getLastCellNum());
				Logger.info("lastSecondRow lastCellNum:"+secondRow.getLastCellNum());
				Logger.info("lastSecondRow lastCellNum Value:"+secondRow.getCell(secondRow.getLastCellNum()-1));
				if(firstRow.getLastCellNum()!=secondRow.getLastCellNum()){
					return null;
				}
				Short lastNum=firstRow.getLastCellNum();
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
			}
		}
		return inputStream;

	}


	@Override
	public List<ValidateResult> importExcel(InputStream input, int sheetIndex) {
		List<ValidateResult> errors=new ArrayList<>();
		ExcelReader er=null;
		try {
			er=new ExcelReader(input);
		} catch (Exception e) {
			errors.add(new ValidateResult(null,-1,"缺少文件"));
			return errors;
		}
		//构建 Excel 结构
		String code="common_user_import";
		ExcelStructure es=buildExcelStructure(input,code);

		//装换成记录集
		RcdSet rs=null;
		try {
			Logger.info("sheetIndex"+sheetIndex+","+es+"ind:"+es.getColumnReadEndIndex());
			rs=er.read(sheetIndex,es);

		} catch (Exception e) {
			Logger.error("Excel 导入错误",e);
			errors.add(new ValidateResult(null,-1,"Excel 读取失败"));
			return errors;
		}
		return importData(rs);

	}


	List<ValidateResult> importData(RcdSet rs){
		List<ValidateResult> list=new ArrayList<>();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long now = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		String batchCode=formatter.format(calendar.getTime());
		HashMap<String,String> orgMap=queryOrganizationNodes("");
		System.out.println("print org:"+orgMap);
		//插入到数据库中
		if(rs!=null&&rs.size()>0){
			for(int i=0;i<rs.size();i++){
				Rcd rcd=rs.getRcd(i);
				UserImport item=new UserImport();
				item.setActionCode(batchCode);
				item.setActionStatus(UserImportActionStatusEnum.WAIT.code());

				String user_name=rcd.getString("user_name");
				if(StringUtil.isBlank(user_name)){
					list.add(new ValidateResult(null,(i+1),"用户名不能为空"));
					return list;
				}

				String sex=rcd.getString("sex");
				if("男".equals(sex)){
					item.setSexCode("F");
				}else if("女".equals(sex)){
					item.setSexCode("M");
				}else if("其他".equals(sex)){
					item.setSexCode("O");
				}else{
					list.add(new ValidateResult(null,(i+1),user_name+"，性别填写错误"));
					return list;
				}

				String badge=rcd.getString("badge");
				if(StringUtil.isBlank(badge)){
					list.add(new ValidateResult(null,(i+1),"工号不能为空"));
					return list;
				}
				String phone=rcd.getString("phone");
				if(StringUtil.isBlank(phone)){
					list.add(new ValidateResult(null,(i+1),"手机号不能为空"));
					return list;
				}
				String company_name=rcd.getString("company_name");
				if(StringUtil.isBlank(company_name)){
					list.add(new ValidateResult(null,(i+1),"所在组织不能为空"));
					return list;
				}

				if(!orgMap.containsKey(company_name)){
					list.add(new ValidateResult(null,(i+1),"所在组织"+company_name+"不存在"));
					return list;
				}
				item.setCompanyId(orgMap.get(company_name));
				String master_post=rcd.getString("master_post");
				if(StringUtil.isBlank(master_post)){
					list.add(new ValidateResult(null,(i+1),"主岗不能为空"));
					return list;
				}
				Rcd posRs=dao.queryRecord("select id from hrm_position where org_id=? and full_name=?",item.getCompanyId(),master_post);
				if(posRs==null){
					list.add(new ValidateResult(null,(i+1),user_name+",没有在当前组织下匹配到主岗"));
					return list;
				}else{
					item.setMasterPostId(posRs.getString("id"));
				}
				String status=rcd.getString("status");
				if(StringUtil.isBlank(status)){
					list.add(new ValidateResult(null,(i+1),"状态不能为空"));
					return list;
				}
				if(EmployeeStatus.ACTIVE.text().equals(status)){
					item.setStatusCode(EmployeeStatus.ACTIVE.code());
				}else if(EmployeeStatus.LEAVE.text().equals(status)){
					item.setStatusCode(EmployeeStatus.LEAVE.code());
				}else{
					list.add(new ValidateResult(null,(i+1),user_name+"，员工状态填写错误,当前值:"+status));
					return list;
				}
				String id_card=rcd.getString("id_card");
				item.setBadge(badge);
				item.setUserName(user_name);
				item.setPhone(phone);
				item.setCompanyName(company_name);
				item.setMasterPost(master_post);
				item.setStatus(status);
				item.setIdCard(id_card);
				item.setSex(sex);
				this.insert(item,false);
			}

			//查询手机唯一
			Rcd phoneRs=dao.queryRecord("select count(1) cnt from sys_user_import where action_code=?",batchCode);
			if(phoneRs.getInteger("cnt")<rs.size()){
				list.add(new ValidateResult(null,1,"手机号码必须唯一"));
				return list;
			}

			//工号
			Rcd badgeRs=dao.queryRecord("select count(1) cnt from sys_user_import where action_code=?",batchCode);
			if(badgeRs.getInteger("cnt")<rs.size()){
				list.add(new ValidateResult(null,1,"工号必须唯一"));
				return list;
			}
			//开始批量导入
			UserImportVO vo=new UserImportVO();
			vo.setActionCode(batchCode);
			List<UserImport> userList=this.queryList(vo);
			for(UserImport user:userList){
				importEmployee(user);
			}
		}else{
			return list;
		}
		return list;
	}

	@Override
	public Result importEmployeeById(String id){
		UserImport user=this.getById(id);
		if(UserImportActionStatusEnum.FAILED.code().equals(user.getActionStatus())||
				UserImportActionStatusEnum.WAIT.code().equals(user.getActionStatus())){
			return importEmployee(user);
		}else{
			return ErrorDesc.failureMessage("当前记录的状态，不能进行此项操作");
		}
	}


	public Result importEmployee(UserImport user){
		EmployeeVO employee=new EmployeeVO();
		employee.setPhone(user.getPhone());
		employee.setName(user.getUserName());
		employee.setPositionId(user.getMasterPostId());
		employee.setPrimaryPositionId(user.getMasterPostId());
		employee.setIdentity(StringUtil.isBlank(user.getIdCard())?"0":user.getIdCard());
		employee.setTenantId("T001");
		employee.setSex(user.getSexCode());
		employee.setStatus(user.getStatusCode());
		employee.setBadge(user.getBadge());
		employee.setDirectLeaderId("");
		employee.setType("");
		//employee.setCompanyId(user.getCompanyId());
		Result result= EmployeeServiceProxy.api().insert(employee);
		if(result.isSuccess()){
			dao.execute("update sys_user_import set action_status=?,action_oper_time=now() where id=?",UserImportActionStatusEnum.SUCCESS.code(),user.getId());
			return ErrorDesc.success();
		}else{
			dao.execute("update sys_user_import set action_msg=?,action_status=?,action_oper_time=now() where id=?",StringUtil.isBlank(result.getMessage())?"插入失败":result.getMessage(),UserImportActionStatusEnum.FAILED.code(),user.getId());
			return ErrorDesc.failureMessage(StringUtil.isBlank(result.getMessage())?"插入失败":result.getMessage());
		}
	}

	public HashMap<String,String> queryOrganizationNodes(String type){
		//id name
		HashMap<String,String> map=new HashMap<String,String>();
		OrganizationVO vo=new OrganizationVO();
		vo.setIsLoadAllDescendants(1);
		if(!StringUtil.isBlank(type)){
			//   vo.setTargetType(type);
		}
		vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
		Result r= OrganizationServiceProxy.api().queryNodesFlatten(vo);
		if(r.isSuccess()){
			List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
			for( ZTreeNode node:list){
				if("com".equals(type)){
					if("com".equals(node.getType())){
						Logger.info("add");
					}else{
						continue;
					}
				}else if("org".equals(type)){
					if("com".equals(node.getType()) || "dept".equals(node.getType())){
						Logger.info("add");
					}else{
						continue;
					}
				}
				String path="";
				for(int j=0;j<node.getNamePathArray().size();j++){
					if(j==0){
						path=node.getNamePathArray().get(j);
					}else{
						path=path+"/"+node.getNamePathArray().get(j);
					}
				}
				Logger.info("node:"+node.getId()+",path:"+path+"type:"+node.getType());
				map.put(path,node.getId());
			}
		}
		return map;
	}




	@Override
	public File saveTempFile(InputStream is, String fileName){
		int BYTESIZE=1024;
		String path = System.getProperty("java.io.tmpdir");
		File temp = new File(path +File.separator+ fileName);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(new FileOutputStream(temp));                            //把文件流转为文件，保存在临时目录
			int len = 0;
			byte[] buf = new byte[10*BYTESIZE];                                                    //缓冲区
			while((len=bis.read(buf)) != -1){
				bos.write(buf, 0, len);
			}
			bos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(bos!=null) bos.close();
				if(bis!=null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

}