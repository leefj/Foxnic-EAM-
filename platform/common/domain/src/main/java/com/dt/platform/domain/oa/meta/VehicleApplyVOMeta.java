package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.VehicleApplyVO;
import java.util.List;
import com.dt.platform.domain.oa.VehicleApply;
import java.util.Date;
import com.dt.platform.domain.oa.VehicleInfo;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:02:14
 * @sign C335B1EA92ACB125927B229F499A1FC5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VehicleApplyVOMeta extends VehicleApplyMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,ORG_ID, java.lang.String.class, "部门", "部门", java.lang.String.class, null);
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final String RECEIVER_ID="receiverId";
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> RECEIVER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,RECEIVER_ID, java.lang.String.class, "领用人", "领用人", java.lang.String.class, null);
	
	/**
	 * 驾驶员 , 类型: java.lang.String
	*/
	public static final String DRIVER="driver";
	
	/**
	 * 驾驶员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> DRIVER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,DRIVER, java.lang.String.class, "驾驶员", "驾驶员", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT="contact";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> CONTACT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,CONTACT, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 领用时间 , 类型: java.util.Date
	*/
	public static final String COLLECTION_DATE="collectionDate";
	
	/**
	 * 领用时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.util.Date> COLLECTION_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,COLLECTION_DATE, java.util.Date.class, "领用时间", "领用时间", java.util.Date.class, null);
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final String PLAN_RETURN_DATE="planReturnDate";
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.util.Date> PLAN_RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,PLAN_RETURN_DATE, java.util.Date.class, "预计归还时间", "预计归还时间", java.util.Date.class, null);
	
	/**
	 * 实际归还时间 , 类型: java.util.Date
	*/
	public static final String ACT_RETURN_DATE="actReturnDate";
	
	/**
	 * 实际归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.util.Date> ACT_RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,ACT_RETURN_DATE, java.util.Date.class, "实际归还时间", "实际归还时间", java.util.Date.class, null);
	
	/**
	 * 是否归还 , 类型: java.lang.String
	*/
	public static final String IF_RETURN="ifReturn";
	
	/**
	 * 是否归还 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> IF_RETURN_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,IF_RETURN, java.lang.String.class, "是否归还", "是否归还", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 车辆 , 类型: java.lang.String
	*/
	public static final String VEHICLE_ID="vehicleId";
	
	/**
	 * 车辆 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> VEHICLE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,VEHICLE_ID, java.lang.String.class, "车辆", "车辆", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 归还备注 , 类型: java.lang.String
	*/
	public static final String RETURN_NOTES="returnNotes";
	
	/**
	 * 归还备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> RETURN_NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,RETURN_NOTES, java.lang.String.class, "归还备注", "归还备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 车辆 , 类型: com.dt.platform.domain.oa.VehicleInfo
	*/
	public static final String VEHICLE_INFO="vehicleInfo";
	
	/**
	 * 车辆 , 类型: com.dt.platform.domain.oa.VehicleInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,com.dt.platform.domain.oa.VehicleInfo> VEHICLE_INFO_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,VEHICLE_INFO, com.dt.platform.domain.oa.VehicleInfo.class, "车辆", "车辆", com.dt.platform.domain.oa.VehicleInfo.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String RECEIVER="receiver";
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,org.github.foxnic.web.domain.hrm.Employee> RECEIVER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,RECEIVER, org.github.foxnic.web.domain.hrm.Employee.class, "领用人", "领用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApplyVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApplyVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , BUSINESS_CODE , STATUS , NAME , ORG_ID , RECEIVER_ID , DRIVER , CONTACT , COLLECTION_DATE , PLAN_RETURN_DATE , ACT_RETURN_DATE , IF_RETURN , CONTENT , ATTACH , VEHICLE_ID , NOTES , RETURN_NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , VEHICLE_INFO , ORIGINATOR , RECEIVER , USE_ORGANIZATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.VehicleApplyVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public VehicleApplyVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public VehicleApplyVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public VehicleApplyVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public VehicleApplyVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public VehicleApplyVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public VehicleApplyVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public VehicleApplyVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public VehicleApplyVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public VehicleApplyVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public VehicleApplyVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public VehicleApplyVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public VehicleApplyVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public VehicleApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public VehicleApply setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public VehicleApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public VehicleApply setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 部门
		 * @param orgId 部门
		 * @return 当前对象
		*/
		public VehicleApply setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 领用人
		 * @param receiverId 领用人
		 * @return 当前对象
		*/
		public VehicleApply setReceiverId(String receiverId) {
			super.change(RECEIVER_ID,super.getReceiverId(),receiverId);
			super.setReceiverId(receiverId);
			return this;
		}
		
		/**
		 * 设置 驾驶员
		 * @param driver 驾驶员
		 * @return 当前对象
		*/
		public VehicleApply setDriver(String driver) {
			super.change(DRIVER,super.getDriver(),driver);
			super.setDriver(driver);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contact 联系方式
		 * @return 当前对象
		*/
		public VehicleApply setContact(String contact) {
			super.change(CONTACT,super.getContact(),contact);
			super.setContact(contact);
			return this;
		}
		
		/**
		 * 设置 领用时间
		 * @param collectionDate 领用时间
		 * @return 当前对象
		*/
		public VehicleApply setCollectionDate(Date collectionDate) {
			super.change(COLLECTION_DATE,super.getCollectionDate(),collectionDate);
			super.setCollectionDate(collectionDate);
			return this;
		}
		
		/**
		 * 设置 预计归还时间
		 * @param planReturnDate 预计归还时间
		 * @return 当前对象
		*/
		public VehicleApply setPlanReturnDate(Date planReturnDate) {
			super.change(PLAN_RETURN_DATE,super.getPlanReturnDate(),planReturnDate);
			super.setPlanReturnDate(planReturnDate);
			return this;
		}
		
		/**
		 * 设置 实际归还时间
		 * @param actReturnDate 实际归还时间
		 * @return 当前对象
		*/
		public VehicleApply setActReturnDate(Date actReturnDate) {
			super.change(ACT_RETURN_DATE,super.getActReturnDate(),actReturnDate);
			super.setActReturnDate(actReturnDate);
			return this;
		}
		
		/**
		 * 设置 是否归还
		 * @param ifReturn 是否归还
		 * @return 当前对象
		*/
		public VehicleApply setIfReturn(String ifReturn) {
			super.change(IF_RETURN,super.getIfReturn(),ifReturn);
			super.setIfReturn(ifReturn);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public VehicleApply setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public VehicleApply setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 车辆
		 * @param vehicleId 车辆
		 * @return 当前对象
		*/
		public VehicleApply setVehicleId(String vehicleId) {
			super.change(VEHICLE_ID,super.getVehicleId(),vehicleId);
			super.setVehicleId(vehicleId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public VehicleApply setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 归还备注
		 * @param returnNotes 归还备注
		 * @return 当前对象
		*/
		public VehicleApply setReturnNotes(String returnNotes) {
			super.change(RETURN_NOTES,super.getReturnNotes(),returnNotes);
			super.setReturnNotes(returnNotes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public VehicleApply setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VehicleApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VehicleApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VehicleApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VehicleApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VehicleApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VehicleApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VehicleApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public VehicleApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public VehicleApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public VehicleApply setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 车辆
		 * @param vehicleInfo 车辆
		 * @return 当前对象
		*/
		public VehicleApply setVehicleInfo(VehicleInfo vehicleInfo) {
			super.change(VEHICLE_INFO,super.getVehicleInfo(),vehicleInfo);
			super.setVehicleInfo(vehicleInfo);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public VehicleApply setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 领用人
		 * @param receiver 领用人
		 * @return 当前对象
		*/
		public VehicleApply setReceiver(Employee receiver) {
			super.change(RECEIVER,super.getReceiver(),receiver);
			super.setReceiver(receiver);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public VehicleApply setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public VehicleApplyVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public VehicleApplyVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setReturnNotes(this.getReturnNotes());
			inst.setActReturnDate(this.getActReturnDate());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setOrgId(this.getOrgId());
			inst.setContent(this.getContent());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setReceiverId(this.getReceiverId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setContact(this.getContact());
			inst.setId(this.getId());
			inst.setAttach(this.getAttach());
			inst.setVehicleId(this.getVehicleId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setPlanReturnDate(this.getPlanReturnDate());
			inst.setIfReturn(this.getIfReturn());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setCollectionDate(this.getCollectionDate());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDriver(this.getDriver());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setReceiver(this.getReceiver());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setVehicleInfo(this.getVehicleInfo());
				inst.setPageSize(this.getPageSize());
				inst.setOriginator(this.getOriginator());
				inst.setUseOrganization(this.getUseOrganization());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}