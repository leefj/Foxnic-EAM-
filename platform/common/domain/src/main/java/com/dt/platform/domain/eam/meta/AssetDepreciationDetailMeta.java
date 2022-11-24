package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDepreciationDetail;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetDepreciationOper;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-24 12:59:20
 * @sign 10083182B077492B9274585BAB0E4D6D
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
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 资产类别 , 类型: java.lang.String
	*/
	public static final String ASSET_CATEGORY_NAME="assetCategoryName";
	
	/**
	 * 资产类别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_CATEGORY_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_CATEGORY_NAME, java.lang.String.class, "资产类别", "资产类别", java.lang.String.class, null);
	
	/**
	 * 资产编码 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 资产编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_CODE, java.lang.String.class, "资产编码", "资产编码", java.lang.String.class, null);
	
	/**
	 * 资产名称 , 类型: java.lang.String
	*/
	public static final String ASSET_NAME="assetName";
	
	/**
	 * 资产名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_NAME, java.lang.String.class, "资产名称", "资产名称", java.lang.String.class, null);
	
	/**
	 * 资产型号 , 类型: java.lang.String
	*/
	public static final String ASSET_MODEL="assetModel";
	
	/**
	 * 资产型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_MODEL, java.lang.String.class, "资产型号", "资产型号", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String ASSET_STATUS_NAME="assetStatusName";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> ASSET_STATUS_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ASSET_STATUS_NAME, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,PURCHASE_DATE, java.util.Date.class, "采购日期", "采购日期", java.util.Date.class, null);
	
	/**
	 * 入账日期 , 类型: java.util.Date
	*/
	public static final String REGISTER_DATE="registerDate";
	
	/**
	 * 入账日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.util.Date> REGISTER_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,REGISTER_DATE, java.util.Date.class, "入账日期", "入账日期", java.util.Date.class, null);
	
	/**
	 * 资产原值 , 类型: java.math.BigDecimal
	*/
	public static final String ORIGINAL_UNIT_PRICE="originalUnitPrice";
	
	/**
	 * 资产原值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> ORIGINAL_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,ORIGINAL_UNIT_PRICE, java.math.BigDecimal.class, "资产原值", "资产原值", java.math.BigDecimal.class, null);
	
	/**
	 * 使用寿命 , 类型: java.math.BigDecimal
	*/
	public static final String SERVICE_LIFE="serviceLife";
	
	/**
	 * 使用寿命 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,SERVICE_LIFE, java.math.BigDecimal.class, "使用寿命", "使用寿命", java.math.BigDecimal.class, null);
	
	/**
	 * 已用寿命 , 类型: java.math.BigDecimal
	*/
	public static final String USED_SERVICE_LIFE="usedServiceLife";
	
	/**
	 * 已用寿命 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> USED_SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,USED_SERVICE_LIFE, java.math.BigDecimal.class, "已用寿命", "已用寿命", java.math.BigDecimal.class, null);
	
	/**
	 * 本期残值率 , 类型: java.math.BigDecimal
	*/
	public static final String RESIDUAL_RATE="residualRate";
	
	/**
	 * 本期残值率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> RESIDUAL_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,RESIDUAL_RATE, java.math.BigDecimal.class, "本期残值率", "本期残值率", java.math.BigDecimal.class, null);
	
	/**
	 * 本期残值 , 类型: java.math.BigDecimal
	*/
	public static final String REDIDUAL_PRICE="redidualPrice";
	
	/**
	 * 本期残值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> REDIDUAL_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,REDIDUAL_PRICE, java.math.BigDecimal.class, "本期残值", "本期残值", java.math.BigDecimal.class, null);
	
	/**
	 * (期初)期初原值 , 类型: java.math.BigDecimal
	*/
	public static final String S_ORIGINAL_PRICE="sOriginalPrice";
	
	/**
	 * (期初)期初原值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> S_ORIGINAL_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,S_ORIGINAL_PRICE, java.math.BigDecimal.class, "(期初)期初原值", "(期初)期初原值", java.math.BigDecimal.class, null);
	
	/**
	 * (期初)期初累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final String S_DEPRECIATION_AMOUNT="sDepreciationAmount";
	
	/**
	 * (期初)期初累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> S_DEPRECIATION_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,S_DEPRECIATION_AMOUNT, java.math.BigDecimal.class, "(期初)期初累计折旧", "(期初)期初累计折旧", java.math.BigDecimal.class, null);
	
	/**
	 * (期初)期初净值 , 类型: java.math.BigDecimal
	*/
	public static final String S_NAV_AMOUNT="sNavAmount";
	
	/**
	 * (期初)期初净值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> S_NAV_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,S_NAV_AMOUNT, java.math.BigDecimal.class, "(期初)期初净值", "(期初)期初净值", java.math.BigDecimal.class, null);
	
	/**
	 * (期初)期初可回收净额 , 类型: java.math.BigDecimal
	*/
	public static final String S_RECOVERABLE_AMOUNT="sRecoverableAmount";
	
	/**
	 * (期初)期初可回收净额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> S_RECOVERABLE_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,S_RECOVERABLE_AMOUNT, java.math.BigDecimal.class, "(期初)期初可回收净额", "(期初)期初可回收净额", java.math.BigDecimal.class, null);
	
	/**
	 * (本期发生)原值增加 , 类型: java.math.BigDecimal
	*/
	public static final String C_ORIGINAL_PRICE_INCREASE="cOriginalPriceIncrease";
	
	/**
	 * (本期发生)原值增加 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> C_ORIGINAL_PRICE_INCREASE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,C_ORIGINAL_PRICE_INCREASE, java.math.BigDecimal.class, "(本期发生)原值增加", "(本期发生)原值增加", java.math.BigDecimal.class, null);
	
	/**
	 * (本期发生)本期折旧额 , 类型: java.math.BigDecimal
	*/
	public static final String C_DEPRECIATION_AMOUNT="cDepreciationAmount";
	
	/**
	 * (本期发生)本期折旧额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> C_DEPRECIATION_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,C_DEPRECIATION_AMOUNT, java.math.BigDecimal.class, "(本期发生)本期折旧额", "(本期发生)本期折旧额", java.math.BigDecimal.class, null);
	
	/**
	 * (本期发生)本年累计折旧额 , 类型: java.math.BigDecimal
	*/
	public static final String C_YEAR_DEPRECIATION_AMOUNT="cYearDepreciationAmount";
	
	/**
	 * (本期发生)本年累计折旧额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> C_YEAR_DEPRECIATION_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,C_YEAR_DEPRECIATION_AMOUNT, java.math.BigDecimal.class, "(本期发生)本年累计折旧额", "(本期发生)本年累计折旧额", java.math.BigDecimal.class, null);
	
	/**
	 * (期末)期末原值 , 类型: java.math.BigDecimal
	*/
	public static final String E_ORIGINAL_PRICE="eOriginalPrice";
	
	/**
	 * (期末)期末原值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> E_ORIGINAL_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,E_ORIGINAL_PRICE, java.math.BigDecimal.class, "(期末)期末原值", "(期末)期末原值", java.math.BigDecimal.class, null);
	
	/**
	 * (期末)期末累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final String E_DEPRECIATION_AMOUNT="eDepreciationAmount";
	
	/**
	 * (期末)期末累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> E_DEPRECIATION_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,E_DEPRECIATION_AMOUNT, java.math.BigDecimal.class, "(期末)期末累计折旧", "(期末)期末累计折旧", java.math.BigDecimal.class, null);
	
	/**
	 * (期末)期末净值 , 类型: java.math.BigDecimal
	*/
	public static final String E_NAV_AMOUNT="eNavAmount";
	
	/**
	 * (期末)期末净值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> E_NAV_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,E_NAV_AMOUNT, java.math.BigDecimal.class, "(期末)期末净值", "(期末)期末净值", java.math.BigDecimal.class, null);
	
	/**
	 * (期末)期末可回收金额 , 类型: java.math.BigDecimal
	*/
	public static final String E_RECOVERABLE_AMOUNT="eRecoverableAmount";
	
	/**
	 * (期末)期末可回收金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.math.BigDecimal> E_RECOVERABLE_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,E_RECOVERABLE_AMOUNT, java.math.BigDecimal.class, "(期末)期末可回收金额", "(期末)期末可回收金额", java.math.BigDecimal.class, null);
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,USE_USER_ID, java.lang.String.class, "使用人", "使用人", java.lang.String.class, null);
	
	/**
	 * 部门ID , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 部门ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,USE_ORG_ID, java.lang.String.class, "部门ID", "部门ID", java.lang.String.class, null);
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final String USE_ORG_NAME="useOrgName";
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> USE_ORG_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,USE_ORG_NAME, java.lang.String.class, "使用部门", "使用部门", java.lang.String.class, null);
	
	/**
	 * 财务选项KEY , 类型: java.lang.String
	*/
	public static final String FINANCIAL_OPTION_KEY="financialOptionKey";
	
	/**
	 * 财务选项KEY , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> FINANCIAL_OPTION_KEY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,FINANCIAL_OPTION_KEY, java.lang.String.class, "财务选项KEY", "财务选项KEY", java.lang.String.class, null);
	
	/**
	 * 费用项目KEY , 类型: java.lang.String
	*/
	public static final String EXPENSE_ITEM_KEY="expenseItemKey";
	
	/**
	 * 费用项目KEY , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> EXPENSE_ITEM_KEY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,EXPENSE_ITEM_KEY, java.lang.String.class, "费用项目KEY", "费用项目KEY", java.lang.String.class, null);
	
	/**
	 * 财务选项 , 类型: java.lang.String
	*/
	public static final String FINANCIAL_OPTION_NAME="financialOptionName";
	
	/**
	 * 财务选项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> FINANCIAL_OPTION_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,FINANCIAL_OPTION_NAME, java.lang.String.class, "财务选项", "财务选项", java.lang.String.class, null);
	
	/**
	 * 费用项目 , 类型: java.lang.String
	*/
	public static final String EXPENSE_ITEM_NAME="expenseItemName";
	
	/**
	 * 费用项目 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> EXPENSE_ITEM_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,EXPENSE_ITEM_NAME, java.lang.String.class, "费用项目", "费用项目", java.lang.String.class, null);
	
	/**
	 * 客户情况 , 类型: java.lang.String
	*/
	public static final String CUSTOMER_INFO="customerInfo";
	
	/**
	 * 客户情况 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,java.lang.String> CUSTOMER_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,CUSTOMER_INFO, java.lang.String.class, "客户情况", "客户情况", java.lang.String.class, null);
	
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
	 * 财务选项 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String FINANCIAL_OPTION_DICT="financialOptionDict";
	
	/**
	 * 财务选项 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,org.github.foxnic.web.domain.system.DictItem> FINANCIAL_OPTION_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,FINANCIAL_OPTION_DICT, org.github.foxnic.web.domain.system.DictItem.class, "财务选项", "财务选项", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 费用项目 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String EXPENSE_ITEM_DICT="expenseItemDict";
	
	/**
	 * 费用项目 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,org.github.foxnic.web.domain.system.DictItem> EXPENSE_ITEM_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,EXPENSE_ITEM_DICT, org.github.foxnic.web.domain.system.DictItem.class, "费用项目", "费用项目", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 使用人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 使用人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "使用人员", "使用人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationDetail,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationDetail.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DEPRECIATION_ID , OPER_ID , DEPRECIATION_METHOD , RESULT , RESULT_DETAIL , ASSET_ID , ASSET_CATEGORY_NAME , ASSET_CODE , ASSET_NAME , ASSET_MODEL , ASSET_STATUS_NAME , PURCHASE_DATE , REGISTER_DATE , ORIGINAL_UNIT_PRICE , SERVICE_LIFE , USED_SERVICE_LIFE , RESIDUAL_RATE , REDIDUAL_PRICE , S_ORIGINAL_PRICE , S_DEPRECIATION_AMOUNT , S_NAV_AMOUNT , S_RECOVERABLE_AMOUNT , C_ORIGINAL_PRICE_INCREASE , C_DEPRECIATION_AMOUNT , C_YEAR_DEPRECIATION_AMOUNT , E_ORIGINAL_PRICE , E_DEPRECIATION_AMOUNT , E_NAV_AMOUNT , E_RECOVERABLE_AMOUNT , USE_USER_ID , USE_ORG_ID , USE_ORG_NAME , FINANCIAL_OPTION_KEY , EXPENSE_ITEM_KEY , FINANCIAL_OPTION_NAME , EXPENSE_ITEM_NAME , CUSTOMER_INFO , DETAIL_ID_SOURCE , DETAIL_ID_TARGET , PURCHASE_UNIT_PRICE , DEPRECIATION_PRICE , CUR_PRICE , BEFORE_PRICE , AFTER_PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET_SOURCE , ASSET_TARGET , ASSET , ASSET_DEPRECIATION , ASSET_DEPRECIATION_OPER , ASSET_CUR_NAME , ASSET_CUR_MODEL , ASSET_CUR_CODE , FINANCIAL_OPTION_DICT , EXPENSE_ITEM_DICT , USE_USER , USE_ORGANIZATION };
	
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
		 * 设置 资产类别
		 * @param assetCategoryName 资产类别
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetCategoryName(String assetCategoryName) {
			super.change(ASSET_CATEGORY_NAME,super.getAssetCategoryName(),assetCategoryName);
			super.setAssetCategoryName(assetCategoryName);
			return this;
		}
		
		/**
		 * 设置 资产编码
		 * @param assetCode 资产编码
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 资产名称
		 * @param assetName 资产名称
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetName(String assetName) {
			super.change(ASSET_NAME,super.getAssetName(),assetName);
			super.setAssetName(assetName);
			return this;
		}
		
		/**
		 * 设置 资产型号
		 * @param assetModel 资产型号
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetModel(String assetModel) {
			super.change(ASSET_MODEL,super.getAssetModel(),assetModel);
			super.setAssetModel(assetModel);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param assetStatusName 资产状态
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setAssetStatusName(String assetStatusName) {
			super.change(ASSET_STATUS_NAME,super.getAssetStatusName(),assetStatusName);
			super.setAssetStatusName(assetStatusName);
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
		 * 设置 入账日期
		 * @param registerDate 入账日期
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setRegisterDate(Date registerDate) {
			super.change(REGISTER_DATE,super.getRegisterDate(),registerDate);
			super.setRegisterDate(registerDate);
			return this;
		}
		
		/**
		 * 设置 资产原值
		 * @param originalUnitPrice 资产原值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setOriginalUnitPrice(BigDecimal originalUnitPrice) {
			super.change(ORIGINAL_UNIT_PRICE,super.getOriginalUnitPrice(),originalUnitPrice);
			super.setOriginalUnitPrice(originalUnitPrice);
			return this;
		}
		
		/**
		 * 设置 使用寿命
		 * @param serviceLife 使用寿命
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setServiceLife(BigDecimal serviceLife) {
			super.change(SERVICE_LIFE,super.getServiceLife(),serviceLife);
			super.setServiceLife(serviceLife);
			return this;
		}
		
		/**
		 * 设置 已用寿命
		 * @param usedServiceLife 已用寿命
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUsedServiceLife(BigDecimal usedServiceLife) {
			super.change(USED_SERVICE_LIFE,super.getUsedServiceLife(),usedServiceLife);
			super.setUsedServiceLife(usedServiceLife);
			return this;
		}
		
		/**
		 * 设置 本期残值率
		 * @param residualRate 本期残值率
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setResidualRate(BigDecimal residualRate) {
			super.change(RESIDUAL_RATE,super.getResidualRate(),residualRate);
			super.setResidualRate(residualRate);
			return this;
		}
		
		/**
		 * 设置 本期残值
		 * @param redidualPrice 本期残值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setRedidualPrice(BigDecimal redidualPrice) {
			super.change(REDIDUAL_PRICE,super.getRedidualPrice(),redidualPrice);
			super.setRedidualPrice(redidualPrice);
			return this;
		}
		
		/**
		 * 设置 (期初)期初原值
		 * @param sOriginalPrice (期初)期初原值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setSOriginalPrice(BigDecimal sOriginalPrice) {
			super.change(S_ORIGINAL_PRICE,super.getSOriginalPrice(),sOriginalPrice);
			super.setSOriginalPrice(sOriginalPrice);
			return this;
		}
		
		/**
		 * 设置 (期初)期初累计折旧
		 * @param sDepreciationAmount (期初)期初累计折旧
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setSDepreciationAmount(BigDecimal sDepreciationAmount) {
			super.change(S_DEPRECIATION_AMOUNT,super.getSDepreciationAmount(),sDepreciationAmount);
			super.setSDepreciationAmount(sDepreciationAmount);
			return this;
		}
		
		/**
		 * 设置 (期初)期初净值
		 * @param sNavAmount (期初)期初净值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setSNavAmount(BigDecimal sNavAmount) {
			super.change(S_NAV_AMOUNT,super.getSNavAmount(),sNavAmount);
			super.setSNavAmount(sNavAmount);
			return this;
		}
		
		/**
		 * 设置 (期初)期初可回收净额
		 * @param sRecoverableAmount (期初)期初可回收净额
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setSRecoverableAmount(BigDecimal sRecoverableAmount) {
			super.change(S_RECOVERABLE_AMOUNT,super.getSRecoverableAmount(),sRecoverableAmount);
			super.setSRecoverableAmount(sRecoverableAmount);
			return this;
		}
		
		/**
		 * 设置 (本期发生)原值增加
		 * @param cOriginalPriceIncrease (本期发生)原值增加
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCOriginalPriceIncrease(BigDecimal cOriginalPriceIncrease) {
			super.change(C_ORIGINAL_PRICE_INCREASE,super.getCOriginalPriceIncrease(),cOriginalPriceIncrease);
			super.setCOriginalPriceIncrease(cOriginalPriceIncrease);
			return this;
		}
		
		/**
		 * 设置 (本期发生)本期折旧额
		 * @param cDepreciationAmount (本期发生)本期折旧额
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCDepreciationAmount(BigDecimal cDepreciationAmount) {
			super.change(C_DEPRECIATION_AMOUNT,super.getCDepreciationAmount(),cDepreciationAmount);
			super.setCDepreciationAmount(cDepreciationAmount);
			return this;
		}
		
		/**
		 * 设置 (本期发生)本年累计折旧额
		 * @param cYearDepreciationAmount (本期发生)本年累计折旧额
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCYearDepreciationAmount(BigDecimal cYearDepreciationAmount) {
			super.change(C_YEAR_DEPRECIATION_AMOUNT,super.getCYearDepreciationAmount(),cYearDepreciationAmount);
			super.setCYearDepreciationAmount(cYearDepreciationAmount);
			return this;
		}
		
		/**
		 * 设置 (期末)期末原值
		 * @param eOriginalPrice (期末)期末原值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setEOriginalPrice(BigDecimal eOriginalPrice) {
			super.change(E_ORIGINAL_PRICE,super.getEOriginalPrice(),eOriginalPrice);
			super.setEOriginalPrice(eOriginalPrice);
			return this;
		}
		
		/**
		 * 设置 (期末)期末累计折旧
		 * @param eDepreciationAmount (期末)期末累计折旧
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setEDepreciationAmount(BigDecimal eDepreciationAmount) {
			super.change(E_DEPRECIATION_AMOUNT,super.getEDepreciationAmount(),eDepreciationAmount);
			super.setEDepreciationAmount(eDepreciationAmount);
			return this;
		}
		
		/**
		 * 设置 (期末)期末净值
		 * @param eNavAmount (期末)期末净值
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setENavAmount(BigDecimal eNavAmount) {
			super.change(E_NAV_AMOUNT,super.getENavAmount(),eNavAmount);
			super.setENavAmount(eNavAmount);
			return this;
		}
		
		/**
		 * 设置 (期末)期末可回收金额
		 * @param eRecoverableAmount (期末)期末可回收金额
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setERecoverableAmount(BigDecimal eRecoverableAmount) {
			super.change(E_RECOVERABLE_AMOUNT,super.getERecoverableAmount(),eRecoverableAmount);
			super.setERecoverableAmount(eRecoverableAmount);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param useUserId 使用人
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 部门ID
		 * @param useOrgId 部门ID
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 使用部门
		 * @param useOrgName 使用部门
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUseOrgName(String useOrgName) {
			super.change(USE_ORG_NAME,super.getUseOrgName(),useOrgName);
			super.setUseOrgName(useOrgName);
			return this;
		}
		
		/**
		 * 设置 财务选项KEY
		 * @param financialOptionKey 财务选项KEY
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setFinancialOptionKey(String financialOptionKey) {
			super.change(FINANCIAL_OPTION_KEY,super.getFinancialOptionKey(),financialOptionKey);
			super.setFinancialOptionKey(financialOptionKey);
			return this;
		}
		
		/**
		 * 设置 费用项目KEY
		 * @param expenseItemKey 费用项目KEY
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setExpenseItemKey(String expenseItemKey) {
			super.change(EXPENSE_ITEM_KEY,super.getExpenseItemKey(),expenseItemKey);
			super.setExpenseItemKey(expenseItemKey);
			return this;
		}
		
		/**
		 * 设置 财务选项
		 * @param financialOptionName 财务选项
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setFinancialOptionName(String financialOptionName) {
			super.change(FINANCIAL_OPTION_NAME,super.getFinancialOptionName(),financialOptionName);
			super.setFinancialOptionName(financialOptionName);
			return this;
		}
		
		/**
		 * 设置 费用项目
		 * @param expenseItemName 费用项目
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setExpenseItemName(String expenseItemName) {
			super.change(EXPENSE_ITEM_NAME,super.getExpenseItemName(),expenseItemName);
			super.setExpenseItemName(expenseItemName);
			return this;
		}
		
		/**
		 * 设置 客户情况
		 * @param customerInfo 客户情况
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setCustomerInfo(String customerInfo) {
			super.change(CUSTOMER_INFO,super.getCustomerInfo(),customerInfo);
			super.setCustomerInfo(customerInfo);
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
		
		/**
		 * 设置 财务选项
		 * @param financialOptionDict 财务选项
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setFinancialOptionDict(DictItem financialOptionDict) {
			super.change(FINANCIAL_OPTION_DICT,super.getFinancialOptionDict(),financialOptionDict);
			super.setFinancialOptionDict(financialOptionDict);
			return this;
		}
		
		/**
		 * 设置 费用项目
		 * @param expenseItemDict 费用项目
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setExpenseItemDict(DictItem expenseItemDict) {
			super.change(EXPENSE_ITEM_DICT,super.getExpenseItemDict(),expenseItemDict);
			super.setExpenseItemDict(expenseItemDict);
			return this;
		}
		
		/**
		 * 设置 使用人员
		 * @param useUser 使用人员
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public AssetDepreciationDetail setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetDepreciationDetail clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetDepreciationDetail duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUseOrgName(this.getUseOrgName());
			inst.setERecoverableAmount(this.getERecoverableAmount());
			inst.setDepreciationMethod(this.getDepreciationMethod());
			inst.setExpenseItemKey(this.getExpenseItemKey());
			inst.setCustomerInfo(this.getCustomerInfo());
			inst.setPurchaseUnitPrice(this.getPurchaseUnitPrice());
			inst.setDepreciationPrice(this.getDepreciationPrice());
			inst.setExpenseItemName(this.getExpenseItemName());
			inst.setENavAmount(this.getENavAmount());
			inst.setDetailIdSource(this.getDetailIdSource());
			inst.setSDepreciationAmount(this.getSDepreciationAmount());
			inst.setRedidualPrice(this.getRedidualPrice());
			inst.setId(this.getId());
			inst.setCurPrice(this.getCurPrice());
			inst.setCYearDepreciationAmount(this.getCYearDepreciationAmount());
			inst.setUsedServiceLife(this.getUsedServiceLife());
			inst.setAssetCode(this.getAssetCode());
			inst.setFinancialOptionKey(this.getFinancialOptionKey());
			inst.setVersion(this.getVersion());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setEDepreciationAmount(this.getEDepreciationAmount());
			inst.setFinancialOptionName(this.getFinancialOptionName());
			inst.setSOriginalPrice(this.getSOriginalPrice());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setAssetCategoryName(this.getAssetCategoryName());
			inst.setSNavAmount(this.getSNavAmount());
			inst.setAssetStatusName(this.getAssetStatusName());
			inst.setPurchaseDate(this.getPurchaseDate());
			inst.setOperId(this.getOperId());
			inst.setSRecoverableAmount(this.getSRecoverableAmount());
			inst.setEOriginalPrice(this.getEOriginalPrice());
			inst.setResult(this.getResult());
			inst.setOriginalUnitPrice(this.getOriginalUnitPrice());
			inst.setDepreciationId(this.getDepreciationId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setAssetId(this.getAssetId());
			inst.setAfterPrice(this.getAfterPrice());
			inst.setServiceLife(this.getServiceLife());
			inst.setRegisterDate(this.getRegisterDate());
			inst.setCOriginalPriceIncrease(this.getCOriginalPriceIncrease());
			inst.setBeforePrice(this.getBeforePrice());
			inst.setUseOrgId(this.getUseOrgId());
			inst.setAssetModel(this.getAssetModel());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setCDepreciationAmount(this.getCDepreciationAmount());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setResultDetail(this.getResultDetail());
			inst.setCreateTime(this.getCreateTime());
			inst.setResidualRate(this.getResidualRate());
			inst.setTenantId(this.getTenantId());
			inst.setAssetName(this.getAssetName());
			inst.setDetailIdTarget(this.getDetailIdTarget());
			inst.setUseUserId(this.getUseUserId());
			if(all) {
				inst.setUseOrganization(this.getUseOrganization());
				inst.setAssetTarget(this.getAssetTarget());
				inst.setExpenseItemDict(this.getExpenseItemDict());
				inst.setAssetCurModel(this.getAssetCurModel());
				inst.setAssetDepreciationOper(this.getAssetDepreciationOper());
				inst.setAssetSource(this.getAssetSource());
				inst.setAsset(this.getAsset());
				inst.setAssetCurCode(this.getAssetCurCode());
				inst.setUseUser(this.getUseUser());
				inst.setAssetDepreciation(this.getAssetDepreciation());
				inst.setAssetCurName(this.getAssetCurName());
				inst.setFinancialOptionDict(this.getFinancialOptionDict());
			}
			inst.clearModifies();
			return inst;
		}

	}
}