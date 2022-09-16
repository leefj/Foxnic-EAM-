package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDepreciationDetail;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetDepreciationOper;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-28 06:41:50
 * @sign 5E832C61B8A047EC98221499C26774F0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDepreciationDetailMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final String DEPRECIATION_ID="depreciationId";
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> DEPRECIATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DEPRECIATION_ID, java.lang.String.class, "折旧方案", "折旧方案", java.lang.String.class, null);
	
	/**
	 * 折旧操作 , 类型: java.lang.String
	*/
	public static final String OPER_ID="operId";
	
	/**
	 * 折旧操作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> OPER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,OPER_ID, java.lang.String.class, "折旧操作", "折旧操作", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 折旧方式 , 类型: java.lang.String
	*/
	public static final String DEPRECIATION_METHOD="depreciationMethod";
	
	/**
	 * 折旧方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> DEPRECIATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DEPRECIATION_METHOD, java.lang.String.class, "折旧方式", "折旧方式", java.lang.String.class, null);
	
	/**
	 * 折旧结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 折旧结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,RESULT, java.lang.String.class, "折旧结果", "折旧结果", java.lang.String.class, null);
	
	/**
	 * 折旧结果明细 , 类型: java.lang.String
	*/
	public static final String RESULT_DETAIL="resultDetail";
	
	/**
	 * 折旧结果明细 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> RESULT_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,RESULT_DETAIL, java.lang.String.class, "折旧结果明细", "折旧结果明细", java.lang.String.class, null);
	
	/**
	 * 使用周期(月) , 类型: java.math.BigDecimal
	*/
	public static final String SERVICE_LIFE="serviceLife";
	
	/**
	 * 使用周期(月) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,SERVICE_LIFE, java.math.BigDecimal.class, "使用周期(月)", "使用周期(月)", java.math.BigDecimal.class, null);
	
	/**
	 * 残值率 , 类型: java.math.BigDecimal
	*/
	public static final String RESIDUAL_RATE="residualRate";
	
	/**
	 * 残值率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> RESIDUAL_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,RESIDUAL_RATE, java.math.BigDecimal.class, "残值率", "残值率", java.math.BigDecimal.class, null);
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,PURCHASE_DATE, java.util.Date.class, "采购日期", "采购日期", java.util.Date.class, null);
	
	/**
	 * 折旧前 , 类型: java.lang.String
	*/
	public static final String DETAIL_ID_SOURCE="detailIdSource";
	
	/**
	 * 折旧前 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> DETAIL_ID_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DETAIL_ID_SOURCE, java.lang.String.class, "折旧前", "折旧前", java.lang.String.class, null);
	
	/**
	 * 折旧后 , 类型: java.lang.String
	*/
	public static final String DETAIL_ID_TARGET="detailIdTarget";
	
	/**
	 * 折旧后 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> DETAIL_ID_TARGET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DETAIL_ID_TARGET, java.lang.String.class, "折旧后", "折旧后", java.lang.String.class, null);
	
	/**
	 * 采购价格 , 类型: java.math.BigDecimal
	*/
	public static final String PURCHASE_UNIT_PRICE="purchaseUnitPrice";
	
	/**
	 * 采购价格 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> PURCHASE_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,PURCHASE_UNIT_PRICE, java.math.BigDecimal.class, "采购价格", "采购价格", java.math.BigDecimal.class, null);
	
	/**
	 * 本期折旧 , 类型: java.math.BigDecimal
	*/
	public static final String DEPRECIATION_PRICE="depreciationPrice";
	
	/**
	 * 本期折旧 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> DEPRECIATION_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DEPRECIATION_PRICE, java.math.BigDecimal.class, "本期折旧", "本期折旧", java.math.BigDecimal.class, null);
	
	/**
	 * 当前净值 , 类型: java.math.BigDecimal
	*/
	public static final String CUR_PRICE="curPrice";
	
	/**
	 * 当前净值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> CUR_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,CUR_PRICE, java.math.BigDecimal.class, "当前净值", "当前净值", java.math.BigDecimal.class, null);
	
	/**
	 * 折旧前净值 , 类型: java.math.BigDecimal
	*/
	public static final String BEFORE_PRICE="beforePrice";
	
	/**
	 * 折旧前净值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> BEFORE_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,BEFORE_PRICE, java.math.BigDecimal.class, "折旧前净值", "折旧前净值", java.math.BigDecimal.class, null);
	
	/**
	 * 折旧后净值 , 类型: java.math.BigDecimal
	*/
	public static final String AFTER_PRICE="afterPrice";
	
	/**
	 * 折旧后净值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> AFTER_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,AFTER_PRICE, java.math.BigDecimal.class, "折旧后净值", "折旧后净值", java.math.BigDecimal.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_SOURCE="assetSource";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,com.dt.platform.domain.eam.Asset> ASSET_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_SOURCE, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_TARGET="assetTarget";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,com.dt.platform.domain.eam.Asset> ASSET_TARGET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_TARGET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.AssetDepreciation
	*/
	public static final String ASSET_DEPRECIATION="assetDepreciation";
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.AssetDepreciation
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,com.dt.platform.domain.eam.AssetDepreciation> ASSET_DEPRECIATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_DEPRECIATION, com.dt.platform.domain.eam.AssetDepreciation.class, "方案", "方案", com.dt.platform.domain.eam.AssetDepreciation.class, null);
	
	/**
	 * 操作 , 类型: com.dt.platform.domain.eam.AssetDepreciationOper
	*/
	public static final String ASSET_DEPRECIATION_OPER="assetDepreciationOper";
	
	/**
	 * 操作 , 类型: com.dt.platform.domain.eam.AssetDepreciationOper
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,com.dt.platform.domain.eam.AssetDepreciationOper> ASSET_DEPRECIATION_OPER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_DEPRECIATION_OPER, com.dt.platform.domain.eam.AssetDepreciationOper.class, "操作", "操作", com.dt.platform.domain.eam.AssetDepreciationOper.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String ASSET_CUR_NAME="assetCurName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_CUR_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_CUR_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String ASSET_CUR_MODEL="assetCurModel";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_CUR_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_CUR_MODEL, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String ASSET_CUR_CODE="assetCurCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_CUR_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_CUR_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DEPRECIATION_ID , OPER_ID , ASSET_ID , DEPRECIATION_METHOD , RESULT , RESULT_DETAIL , SERVICE_LIFE , RESIDUAL_RATE , PURCHASE_DATE , DETAIL_ID_SOURCE , DETAIL_ID_TARGET , PURCHASE_UNIT_PRICE , DEPRECIATION_PRICE , CUR_PRICE , BEFORE_PRICE , AFTER_PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET_SOURCE , ASSET_TARGET , ASSET , ASSET_DEPRECIATION , ASSET_DEPRECIATION_OPER , ASSET_CUR_NAME , ASSET_CUR_MODEL , ASSET_CUR_CODE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDepreciationDetail {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 折旧方案
		 * @param depreciationId 折旧方案
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDepreciationId(String depreciationId) {
			super.change(DEPRECIATION_ID,super.getDepreciationId(),depreciationId);
			super.setDepreciationId(depreciationId);
			return this;
		}
		
		/**
		 * 设置 折旧操作
		 * @param operId 折旧操作
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setOperId(String operId) {
			super.change(OPER_ID,super.getOperId(),operId);
			super.setOperId(operId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 折旧方式
		 * @param depreciationMethod 折旧方式
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDepreciationMethod(String depreciationMethod) {
			super.change(DEPRECIATION_METHOD,super.getDepreciationMethod(),depreciationMethod);
			super.setDepreciationMethod(depreciationMethod);
			return this;
		}
		
		/**
		 * 设置 折旧结果
		 * @param result 折旧结果
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 折旧结果明细
		 * @param resultDetail 折旧结果明细
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setResultDetail(String resultDetail) {
			super.change(RESULT_DETAIL,super.getResultDetail(),resultDetail);
			super.setResultDetail(resultDetail);
			return this;
		}
		
		/**
		 * 设置 使用周期(月)
		 * @param serviceLife 使用周期(月)
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setServiceLife(BigDecimal serviceLife) {
			super.change(SERVICE_LIFE,super.getServiceLife(),serviceLife);
			super.setServiceLife(serviceLife);
			return this;
		}
		
		/**
		 * 设置 残值率
		 * @param residualRate 残值率
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setResidualRate(BigDecimal residualRate) {
			super.change(RESIDUAL_RATE,super.getResidualRate(),residualRate);
			super.setResidualRate(residualRate);
			return this;
		}
		
		/**
		 * 设置 采购日期
		 * @param purchaseDate 采购日期
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setPurchaseDate(Date purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
			return this;
		}
		
		/**
		 * 设置 折旧前
		 * @param detailIdSource 折旧前
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDetailIdSource(String detailIdSource) {
			super.change(DETAIL_ID_SOURCE,super.getDetailIdSource(),detailIdSource);
			super.setDetailIdSource(detailIdSource);
			return this;
		}
		
		/**
		 * 设置 折旧后
		 * @param detailIdTarget 折旧后
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDetailIdTarget(String detailIdTarget) {
			super.change(DETAIL_ID_TARGET,super.getDetailIdTarget(),detailIdTarget);
			super.setDetailIdTarget(detailIdTarget);
			return this;
		}
		
		/**
		 * 设置 采购价格
		 * @param purchaseUnitPrice 采购价格
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
			super.change(PURCHASE_UNIT_PRICE,super.getPurchaseUnitPrice(),purchaseUnitPrice);
			super.setPurchaseUnitPrice(purchaseUnitPrice);
			return this;
		}
		
		/**
		 * 设置 本期折旧
		 * @param depreciationPrice 本期折旧
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDepreciationPrice(BigDecimal depreciationPrice) {
			super.change(DEPRECIATION_PRICE,super.getDepreciationPrice(),depreciationPrice);
			super.setDepreciationPrice(depreciationPrice);
			return this;
		}
		
		/**
		 * 设置 当前净值
		 * @param curPrice 当前净值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCurPrice(BigDecimal curPrice) {
			super.change(CUR_PRICE,super.getCurPrice(),curPrice);
			super.setCurPrice(curPrice);
			return this;
		}
		
		/**
		 * 设置 折旧前净值
		 * @param beforePrice 折旧前净值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setBeforePrice(BigDecimal beforePrice) {
			super.change(BEFORE_PRICE,super.getBeforePrice(),beforePrice);
			super.setBeforePrice(beforePrice);
			return this;
		}
		
		/**
		 * 设置 折旧后净值
		 * @param afterPrice 折旧后净值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAfterPrice(BigDecimal afterPrice) {
			super.change(AFTER_PRICE,super.getAfterPrice(),afterPrice);
			super.setAfterPrice(afterPrice);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetSource 资产
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetSource(Asset assetSource) {
			super.change(ASSET_SOURCE,super.getAssetSource(),assetSource);
			super.setAssetSource(assetSource);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetTarget 资产
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetTarget(Asset assetTarget) {
			super.change(ASSET_TARGET,super.getAssetTarget(),assetTarget);
			super.setAssetTarget(assetTarget);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param assetDepreciation 方案
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetDepreciation(AssetDepreciation assetDepreciation) {
			super.change(ASSET_DEPRECIATION,super.getAssetDepreciation(),assetDepreciation);
			super.setAssetDepreciation(assetDepreciation);
			return this;
		}
		
		/**
		 * 设置 操作
		 * @param assetDepreciationOper 操作
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetDepreciationOper(AssetDepreciationOper assetDepreciationOper) {
			super.change(ASSET_DEPRECIATION_OPER,super.getAssetDepreciationOper(),assetDepreciationOper);
			super.setAssetDepreciationOper(assetDepreciationOper);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param assetCurName 名称
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetCurName(String assetCurName) {
			super.change(ASSET_CUR_NAME,super.getAssetCurName(),assetCurName);
			super.setAssetCurName(assetCurName);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param assetCurModel 类型
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetCurModel(String assetCurModel) {
			super.change(ASSET_CUR_MODEL,super.getAssetCurModel(),assetCurModel);
			super.setAssetCurModel(assetCurModel);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param assetCurCode 编码
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetCurCode(String assetCurCode) {
			super.change(ASSET_CUR_CODE,super.getAssetCurCode(),assetCurCode);
			super.setAssetCurCode(assetCurCode);
			return this;
		}
	}
}