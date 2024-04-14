package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.ProductFunction;
import java.util.Date;
import com.dt.platform.domain.eam.ProductFunctionItem;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:04
 * @sign 053A533E862816197AB81C86711D7DBB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductFunctionMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 功能类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 功能类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,TYPE, java.lang.String.class, "功能类型", "功能类型", java.lang.String.class, null);
	
	/**
	 * 产品 , 类型: java.lang.String
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 产品 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> PRODUCT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,PRODUCT_ID, java.lang.String.class, "产品", "产品", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 标识符 , 类型: java.lang.String
	*/
	public static final String IDENTIFIER="identifier";
	
	/**
	 * 标识符 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> IDENTIFIER_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,IDENTIFIER, java.lang.String.class, "标识符", "标识符", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String FUNCTION_DESC="functionDesc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> FUNCTION_DESC_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,FUNCTION_DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 单位 , 类型: java.lang.String
	*/
	public static final String FUNCTION_UNIT="functionUnit";
	
	/**
	 * 单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> FUNCTION_UNIT_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,FUNCTION_UNIT, java.lang.String.class, "单位", "单位", java.lang.String.class, null);
	
	/**
	 * 数据类型 , 类型: java.lang.String
	*/
	public static final String DATA_TYPE="dataType";
	
	/**
	 * 数据类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> DATA_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,DATA_TYPE, java.lang.String.class, "数据类型", "数据类型", java.lang.String.class, null);
	
	/**
	 * 内容定义 , 类型: java.lang.String
	*/
	public static final String DATA_VALUE="dataValue";
	
	/**
	 * 内容定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> DATA_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,DATA_VALUE, java.lang.String.class, "内容定义", "内容定义", java.lang.String.class, null);
	
	/**
	 * 读写 , 类型: java.lang.String
	*/
	public static final String ACL="acl";
	
	/**
	 * 读写 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> ACL_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,ACL, java.lang.String.class, "读写", "读写", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * inputFunctionParams , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunctionItem
	*/
	public static final String INPUT_FUNCTION_PARAMS="inputFunctionParams";
	
	/**
	 * inputFunctionParams , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunctionItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,com.dt.platform.domain.eam.ProductFunctionItem> INPUT_FUNCTION_PARAMS_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,INPUT_FUNCTION_PARAMS, java.util.List.class, "inputFunctionParams", "inputFunctionParams", com.dt.platform.domain.eam.ProductFunctionItem.class, null);
	
	/**
	 * outputFunctionParams , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunctionItem
	*/
	public static final String OUTPUT_FUNCTION_PARAMS="outputFunctionParams";
	
	/**
	 * outputFunctionParams , 集合类型: LIST , 类型: com.dt.platform.domain.eam.ProductFunctionItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ProductFunction,com.dt.platform.domain.eam.ProductFunctionItem> OUTPUT_FUNCTION_PARAMS_PROP = new BeanProperty(com.dt.platform.domain.eam.ProductFunction.class ,OUTPUT_FUNCTION_PARAMS, java.util.List.class, "outputFunctionParams", "outputFunctionParams", com.dt.platform.domain.eam.ProductFunctionItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , PRODUCT_ID , NAME , IDENTIFIER , FUNCTION_DESC , FUNCTION_UNIT , DATA_TYPE , DATA_VALUE , ACL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , INPUT_FUNCTION_PARAMS , OUTPUT_FUNCTION_PARAMS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.ProductFunction {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ProductFunction setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 功能类型
		 * @param type 功能类型
		 * @return 当前对象
		*/
		public ProductFunction setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 产品
		 * @param productId 产品
		 * @return 当前对象
		*/
		public ProductFunction setProductId(String productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ProductFunction setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 标识符
		 * @param identifier 标识符
		 * @return 当前对象
		*/
		public ProductFunction setIdentifier(String identifier) {
			super.change(IDENTIFIER,super.getIdentifier(),identifier);
			super.setIdentifier(identifier);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param functionDesc 描述
		 * @return 当前对象
		*/
		public ProductFunction setFunctionDesc(String functionDesc) {
			super.change(FUNCTION_DESC,super.getFunctionDesc(),functionDesc);
			super.setFunctionDesc(functionDesc);
			return this;
		}
		
		/**
		 * 设置 单位
		 * @param functionUnit 单位
		 * @return 当前对象
		*/
		public ProductFunction setFunctionUnit(String functionUnit) {
			super.change(FUNCTION_UNIT,super.getFunctionUnit(),functionUnit);
			super.setFunctionUnit(functionUnit);
			return this;
		}
		
		/**
		 * 设置 数据类型
		 * @param dataType 数据类型
		 * @return 当前对象
		*/
		public ProductFunction setDataType(String dataType) {
			super.change(DATA_TYPE,super.getDataType(),dataType);
			super.setDataType(dataType);
			return this;
		}
		
		/**
		 * 设置 内容定义
		 * @param dataValue 内容定义
		 * @return 当前对象
		*/
		public ProductFunction setDataValue(String dataValue) {
			super.change(DATA_VALUE,super.getDataValue(),dataValue);
			super.setDataValue(dataValue);
			return this;
		}
		
		/**
		 * 设置 读写
		 * @param acl 读写
		 * @return 当前对象
		*/
		public ProductFunction setAcl(String acl) {
			super.change(ACL,super.getAcl(),acl);
			super.setAcl(acl);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProductFunction setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProductFunction setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProductFunction setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProductFunction setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProductFunction setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProductFunction setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProductFunction setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ProductFunction setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ProductFunction setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 inputFunctionParams
		 * @param inputFunctionParams inputFunctionParams
		 * @return 当前对象
		*/
		public ProductFunction setInputFunctionParams(List<ProductFunctionItem> inputFunctionParams) {
			super.change(INPUT_FUNCTION_PARAMS,super.getInputFunctionParams(),inputFunctionParams);
			super.setInputFunctionParams(inputFunctionParams);
			return this;
		}
		
		/**
		 * 设置 outputFunctionParams
		 * @param outputFunctionParams outputFunctionParams
		 * @return 当前对象
		*/
		public ProductFunction setOutputFunctionParams(List<ProductFunctionItem> outputFunctionParams) {
			super.change(OUTPUT_FUNCTION_PARAMS,super.getOutputFunctionParams(),outputFunctionParams);
			super.setOutputFunctionParams(outputFunctionParams);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProductFunction clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProductFunction duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setIdentifier(this.getIdentifier());
			inst.setProductId(this.getProductId());
			inst.setDataType(this.getDataType());
			inst.setDataValue(this.getDataValue());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setFunctionDesc(this.getFunctionDesc());
			inst.setAcl(this.getAcl());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFunctionUnit(this.getFunctionUnit());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setInputFunctionParams(this.getInputFunctionParams());
				inst.setOutputFunctionParams(this.getOutputFunctionParams());
			}
			inst.clearModifies();
			return inst;
		}

	}
}