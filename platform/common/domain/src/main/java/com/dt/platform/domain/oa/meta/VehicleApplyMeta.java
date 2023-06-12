package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.VehicleApply;
import java.util.Date;
import com.dt.platform.domain.oa.VehicleInfo;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:02:14
 * @sign 559D4C33E519F7E9CFA3CCEB27D26C7E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VehicleApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,ORG_ID, java.lang.String.class, "部门", "部门", java.lang.String.class, null);
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final String RECEIVER_ID="receiverId";
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> RECEIVER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,RECEIVER_ID, java.lang.String.class, "领用人", "领用人", java.lang.String.class, null);
	
	/**
	 * 驾驶员 , 类型: java.lang.String
	*/
	public static final String DRIVER="driver";
	
	/**
	 * 驾驶员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> DRIVER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,DRIVER, java.lang.String.class, "驾驶员", "驾驶员", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT="contact";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> CONTACT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,CONTACT, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 领用时间 , 类型: java.util.Date
	*/
	public static final String COLLECTION_DATE="collectionDate";
	
	/**
	 * 领用时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.util.Date> COLLECTION_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,COLLECTION_DATE, java.util.Date.class, "领用时间", "领用时间", java.util.Date.class, null);
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final String PLAN_RETURN_DATE="planReturnDate";
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.util.Date> PLAN_RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,PLAN_RETURN_DATE, java.util.Date.class, "预计归还时间", "预计归还时间", java.util.Date.class, null);
	
	/**
	 * 实际归还时间 , 类型: java.util.Date
	*/
	public static final String ACT_RETURN_DATE="actReturnDate";
	
	/**
	 * 实际归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.util.Date> ACT_RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,ACT_RETURN_DATE, java.util.Date.class, "实际归还时间", "实际归还时间", java.util.Date.class, null);
	
	/**
	 * 是否归还 , 类型: java.lang.String
	*/
	public static final String IF_RETURN="ifReturn";
	
	/**
	 * 是否归还 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> IF_RETURN_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,IF_RETURN, java.lang.String.class, "是否归还", "是否归还", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 车辆 , 类型: java.lang.String
	*/
	public static final String VEHICLE_ID="vehicleId";
	
	/**
	 * 车辆 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> VEHICLE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,VEHICLE_ID, java.lang.String.class, "车辆", "车辆", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 归还备注 , 类型: java.lang.String
	*/
	public static final String RETURN_NOTES="returnNotes";
	
	/**
	 * 归还备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> RETURN_NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,RETURN_NOTES, java.lang.String.class, "归还备注", "归还备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 车辆 , 类型: com.dt.platform.domain.oa.VehicleInfo
	*/
	public static final String VEHICLE_INFO="vehicleInfo";
	
	/**
	 * 车辆 , 类型: com.dt.platform.domain.oa.VehicleInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,com.dt.platform.domain.oa.VehicleInfo> VEHICLE_INFO_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,VEHICLE_INFO, com.dt.platform.domain.oa.VehicleInfo.class, "车辆", "车辆", com.dt.platform.domain.oa.VehicleInfo.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String RECEIVER="receiver";
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,org.github.foxnic.web.domain.hrm.Employee> RECEIVER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,RECEIVER, org.github.foxnic.web.domain.hrm.Employee.class, "领用人", "领用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleApply,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleApply.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , STATUS , NAME , ORG_ID , RECEIVER_ID , DRIVER , CONTACT , COLLECTION_DATE , PLAN_RETURN_DATE , ACT_RETURN_DATE , IF_RETURN , CONTENT , ATTACH , VEHICLE_ID , NOTES , RETURN_NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , VEHICLE_INFO , ORIGINATOR , RECEIVER , USE_ORGANIZATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.VehicleApply {

		private static final long serialVersionUID = 1L;

		
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
		public VehicleApply clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public VehicleApply duplicate(boolean all) {
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
				inst.setUseOrganization(this.getUseOrganization());
				inst.setReceiver(this.getReceiver());
				inst.setVehicleInfo(this.getVehicleInfo());
				inst.setOriginator(this.getOriginator());
			}
			inst.clearModifies();
			return inst;
		}

	}
}