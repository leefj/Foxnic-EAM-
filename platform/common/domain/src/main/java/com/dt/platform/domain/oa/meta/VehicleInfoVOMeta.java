package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.VehicleInfoVO;
import java.util.List;
import com.dt.platform.domain.oa.VehicleInfo;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.oa.VehicleInsuranceCompany;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 15:50:00
 * @sign 7513339456463B0B4DDBEE2A307F932F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VehicleInfoVOMeta extends VehicleInfoMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String VEHICLE_STATUS="vehicleStatus";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> VEHICLE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,VEHICLE_STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 车辆类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 车辆类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,TYPE, java.lang.String.class, "车辆类型", "车辆类型", java.lang.String.class, null);
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final String VEHICLE_CODE="vehicleCode";
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> VEHICLE_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,VEHICLE_CODE, java.lang.String.class, "车牌号", "车牌号", java.lang.String.class, null);
	
	/**
	 * 品牌型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 品牌型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,MODEL, java.lang.String.class, "品牌型号", "品牌型号", java.lang.String.class, null);
	
	/**
	 * 登记人 , 类型: java.lang.String
	*/
	public static final String REGISTRANT="registrant";
	
	/**
	 * 登记人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> REGISTRANT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,REGISTRANT, java.lang.String.class, "登记人", "登记人", java.lang.String.class, null);
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final String OWNER_ORG_ID="ownerOrgId";
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> OWNER_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,OWNER_ORG_ID, java.lang.String.class, "所属组织", "所属组织", java.lang.String.class, null);
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final String MANAGE_USER_ID="manageUserId";
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> MANAGE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,MANAGE_USER_ID, java.lang.String.class, "使用人", "使用人", java.lang.String.class, null);
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,USE_ORG_ID, java.lang.String.class, "使用部门", "使用部门", java.lang.String.class, null);
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,USE_USER_ID, java.lang.String.class, "使用人", "使用人", java.lang.String.class, null);
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final String COLOR="color";
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> COLOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,COLOR, java.lang.String.class, "颜色", "颜色", java.lang.String.class, null);
	
	/**
	 * 发动机号 , 类型: java.lang.String
	*/
	public static final String ENGINE_NUMBER="engineNumber";
	
	/**
	 * 发动机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> ENGINE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,ENGINE_NUMBER, java.lang.String.class, "发动机号", "发动机号", java.lang.String.class, null);
	
	/**
	 * 行驶证 , 类型: java.lang.String
	*/
	public static final String DRIVING_LICENSE="drivingLicense";
	
	/**
	 * 行驶证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> DRIVING_LICENSE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,DRIVING_LICENSE, java.lang.String.class, "行驶证", "行驶证", java.lang.String.class, null);
	
	/**
	 * 车架号 , 类型: java.lang.String
	*/
	public static final String FRAME_NUMBER="frameNumber";
	
	/**
	 * 车架号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> FRAME_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,FRAME_NUMBER, java.lang.String.class, "车架号", "车架号", java.lang.String.class, null);
	
	/**
	 * 公里数 , 类型: java.math.BigDecimal
	*/
	public static final String KILOMETERS="kilometers";
	
	/**
	 * 公里数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.math.BigDecimal> KILOMETERS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,KILOMETERS, java.math.BigDecimal.class, "公里数", "公里数", java.math.BigDecimal.class, null);
	
	/**
	 * 车船税 , 类型: java.math.BigDecimal
	*/
	public static final String CAR_BOAT_TAX="carBoatTax";
	
	/**
	 * 车船税 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.math.BigDecimal> CAR_BOAT_TAX_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,CAR_BOAT_TAX, java.math.BigDecimal.class, "车船税", "车船税", java.math.BigDecimal.class, null);
	
	/**
	 * 抢险 , 元) , 类型: java.math.BigDecimal
	*/
	public static final String RESCUE_MONEY="rescueMoney";
	
	/**
	 * 抢险 , 元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.math.BigDecimal> RESCUE_MONEY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,RESCUE_MONEY, java.math.BigDecimal.class, "抢险", "元)", java.math.BigDecimal.class, null);
	
	/**
	 * 商业险 , 元) , 类型: java.math.BigDecimal
	*/
	public static final String COMMERCIAL_INSURANCE_MONEY="commercialInsuranceMoney";
	
	/**
	 * 商业险 , 元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.math.BigDecimal> COMMERCIAL_INSURANCE_MONEY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,COMMERCIAL_INSURANCE_MONEY, java.math.BigDecimal.class, "商业险", "元)", java.math.BigDecimal.class, null);
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final String INSURANCE_COMPANY="insuranceCompany";
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> INSURANCE_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,INSURANCE_COMPANY, java.lang.String.class, "保险公司", "保险公司", java.lang.String.class, null);
	
	/**
	 * 上牌时间 , 类型: java.util.Date
	*/
	public static final String LICENSING_TIME="licensingTime";
	
	/**
	 * 上牌时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> LICENSING_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,LICENSING_TIME, java.util.Date.class, "上牌时间", "上牌时间", java.util.Date.class, null);
	
	/**
	 * 商业险到期 , 类型: java.util.Date
	*/
	public static final String INSURANCE_EXPIRE_DATE="insuranceExpireDate";
	
	/**
	 * 商业险到期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> INSURANCE_EXPIRE_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,INSURANCE_EXPIRE_DATE, java.util.Date.class, "商业险到期", "商业险到期", java.util.Date.class, null);
	
	/**
	 * 抢险到期 , 类型: java.util.Date
	*/
	public static final String RESCUE_DUE_DATE="rescueDueDate";
	
	/**
	 * 抢险到期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> RESCUE_DUE_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,RESCUE_DUE_DATE, java.util.Date.class, "抢险到期", "抢险到期", java.util.Date.class, null);
	
	/**
	 * 承载人数 , 类型: java.lang.Integer
	*/
	public static final String MAXIMUM_PASSENGERS="maximumPassengers";
	
	/**
	 * 承载人数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.Integer> MAXIMUM_PASSENGERS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,MAXIMUM_PASSENGERS, java.lang.Integer.class, "承载人数", "承载人数", java.lang.Integer.class, null);
	
	/**
	 * 报废时间 , 类型: java.util.Date
	*/
	public static final String SCRAP_TIME="scrapTime";
	
	/**
	 * 报废时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> SCRAP_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,SCRAP_TIME, java.util.Date.class, "报废时间", "报废时间", java.util.Date.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,POSITION_ID, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 位置详情 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 位置详情 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,POSITION_DETAIL, java.lang.String.class, "位置详情", "位置详情", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURES="pictures";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> PICTURES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,PICTURES, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 技术参数 , 类型: java.lang.String
	*/
	public static final String TECHNICAL_PARAMETER="technicalParameter";
	
	/**
	 * 技术参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> TECHNICAL_PARAMETER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,TECHNICAL_PARAMETER, java.lang.String.class, "技术参数", "技术参数", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String VEHICLE_TYPE_DICT="vehicleTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,org.github.foxnic.web.domain.system.DictItem> VEHICLE_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,VEHICLE_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String VEHICLE_STATUS_DICT="vehicleStatusDict";
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,org.github.foxnic.web.domain.system.DictItem> VEHICLE_STATUS_DICT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,VEHICLE_STATUS_DICT, org.github.foxnic.web.domain.system.DictItem.class, "状态", "状态", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 使用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "使用人", "使用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * vehicleInsuranceCompany , 类型: com.dt.platform.domain.oa.VehicleInsuranceCompany
	*/
	public static final String VEHICLE_INSURANCE_COMPANY="vehicleInsuranceCompany";
	
	/**
	 * vehicleInsuranceCompany , 类型: com.dt.platform.domain.oa.VehicleInsuranceCompany
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,com.dt.platform.domain.oa.VehicleInsuranceCompany> VEHICLE_INSURANCE_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,VEHICLE_INSURANCE_COMPANY, com.dt.platform.domain.oa.VehicleInsuranceCompany.class, "vehicleInsuranceCompany", "vehicleInsuranceCompany", com.dt.platform.domain.oa.VehicleInsuranceCompany.class, null);
	
	/**
	 * 车辆列表 , 类型: java.lang.String
	*/
	public static final String SELECT_IDS="selectIds";
	
	/**
	 * 车辆列表 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfoVO,java.lang.String> SELECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfoVO.class ,SELECT_IDS, java.lang.String.class, "车辆列表", "车辆列表", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , VEHICLE_STATUS , TYPE , VEHICLE_CODE , MODEL , REGISTRANT , OWNER_ORG_ID , MANAGE_USER_ID , USE_ORG_ID , USE_USER_ID , COLOR , ENGINE_NUMBER , DRIVING_LICENSE , FRAME_NUMBER , KILOMETERS , CAR_BOAT_TAX , RESCUE_MONEY , COMMERCIAL_INSURANCE_MONEY , INSURANCE_COMPANY , LICENSING_TIME , INSURANCE_EXPIRE_DATE , RESCUE_DUE_DATE , MAXIMUM_PASSENGERS , SCRAP_TIME , POSITION_ID , POSITION_DETAIL , PICTURES , TECHNICAL_PARAMETER , ORIGINATOR_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , OWNER_COMPANY , USE_ORGANIZATION , VEHICLE_TYPE_DICT , VEHICLE_STATUS_DICT , ORIGINATOR , USE_USER , VEHICLE_INSURANCE_COMPANY , SELECT_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.VehicleInfoVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public VehicleInfoVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public VehicleInfoVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public VehicleInfoVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public VehicleInfoVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public VehicleInfoVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public VehicleInfoVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public VehicleInfoVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public VehicleInfoVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public VehicleInfoVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public VehicleInfoVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public VehicleInfoVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public VehicleInfoVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public VehicleInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public VehicleInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param vehicleStatus 状态
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleStatus(String vehicleStatus) {
			super.change(VEHICLE_STATUS,super.getVehicleStatus(),vehicleStatus);
			super.setVehicleStatus(vehicleStatus);
			return this;
		}
		
		/**
		 * 设置 车辆类型
		 * @param type 车辆类型
		 * @return 当前对象
		*/
		public VehicleInfo setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 车牌号
		 * @param vehicleCode 车牌号
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleCode(String vehicleCode) {
			super.change(VEHICLE_CODE,super.getVehicleCode(),vehicleCode);
			super.setVehicleCode(vehicleCode);
			return this;
		}
		
		/**
		 * 设置 品牌型号
		 * @param model 品牌型号
		 * @return 当前对象
		*/
		public VehicleInfo setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 登记人
		 * @param registrant 登记人
		 * @return 当前对象
		*/
		public VehicleInfo setRegistrant(String registrant) {
			super.change(REGISTRANT,super.getRegistrant(),registrant);
			super.setRegistrant(registrant);
			return this;
		}
		
		/**
		 * 设置 所属组织
		 * @param ownerOrgId 所属组织
		 * @return 当前对象
		*/
		public VehicleInfo setOwnerOrgId(String ownerOrgId) {
			super.change(OWNER_ORG_ID,super.getOwnerOrgId(),ownerOrgId);
			super.setOwnerOrgId(ownerOrgId);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param manageUserId 使用人
		 * @return 当前对象
		*/
		public VehicleInfo setManageUserId(String manageUserId) {
			super.change(MANAGE_USER_ID,super.getManageUserId(),manageUserId);
			super.setManageUserId(manageUserId);
			return this;
		}
		
		/**
		 * 设置 使用部门
		 * @param useOrgId 使用部门
		 * @return 当前对象
		*/
		public VehicleInfo setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param useUserId 使用人
		 * @return 当前对象
		*/
		public VehicleInfo setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 颜色
		 * @param color 颜色
		 * @return 当前对象
		*/
		public VehicleInfo setColor(String color) {
			super.change(COLOR,super.getColor(),color);
			super.setColor(color);
			return this;
		}
		
		/**
		 * 设置 发动机号
		 * @param engineNumber 发动机号
		 * @return 当前对象
		*/
		public VehicleInfo setEngineNumber(String engineNumber) {
			super.change(ENGINE_NUMBER,super.getEngineNumber(),engineNumber);
			super.setEngineNumber(engineNumber);
			return this;
		}
		
		/**
		 * 设置 行驶证
		 * @param drivingLicense 行驶证
		 * @return 当前对象
		*/
		public VehicleInfo setDrivingLicense(String drivingLicense) {
			super.change(DRIVING_LICENSE,super.getDrivingLicense(),drivingLicense);
			super.setDrivingLicense(drivingLicense);
			return this;
		}
		
		/**
		 * 设置 车架号
		 * @param frameNumber 车架号
		 * @return 当前对象
		*/
		public VehicleInfo setFrameNumber(String frameNumber) {
			super.change(FRAME_NUMBER,super.getFrameNumber(),frameNumber);
			super.setFrameNumber(frameNumber);
			return this;
		}
		
		/**
		 * 设置 公里数
		 * @param kilometers 公里数
		 * @return 当前对象
		*/
		public VehicleInfo setKilometers(BigDecimal kilometers) {
			super.change(KILOMETERS,super.getKilometers(),kilometers);
			super.setKilometers(kilometers);
			return this;
		}
		
		/**
		 * 设置 车船税
		 * @param carBoatTax 车船税
		 * @return 当前对象
		*/
		public VehicleInfo setCarBoatTax(BigDecimal carBoatTax) {
			super.change(CAR_BOAT_TAX,super.getCarBoatTax(),carBoatTax);
			super.setCarBoatTax(carBoatTax);
			return this;
		}
		
		/**
		 * 设置 抢险
		 * @param rescueMoney 抢险
		 * @return 当前对象
		*/
		public VehicleInfo setRescueMoney(BigDecimal rescueMoney) {
			super.change(RESCUE_MONEY,super.getRescueMoney(),rescueMoney);
			super.setRescueMoney(rescueMoney);
			return this;
		}
		
		/**
		 * 设置 商业险
		 * @param commercialInsuranceMoney 商业险
		 * @return 当前对象
		*/
		public VehicleInfo setCommercialInsuranceMoney(BigDecimal commercialInsuranceMoney) {
			super.change(COMMERCIAL_INSURANCE_MONEY,super.getCommercialInsuranceMoney(),commercialInsuranceMoney);
			super.setCommercialInsuranceMoney(commercialInsuranceMoney);
			return this;
		}
		
		/**
		 * 设置 保险公司
		 * @param insuranceCompany 保险公司
		 * @return 当前对象
		*/
		public VehicleInfo setInsuranceCompany(String insuranceCompany) {
			super.change(INSURANCE_COMPANY,super.getInsuranceCompany(),insuranceCompany);
			super.setInsuranceCompany(insuranceCompany);
			return this;
		}
		
		/**
		 * 设置 上牌时间
		 * @param licensingTime 上牌时间
		 * @return 当前对象
		*/
		public VehicleInfo setLicensingTime(Date licensingTime) {
			super.change(LICENSING_TIME,super.getLicensingTime(),licensingTime);
			super.setLicensingTime(licensingTime);
			return this;
		}
		
		/**
		 * 设置 商业险到期
		 * @param insuranceExpireDate 商业险到期
		 * @return 当前对象
		*/
		public VehicleInfo setInsuranceExpireDate(Date insuranceExpireDate) {
			super.change(INSURANCE_EXPIRE_DATE,super.getInsuranceExpireDate(),insuranceExpireDate);
			super.setInsuranceExpireDate(insuranceExpireDate);
			return this;
		}
		
		/**
		 * 设置 抢险到期
		 * @param rescueDueDate 抢险到期
		 * @return 当前对象
		*/
		public VehicleInfo setRescueDueDate(Date rescueDueDate) {
			super.change(RESCUE_DUE_DATE,super.getRescueDueDate(),rescueDueDate);
			super.setRescueDueDate(rescueDueDate);
			return this;
		}
		
		/**
		 * 设置 承载人数
		 * @param maximumPassengers 承载人数
		 * @return 当前对象
		*/
		public VehicleInfo setMaximumPassengers(Integer maximumPassengers) {
			super.change(MAXIMUM_PASSENGERS,super.getMaximumPassengers(),maximumPassengers);
			super.setMaximumPassengers(maximumPassengers);
			return this;
		}
		
		/**
		 * 设置 报废时间
		 * @param scrapTime 报废时间
		 * @return 当前对象
		*/
		public VehicleInfo setScrapTime(Date scrapTime) {
			super.change(SCRAP_TIME,super.getScrapTime(),scrapTime);
			super.setScrapTime(scrapTime);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param positionId 存放位置
		 * @return 当前对象
		*/
		public VehicleInfo setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 位置详情
		 * @param positionDetail 位置详情
		 * @return 当前对象
		*/
		public VehicleInfo setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictures 图片
		 * @return 当前对象
		*/
		public VehicleInfo setPictures(String pictures) {
			super.change(PICTURES,super.getPictures(),pictures);
			super.setPictures(pictures);
			return this;
		}
		
		/**
		 * 设置 技术参数
		 * @param technicalParameter 技术参数
		 * @return 当前对象
		*/
		public VehicleInfo setTechnicalParameter(String technicalParameter) {
			super.change(TECHNICAL_PARAMETER,super.getTechnicalParameter(),technicalParameter);
			super.setTechnicalParameter(technicalParameter);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public VehicleInfo setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public VehicleInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public VehicleInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VehicleInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VehicleInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VehicleInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VehicleInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VehicleInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VehicleInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VehicleInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public VehicleInfo setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public VehicleInfo setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public VehicleInfo setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param vehicleTypeDict 类型
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleTypeDict(DictItem vehicleTypeDict) {
			super.change(VEHICLE_TYPE_DICT,super.getVehicleTypeDict(),vehicleTypeDict);
			super.setVehicleTypeDict(vehicleTypeDict);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param vehicleStatusDict 状态
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleStatusDict(DictItem vehicleStatusDict) {
			super.change(VEHICLE_STATUS_DICT,super.getVehicleStatusDict(),vehicleStatusDict);
			super.setVehicleStatusDict(vehicleStatusDict);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public VehicleInfo setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param useUser 使用人
		 * @return 当前对象
		*/
		public VehicleInfo setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}
		
		/**
		 * 设置 vehicleInsuranceCompany
		 * @param vehicleInsuranceCompany vehicleInsuranceCompany
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleInsuranceCompany(VehicleInsuranceCompany vehicleInsuranceCompany) {
			super.change(VEHICLE_INSURANCE_COMPANY,super.getVehicleInsuranceCompany(),vehicleInsuranceCompany);
			super.setVehicleInsuranceCompany(vehicleInsuranceCompany);
			return this;
		}
		
		/**
		 * 设置 车辆列表
		 * @param selectIds 车辆列表
		 * @return 当前对象
		*/
		public VehicleInfo setSelectIds(String selectIds) {
			super.change(SELECT_IDS,super.getSelectIds(),selectIds);
			super.setSelectIds(selectIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public VehicleInfoVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public VehicleInfoVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRescueDueDate(this.getRescueDueDate());
			inst.setNotes(this.getNotes());
			inst.setColor(this.getColor());
			inst.setMaximumPassengers(this.getMaximumPassengers());
			inst.setRescueMoney(this.getRescueMoney());
			inst.setType(this.getType());
			inst.setManageUserId(this.getManageUserId());
			inst.setScrapTime(this.getScrapTime());
			inst.setPictures(this.getPictures());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setCommercialInsuranceMoney(this.getCommercialInsuranceMoney());
			inst.setModel(this.getModel());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setInsuranceCompany(this.getInsuranceCompany());
			inst.setFrameNumber(this.getFrameNumber());
			inst.setUseOrgId(this.getUseOrgId());
			inst.setEngineNumber(this.getEngineNumber());
			inst.setVehicleCode(this.getVehicleCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setInsuranceExpireDate(this.getInsuranceExpireDate());
			inst.setVersion(this.getVersion());
			inst.setPositionDetail(this.getPositionDetail());
			inst.setTechnicalParameter(this.getTechnicalParameter());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPositionId(this.getPositionId());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDrivingLicense(this.getDrivingLicense());
			inst.setKilometers(this.getKilometers());
			inst.setName(this.getName());
			inst.setLicensingTime(this.getLicensingTime());
			inst.setTenantId(this.getTenantId());
			inst.setOwnerOrgId(this.getOwnerOrgId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setRegistrant(this.getRegistrant());
			inst.setCarBoatTax(this.getCarBoatTax());
			inst.setUseUserId(this.getUseUserId());
			inst.setVehicleStatus(this.getVehicleStatus());
			if(all) {
				inst.setOwnerCompany(this.getOwnerCompany());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setVehicleStatusDict(this.getVehicleStatusDict());
				inst.setOriginator(this.getOriginator());
				inst.setSelectIds(this.getSelectIds());
				inst.setUseOrganization(this.getUseOrganization());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setVehicleInsuranceCompany(this.getVehicleInsuranceCompany());
				inst.setVehicleTypeDict(this.getVehicleTypeDict());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setUseUser(this.getUseUser());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}