package com.dt.platform.eam.service;

import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import com.github.foxnic.dao.entity.ISimpleIdService;

import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;
import com.dt.platform.domain.eam.AssetEmployeeLoss;
import com.dt.platform.domain.eam.AssetEmployeeLossVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import java.io.InputStream;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.data.SaveMode;
import java.util.Map;

/**
 * <p>
 * 资产报失 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 22:09:17
*/

public interface IAssetEmployeeLossService extends  ISimpleIdService<AssetEmployeeLoss,String> {


	/**
 	  * 表单定义代码
      **/
	public static final String FORM_DEFINITION_CODE="eam_asset_employee_loss";
	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetEmployeeLoss 数据对象
	 * @return 插入是否成功
	 * */
	Result insert(AssetEmployeeLoss assetEmployeeLoss);

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetEmployeeLoss  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	Result insert(AssetEmployeeLoss assetEmployeeLoss,boolean throwsException);

	/**
	 * 批量插入实体，事务内
	 * @param assetEmployeeLossList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<AssetEmployeeLoss> assetEmployeeLossList);


		
	/**
	 * 按主键删除 资产报失
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除 资产报失
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdLogical(String id);

	/**
	 * 批量物理删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsPhysical(List<T> ids);

	/**
	 * 批量逻辑删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsLogical(List<T> ids);

		
	/**
	 * 按主键更新字段 资产报失
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param assetEmployeeLoss 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(AssetEmployeeLoss assetEmployeeLoss , SaveMode mode);


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetEmployeeLoss 数据对象
	 * @param mode SaveMode,数据更新的模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果
	 */
	Result update(AssetEmployeeLoss assetEmployeeLoss , SaveMode mode,boolean throwsException);


	/**
	 * 更新实体集，事务内
	 * @param assetEmployeeLossList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<AssetEmployeeLoss> assetEmployeeLossList, SaveMode mode);

	/**
	 * 保存实体，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetEmployeeLoss 实体数据
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	Result save(AssetEmployeeLoss assetEmployeeLoss , SaveMode mode,boolean throwsException);

	/**
	 * 保存实体，如果语句错误，则抛出异常
	 * @param assetEmployeeLoss 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(AssetEmployeeLoss assetEmployeeLoss , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param assetEmployeeLossList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<AssetEmployeeLoss> assetEmployeeLossList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在 . 判断 主键值不同，但指定字段的值相同的记录是否存在
	 * @param assetEmployeeLoss  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(AssetEmployeeLoss assetEmployeeLoss,DBField... field);

		
	/**
	 * 按主键获取 资产报失
	 *
	 * @param id 主键
	 * @return AssetEmployeeLoss 数据对象
	 */
	AssetEmployeeLoss getById(String id);

	/**
	 * 检查引用
	 * @param id  检查ID是否又被外部表引用
	 * */
	Boolean hasRefers(String id);

	/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	Map<String,Boolean> hasRefers(List<String> ids);

	/**
	 * 按 id 获取多个对象
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<AssetEmployeeLoss> queryListByIds(List<String> ids);

	/**
	 * 按 id 列表查询 Map
	 * @param ids  主键清单
	 * */
	Map<String, AssetEmployeeLoss> queryMapByIds(List<String> ids);



	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetEmployeeLoss 数据对象
	 * @return 判断结果
	 */
	Boolean checkExists(AssetEmployeeLoss assetEmployeeLoss);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(AssetEmployeeLoss sample);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(AssetEmployeeLoss sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<AssetEmployeeLoss> queryList(AssetEmployeeLossVO sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<AssetEmployeeLoss> queryList(AssetEmployeeLoss sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<AssetEmployeeLoss> queryList(AssetEmployeeLoss sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<AssetEmployeeLoss> queryList(AssetEmployeeLoss sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	AssetEmployeeLoss queryEntity(AssetEmployeeLoss sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<AssetEmployeeLoss> queryPagedList(AssetEmployeeLossVO sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<AssetEmployeeLoss> queryPagedList(AssetEmployeeLoss sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<AssetEmployeeLoss> queryPagedList(AssetEmployeeLoss sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<AssetEmployeeLoss> queryPagedList(AssetEmployeeLoss sample,OrderBy orderBy,int pageSize,int pageIndex);

 	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field,Class<T> type, ConditionExpr condition);

	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @param ps 参数清单
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field, Class<T> type, String condition,Object... ps);

	/**
	 * 导出 Excel
	 * */
	ExcelWriter exportExcel(AssetEmployeeLoss sample);

	/**
	 * 导出用于数据导入的 Excel 模版
	 * */
	ExcelWriter  exportExcelTemplate();

	/**
	 * 构建 Excel 结构
	 * @param  isForExport 是否用于数据导出
	 * @return   ExcelStructure
	 * */
	ExcelStructure buildExcelStructure(boolean isForExport);

	/**
	 * 导入 Excel 数据
	 * @return  错误信息，成功时返回 null
	 * */
	List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch);


	/**
	 * 处理流程回调
	 * */
	BpmActionResult onProcessCallback(BpmEvent event);


	void joinProcess(AssetEmployeeLoss assetEmployeeLoss);

	void joinProcess(List<AssetEmployeeLoss> assetEmployeeLossList);

	void joinProcess(PagedList<AssetEmployeeLoss> assetEmployeeLossList);

}