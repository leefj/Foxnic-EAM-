package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.eam.AssetDataExportColumnEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.constants.enums.hr.EmployeeStatusEnum;
import com.dt.platform.constants.enums.hr.PersonDataExportColumnEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.hr.*;
import com.dt.platform.hr.common.ResetOnCloseInputStream;
import com.dt.platform.hr.service.*;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.excel.*;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.apache.poi.ss.usermodel.*;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.io.BufferedInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.api.error.ErrorDesc;

import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 人员信息服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:01
*/


@Service("HrPersonService")

public class PersonServiceImpl extends SuperService<Person> implements IPersonService {



	@Autowired
	private ISalaryTplService salaryTplService;

	@Autowired
	private IPositionService positionService;

	@Autowired
	private IRankService rankService;

	@Autowired
	private IProfessionalLevelService professionalLevelService;

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
				map.put(node.getId(),path);
			}
		}
		return map;
	}




	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param person  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Person person,boolean throwsException) {


		//处理员工
		Employee employee=null;
		if(!StringUtil.isBlank(person.getEmployeeId())){
			if(dao.query("select * from hr_person where deleted=0 and employee_id=?",person.getEmployeeId()).size()>0){
				return ErrorDesc.failureMessage("当前员工已被选择,请重新进行选择");
			}

			Result<Employee> employeeRes=EmployeeServiceProxy.api().getById(person.getEmployeeId());
			if(employeeRes.isSuccess()){
				if(employeeRes.getData()!=null){
					employee=employeeRes.getData();
				}
			}else{
				return ErrorDesc.failureMessage(employeeRes.getMessage());
			}
		}
		if(employee!=null){
			person.setJobNumber(employee.getBadge());
		}


		if(StringUtil.isBlank(person.getJobNumber())){
			person.setJobNumber(IDGenerator.getSnowflakeIdString());
		}
		Result r=super.insert(person,throwsException);

		return r;
	}


	@Override
	public InputStream buildExcelTemplate(String code) {
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
	public Map<String, Object> queryPersonMap(List<Person> list) {
		long start = System.currentTimeMillis();
		Map<String,Object> map=new HashMap<>();
		HashMap<String,String> orgMap=queryOrganizationNodes("");
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++) {
			Person item = list.get(i);
			Map<String, Object> itemMap= BeanUtil.toMap(item);
			//枚举
			CodeTextEnum vStatus= EnumUtil.parseByCode(StatusYNEnum.class,item.getSalaryPayOut());
			itemMap.put("salaryPayOutName",vStatus==null?"":vStatus.text());
			CodeTextEnum employeeStatus= EnumUtil.parseByCode(EmployeeStatusEnum.class,item.getEmployeeStatus());
			itemMap.put("employeeStatusName",employeeStatus==null?"":employeeStatus.text());
			//数据字典
			if(item.getBloodTypeDict()!=null){
				itemMap.put("bloodTypeName",item.getBloodTypeDict().getLabel());
			}
			if(item.getSexDict()!=null){
				itemMap.put("sexCodeName",item.getSexDict().getLabel());
			}
			if(item.getMaritalStatusDict()!=null){
				itemMap.put("maritalStatusName",item.getMaritalStatusDict().getLabel());
			}
			if(item.getEmployeeIdentity()!=null){
				itemMap.put("employeeIdentityStatusName",item.getEmployeeIdentity().getLabel());
			}
			if(item.getEmployeeOwnerTypeDict()!=null){
				itemMap.put("employeeOwnerTypeName",item.getEmployeeOwnerTypeDict().getLabel());
			}
			if(item.getEducationData()!=null){
				itemMap.put("educationCodeName",item.getEducationData().getLabel());
			}
			if(item.getBank()!=null){
				itemMap.put("payrollCardBankCodeName",item.getBank().getLabel());
			}
			if(item.getBank()!=null){
				itemMap.put("payrollCardBankCodeName",item.getBank().getLabel());
			}
			if(item.getPoliticCountenanceData()!=null){
				itemMap.put("politicCountenanceCodeName",item.getPoliticCountenanceData().getLabel());
			}
			if(item.getEmployeeIdentity()!=null){
				itemMap.put("identityCardName",item.getEmployeeIdentity().getLabel());
			}
			//下拉框
			if(item.getPosition()!=null){
				itemMap.put("positionCodeName",item.getPosition().getName());
			}
			if(item.getSalaryTpl()!=null){
				itemMap.put("salaryTplName",item.getSalaryTpl().getName());
			}
			if(item.getOrgId()!=null){
				String orgName=orgMap.get(item.getOrgId());
				itemMap.put("orgName",orgName);
			}
			if(item.getOrganization()!=null){
				itemMap.put("organizationName",item.getOrganization().getFullName());
			}
			if(item.getRank()!=null){
				itemMap.put("rankCodeName",item.getRank().getCode());
			}
			if(item.getProfessionalLevel()!=null){
				itemMap.put("employeeTitleCodeName",item.getProfessionalLevel().getName());
			}
			listMap.add(itemMap);
		}
		long finish = System.currentTimeMillis();
		long cost=(finish-start)/1000L;
		Logger.info("queryAssetMap execute cost:"+cost);
		map.put("dataList", listMap);
		return map;
	}



	public String queryMapKeyByValue(HashMap<String,String> map, String value){
		String key = null;
		//Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
		for(String getKey: map.keySet()){
			if(map.get(getKey).equals(value)){
				key = getKey;
				return key;
			}
		}
		return key;
	}

	public HashMap<String,String> queryDictItemDataByDictCode(String dictCode){
		HashMap<String,String> map=new HashMap<>();
		DictItemVO vo=new DictItemVO();
		vo.setDictCode(dictCode);
		Result<List<DictItem>> result= DictItemServiceProxy.api().queryList(vo);
		if(result.isSuccess()){
			List<DictItem> list=result.getData();
			for(int i=0;i<list.size();i++){
				Logger.info(dictCode+" put data:"+list.get(i).getCode()+","+list.get(i).getLabel());
				map.put(list.get(i).getCode(),list.get(i).getLabel());
			}
		}else{
		}
		return map;
	}


	public List<ValidateResult> importData(RcdSet rs) {
		HashMap<String,String> orgMap=queryOrganizationNodes("");

		HashMap<String,HashMap<String,String>> dictDataMap=new HashMap<>();
		dictDataMap.put("hr_employee_owner_type",queryDictItemDataByDictCode("hr_employee_owner_type"));
		dictDataMap.put("hr_politic_countenance",queryDictItemDataByDictCode("hr_politic_countenance"));
		dictDataMap.put("hr_employee_identity_status",queryDictItemDataByDictCode("hr_employee_identity_status"));
		dictDataMap.put("hr_education",queryDictItemDataByDictCode("hr_education"));
		dictDataMap.put("hr_blood_type",queryDictItemDataByDictCode("hr_blood_type"));
		dictDataMap.put("sex",queryDictItemDataByDictCode("sex"));
		dictDataMap.put("hr_bank_list",queryDictItemDataByDictCode("hr_bank_list"));
		dictDataMap.put("hr_marital_status",queryDictItemDataByDictCode("hr_marital_status"));

		HashMap<String,String> dictColumns=new HashMap<>();
		dictColumns.put("employeeTypeCode","hr_employee_owner_type,员工类型");
		dictColumns.put("politicCountenanceCode","hr_politic_countenance,政治面貌");
		dictColumns.put("employeeIdentityStatus","hr_employee_identity_status,员工标记");
		dictColumns.put("educationCode","hr_education,学历");
		dictColumns.put("bloodType","hr_blood_type,血型");
		dictColumns.put("sexCode","sex,性别");
		dictColumns.put("payrollCardBankCode","hr_bank_list,银行");
		dictColumns.put("maritalStatus","hr_marital_status,婚姻状态");


		List<ValidateResult> errors=new ArrayList<>();
		DBTableMeta tm=dao().getTableMeta(this.table());
		DBTreaty dbTreaty= dao().getDBTreaty();
		List<SQL> upsList=new ArrayList<>();
		List<SQL> insList=new ArrayList<>();
		HashMap<String,String> jobNumberMap=new HashMap<>();
		HashMap<String, Rcd> personMap=new HashMap<>();


		for(int i=0;i<rs.getRcdList().size();i++){
			Rcd r=rs.getRcd(i);
			String id=r.getString("id");


			String orgId="org_id";
			String valueOrg=r.getString(orgId);
			if(!StringUtil.isBlank(valueOrg)){
				if(orgMap.containsValue(valueOrg.trim())){
					String key= queryMapKeyByValue(orgMap,valueOrg);
					r.setValue(valueOrg,key);
				}else{
					//返回报错
					errors.add(new ValidateResult(null,(i+1),"组织节点未匹配到:"+valueOrg));
					break;
				}
			}

			//处理字典
			for(String key:dictColumns.keySet()){
				String keyValue=dictColumns.get(key);
				String[] keyValueArr=keyValue.split(",");
				String dict=keyValueArr[0];
				String notes=keyValueArr[1];
				HashMap<String,String> map=dictDataMap.get(dict);
				String col=BeanNameUtil.instance().depart(key);
				String valueCol=r.getString(col);
				Logger.info("col:"+col+",valueCol:"+valueCol);
				if(!StringUtil.isBlank(valueCol)){
					if(map.containsValue(valueCol)){
						r.setValue(col,queryMapKeyByValue(map,valueCol));
					}else{
						errors.add(new ValidateResult(null,(i+1),notes+":"+valueCol));
						break;
					}
				}
			}


			//处理枚举
			String salaryPayOut=r.getString("salary_pay_out");
			if(!StringUtil.isBlank(salaryPayOut)){
				CodeTextEnum value=EnumUtil.parseByText(StatusYNEnum.class,salaryPayOut);
				if(StringUtil.isBlank(value)){
					errors.add(new ValidateResult(null,(i+1),"薪酬发放为空"));
					break;
				}else{
					r.setValue("salary_pay_out",value.code());
				}
			}

			String employeeStatus=r.getString("employee_status");
			if(!StringUtil.isBlank(employeeStatus)){
				CodeTextEnum value=EnumUtil.parseByText(EmployeeStatusEnum.class,employeeStatus);
				if(StringUtil.isBlank(value)){
					errors.add(new ValidateResult(null,(i+1),"员工状态为空"));
					break;
				}else{
					r.setValue("employee_status",value.code());
				}
			}




			//处理下拉框
			String salaryTpl=r.getString("salary_tpl_id");
			if(!StringUtil.isBlank(salaryTpl)){
				SalaryTpl tpl = salaryTplService.queryEntity(SalaryTpl.create().setName(salaryTpl));
				if(tpl==null){
					errors.add(new ValidateResult(null,(i+1),"薪酬模版不存在,模版名称:"+salaryTpl));
					break;
				}else{
					r.setValue("salary_tpl_id",tpl.getId());
				}
			}

			String position=r.getString("position_code");
			if(!StringUtil.isBlank(position)){
				Position tpl = positionService.queryEntity(Position.create().setName(position));
				if(tpl==null){
					errors.add(new ValidateResult(null,(i+1),"position不存在,名称:"+position));
					break;
				}else{
					r.setValue("position_code",tpl.getId());
				}
			}

			String rank=r.getString("rank_code");
			if(!StringUtil.isBlank(position)){
				Rank tpl = rankService.queryEntity(Rank.create().setCode(rank));
				if(tpl==null){
					errors.add(new ValidateResult(null,(i+1),"rank不存在,名称:"+rank));
					break;
				}else{
					r.setValue("rank_code",tpl.getId());
				}
			}

			String titleCode=r.getString("employee_title_code");
			if(!StringUtil.isBlank(titleCode)){
				ProfessionalLevel tpl = professionalLevelService.queryEntity(ProfessionalLevel.create().setName(titleCode));
				if(tpl==null){
					errors.add(new ValidateResult(null,(i+1),"titleCode不存在,名称:"+titleCode));
					break;
				}else{
					r.setValue("employee_title_code",tpl.getId());
				}
			}


			if(StringUtil.isBlank(id)){
				Insert insert = SQLBuilder.buildInsert(r,this.table(),this.dao(), true);
				insert.set(dbTreaty.getUpdateTimeField(),new Date());
				insert.set(dbTreaty.getUpdateUserIdField(),dbTreaty.getLoginUserId());
				insert.set("id",IDGenerator.getSnowflakeIdString());
				insert.set("tenant_id", SessionUser.getCurrent().getActivatedTenantId());
				insList.add(insert);
			}else{
				//update
				Update update= SQLBuilder.buildUpdate(r,SaveMode.ALL_FIELDS,this.table(),this.dao());
				update.set(dbTreaty.getUpdateTimeField(),new Date());
				update.set(dbTreaty.getUpdateUserIdField(),dbTreaty.getLoginUserId());
				upsList.add(update);
			}
		}
		if(errors.size()>0){
			return errors;
		}
		if(insList.size()>0){
			dao.batchExecute(insList);
		}
		if(upsList.size()>0){
			dao.batchExecute(upsList);
		}
		return errors;
	}
	@Override
	public ExcelStructure buildExcelStructure(InputStream dataInputStream, String code) {
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
					//filter
					if(AssetDataExportColumnEnum.USE_USER_NAME.code().equals(asset_column)
							||AssetDataExportColumnEnum.MANAGER_NAME.code().equals(asset_column)
							||AssetDataExportColumnEnum.STATUS_NAME.code().equals(asset_column)){
						continue;
					}
					rAssetColumn= EnumUtil.parseByCode(PersonDataExportColumnEnum.class,asset_column)==null?
							BeanNameUtil.instance().depart(asset_column):
							EnumUtil.parseByCode(PersonDataExportColumnEnum.class,asset_column).text();
					Logger.info("asset_column:"+asset_column+",rAssetColumn:"+rAssetColumn);
					charIndex= ExcelUtil.toExcel26(i);
					Logger.info("cell:"+charIndex+","+secondRow.getCell(i)  +","+ firstRow.getCell(i)+","+asset_column+","+rAssetColumn);
					Logger.info("addColumn:"+rAssetColumn+","+firstRow.getCell(i).toString()+ ","+ ExcelColumn.STRING_CELL_READER);
					es.addColumn(charIndex,rAssetColumn,firstRow.getCell(i).toString(), ExcelColumn.STRING_CELL_READER);
				}
				//追加自定义属性部分
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
				return es;
			}
		}
		return es;
	}

	@Override
	public String queryPersonIdByEmployeeId(String employeeId) {
		Rcd rs=dao.queryRecord("select * from hr_person where deleted=0 and employee_id=?",employeeId);
		if(rs==null){
			return null;
		}else{
			return rs.getString("id");
		}
	}

	@Override
	public String queryOperParameterValue(String code) {
		Rcd rs=dao.queryRecord("select * from sys_config where deleted=0 and code=? and type='ENUM' and type_desc='org.github.foxnic.web.constants.enums.system.YesNo'",code);
		if(rs==null){
			return "0";
		}
		return rs.getString("value");
	}

	@Override
	public Result<JSONObject> queryReportData(String labels) {

		Result<JSONObject> res=new Result<>();
		JSONObject data=new JSONObject();
		String[] labelArr=labels.split(",");
		for(int i=0;i<labelArr.length;i++){
			String label=labelArr[i];
			if("info_data".equals(label)){
				String sql="select \n" +
						"(select count(1) person_cnt from hr_person where deleted=0)person_cnt,\n" +
						"(select count(1) person_cnt from hr_person where deleted=0 and employee_identity_status in ('practice','ontrial')) ontrial_paractice_cnt,\n" +
						"(select count(1) person_cnt from hr_person where deleted=0 and employee_status='non_employee')non_employee_cnt,\n" +
						"(select count(1) person_cnt from hr_person where deleted=0 and employee_status='online')online_cnt,\n" +
						"(select count(1) person_cnt from hr_person where deleted=0 and employee_status='offline')offline_cnt,\n" +
						"(select count(1) person_cnt from hr_person where deleted=0 and (employee_id is null or employee_id=''))non_employee_setting_cnt";
				data.put(label,dao.queryRecord(sql).toJSONObject());
			}else if("status_dis_data".equals(label)){
				String sql="select employee_status name_col ,count(1) value from hr_person where deleted=0 group by employee_status";
				RcdSet rs=dao.query(sql);
				JSONArray arr=new JSONArray();
				for(int j=0;j<rs.size();j++){
					JSONObject obj=rs.getRcd(j).toJSONObject();
					if("online".equals(obj.getString("nameCol"))){
						obj.put("name","在职");
					}else if("offline".equals(obj.getString("nameCol"))){
						obj.put("name","离职");
					}else if("non_employee".equals(obj.getString("nameCol"))){
						obj.put("name","非员工");
					}else {
						obj.put("name",obj.getString("name_col"));
					}
					arr.add(obj);
				}
				data.put(label,arr);
			}else if("education_dis_data".equals(label)){
				String sql="select education_code ,count(1) value from hr_person where deleted=0 group by education_code order by 2 desc";
				RcdSet rs=dao.query(sql);
				JSONArray arr=new JSONArray();
				for(int j=0;j<rs.size();j++){
					JSONObject obj=rs.getRcd(j).toJSONObject();
					String educationCode=obj.getString("educationCode");
					if(StringUtil.isBlank(educationCode)){
						obj.put("name","未设置");
					}else{
						String tsql="select * from sys_dict_item where dict_code='hr_education' and code=?";
						Rcd rcd=dao.queryRecord(tsql,educationCode);
						if(rcd==null){
							obj.put("name",educationCode);
						}else{
							obj.put("name",rcd.getString("label"));
						}
					}
					arr.add(obj);
				}
				data.put(label,arr);
			}

		}
		res.success();
		res.data(data);

		return res;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param person 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Person person) {
		return this.insert(person,true);
	}


	/**
	 * 批量插入实体，事务内
	 * @param personList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Person> personList) {
		return super.insertList(personList);
	}

	
	/**
	 * 按主键删除人员信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Person person = new Person();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		person.setId(id);
		try {
			boolean suc = dao.deleteEntity(person);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除人员信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Person person = new Person();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		person.setId(id);
		person.setDeleted(true);
		person.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		person.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(person,SaveMode.NOT_NULL_FIELDS);
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
	 * @param person 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Person person , SaveMode mode) {
		return this.update(person,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param person 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Person person , SaveMode mode,boolean throwsException) {
		//处理员工

		Employee employee=null;
		if(!StringUtil.isBlank(person.getEmployeeId())){
			Person sourcePerson=this.getById(person.getId());
			if(sourcePerson.getEmployeeId().equals(person.getEmployeeId())){
				Logger.info("员工选择一致,不需要处理");
			}else{
				if(dao.query("select * from hr_person where deleted=0 and employee_id=?",person.getEmployeeId()).size()>0){
					return ErrorDesc.failureMessage("当前员工已被选择,请重新进行选择");
				}
			}
			Result<Employee> employeeRes=EmployeeServiceProxy.api().getById(person.getEmployeeId());
			if(employeeRes.isSuccess()){
				if(employeeRes.getData()!=null){
					employee=employeeRes.getData();
				}
			}else{
				return ErrorDesc.failureMessage(employeeRes.getMessage());
			}
		}
		if(employee!=null){
			person.setJobNumber(employee.getBadge());
		}

		if(StringUtil.isBlank(person.getJobNumber())){
			person.setJobNumber(IDGenerator.getSnowflakeIdString());
		}

		Result r=super.update(person , mode , throwsException);
		if(r.isSuccess()){
			String pId="";
			if(!StringUtil.isBlank(person.getEmployeeId())){
				pId=person.getEmployeeId();
			}
			dao.execute("update hr_person_certificate set employee_id=? where person_id=?",pId,person.getId());
			dao.execute("update hr_person_education set employee_id=? where person_id=?",pId,person.getId());
			dao.execute("update hr_person_social_relation set employee_id=? where person_id=?",pId,person.getId());
			dao.execute("update hr_person_education set employee_id=? where person_id=?",pId,person.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param personList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Person> personList , SaveMode mode) {
		return super.updateList(personList , mode);
	}

	
	/**
	 * 按主键更新人员信息
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
	 * 按主键获取人员信息
	 *
	 * @param id 主键
	 * @return Person 数据对象
	 */
	public Person getById(String id) {
		Person sample = new Person();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<Person> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<Person> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, Person> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, Person::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Person> queryList(PersonVO sample) {
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
	public PagedList<Person> queryPagedList(PersonVO sample, int pageSize, int pageIndex) {

		ConditionExpr expr=new ConditionExpr();
		expr.and("1=1");
		if(!StringUtil.isBlank(sample.getOrgId())) {
			expr.and("org_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+sample.getOrgId()+"/%' or id=?))",sample.getOrgId());
			sample.setOrgId(null);
		}
		return super.queryPagedList(sample, expr,pageSize, pageIndex);
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
	public PagedList<Person> queryPagedList(Person sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input, int sheetIndex, String code) {
		List<ValidateResult> errors=new ArrayList<>();
		ExcelReader er=null;
		try {
			er=new ExcelReader(input);
		} catch (Exception e) {
			errors.add(new ValidateResult(null,-1,"缺少文件"));
			return errors;
		}
		//构建 Excel 结构
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

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param person 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Person person) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(person, SYS_ROLE.NAME);
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





}