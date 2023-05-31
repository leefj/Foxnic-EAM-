package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.ScreenProject;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:12:23
 * @sign 8477214B8D5778CB57F7B802BBA161CF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScreenProjectMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 项目 , 类型: java.lang.String
	*/
	public static final String PROJECT_NAME="projectName";
	
	/**
	 * 项目 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> PROJECT_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,PROJECT_NAME, java.lang.String.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATE="state";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> STATE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,STATE, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String INDEX_IMAGE="indexImage";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> INDEX_IMAGE_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,INDEX_IMAGE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String REMARKS="remarks";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> REMARKS_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,REMARKS, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.ScreenProject,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.ScreenProject.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROJECT_NAME , STATE , INDEX_IMAGE , REMARKS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.ScreenProject {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScreenProject setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectName 项目
		 * @return 当前对象
		*/
		public ScreenProject setProjectName(String projectName) {
			super.change(PROJECT_NAME,super.getProjectName(),projectName);
			super.setProjectName(projectName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param state 状态
		 * @return 当前对象
		*/
		public ScreenProject setState(String state) {
			super.change(STATE,super.getState(),state);
			super.setState(state);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param indexImage 备注
		 * @return 当前对象
		*/
		public ScreenProject setIndexImage(String indexImage) {
			super.change(INDEX_IMAGE,super.getIndexImage(),indexImage);
			super.setIndexImage(indexImage);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param remarks 备注
		 * @return 当前对象
		*/
		public ScreenProject setRemarks(String remarks) {
			super.change(REMARKS,super.getRemarks(),remarks);
			super.setRemarks(remarks);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScreenProject setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScreenProject setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScreenProject setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScreenProject setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScreenProject setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScreenProject setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScreenProject setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScreenProject setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ScreenProject setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScreenProject clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScreenProject duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setIndexImage(this.getIndexImage());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setState(this.getState());
			inst.setProjectName(this.getProjectName());
			inst.setRemarks(this.getRemarks());
			inst.clearModifies();
			return inst;
		}

	}
}