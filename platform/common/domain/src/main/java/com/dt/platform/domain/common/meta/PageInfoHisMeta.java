package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PageInfoHis;
import java.util.Date;
import com.dt.platform.domain.common.PageInfo;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-12 13:59:52
 * @sign CA96C56698E4B69C93F20BE899E0ABF0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PageInfoHisMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String PAGE_ID="pageId";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.String> PAGE_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,PAGE_ID, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 定义 , 类型: java.lang.String
	*/
	public static final String DEF_JSON="defJson";
	
	/**
	 * 定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.String> DEF_JSON_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,DEF_JSON, java.lang.String.class, "定义", "定义", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * pageInfo , 类型: com.dt.platform.domain.common.PageInfo
	*/
	public static final String PAGE_INFO="pageInfo";
	
	/**
	 * pageInfo , 类型: com.dt.platform.domain.common.PageInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PageInfoHis,com.dt.platform.domain.common.PageInfo> PAGE_INFO_PROP = new BeanProperty(com.dt.platform.domain.common.PageInfoHis.class ,PAGE_INFO, com.dt.platform.domain.common.PageInfo.class, "pageInfo", "pageInfo", com.dt.platform.domain.common.PageInfo.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PAGE_ID , DEF_JSON , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PAGE_INFO };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PageInfoHis {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PageInfoHis setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param pageId 名称
		 * @return 当前对象
		*/
		public PageInfoHis setPageId(String pageId) {
			super.change(PAGE_ID,super.getPageId(),pageId);
			super.setPageId(pageId);
			return this;
		}
		
		/**
		 * 设置 定义
		 * @param defJson 定义
		 * @return 当前对象
		*/
		public PageInfoHis setDefJson(String defJson) {
			super.change(DEF_JSON,super.getDefJson(),defJson);
			super.setDefJson(defJson);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PageInfoHis setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PageInfoHis setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PageInfoHis setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PageInfoHis setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PageInfoHis setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PageInfoHis setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PageInfoHis setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PageInfoHis setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 pageInfo
		 * @param pageInfo pageInfo
		 * @return 当前对象
		*/
		public PageInfoHis setPageInfo(PageInfo pageInfo) {
			super.change(PAGE_INFO,super.getPageInfo(),pageInfo);
			super.setPageInfo(pageInfo);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PageInfoHis clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PageInfoHis duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDefJson(this.getDefJson());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setPageId(this.getPageId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setPageInfo(this.getPageInfo());
			}
			inst.clearModifies();
			return inst;
		}

	}
}