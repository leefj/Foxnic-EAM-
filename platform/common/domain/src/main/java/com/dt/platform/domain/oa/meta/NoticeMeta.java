package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.Notice;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:22:30
 * @sign 337B369AB4CEFAC44CB3C1904919F89A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NoticeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 文号 , 类型: java.lang.String
	*/
	public static final String NUMBER="number";
	
	/**
	 * 文号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> NUMBER_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,NUMBER, java.lang.String.class, "文号", "文号", java.lang.String.class, null);
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> TITLE_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,TITLE, java.lang.String.class, "标题", "标题", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,TYPE, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 是否置顶 , 类型: java.lang.String
	*/
	public static final String IFTOP="iftop";
	
	/**
	 * 是否置顶 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> IFTOP_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,IFTOP, java.lang.String.class, "是否置顶", "是否置顶", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 可见范围 , 类型: java.lang.String
	*/
	public static final String VISUAL_RANGE="visualRange";
	
	/**
	 * 可见范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> VISUAL_RANGE_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,VISUAL_RANGE, java.lang.String.class, "可见范围", "可见范围", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DATA="typeData";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.Notice,org.github.foxnic.web.domain.system.DictItem> TYPE_DATA_PROP = new BeanProperty(com.dt.platform.domain.oa.Notice.class ,TYPE_DATA, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NUMBER , TITLE , STATUS , TYPE , CONTENT , IFTOP , ATTACH , VISUAL_RANGE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TYPE_DATA };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.Notice {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Notice setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 文号
		 * @param number 文号
		 * @return 当前对象
		*/
		public Notice setNumber(String number) {
			super.change(NUMBER,super.getNumber(),number);
			super.setNumber(number);
			return this;
		}
		
		/**
		 * 设置 标题
		 * @param title 标题
		 * @return 当前对象
		*/
		public Notice setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Notice setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param type 分类
		 * @return 当前对象
		*/
		public Notice setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public Notice setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 是否置顶
		 * @param iftop 是否置顶
		 * @return 当前对象
		*/
		public Notice setIftop(String iftop) {
			super.change(IFTOP,super.getIftop(),iftop);
			super.setIftop(iftop);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public Notice setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 可见范围
		 * @param visualRange 可见范围
		 * @return 当前对象
		*/
		public Notice setVisualRange(String visualRange) {
			super.change(VISUAL_RANGE,super.getVisualRange(),visualRange);
			super.setVisualRange(visualRange);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Notice setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Notice setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Notice setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Notice setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Notice setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Notice setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Notice setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Notice setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Notice setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeData 类型
		 * @return 当前对象
		*/
		public Notice setTypeData(DictItem typeData) {
			super.change(TYPE_DATA,super.getTypeData(),typeData);
			super.setTypeData(typeData);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Notice clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Notice duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTitle(this.getTitle());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setIftop(this.getIftop());
			inst.setNumber(this.getNumber());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setVisualRange(this.getVisualRange());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setAttach(this.getAttach());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setTypeData(this.getTypeData());
			}
			inst.clearModifies();
			return inst;
		}

	}
}