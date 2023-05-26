package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.FormDataExtVO;
import java.util.List;
import com.dt.platform.domain.common.FormDataExt;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 20:03:45
 * @sign 188AEF99CBD7688EB635A42F7AF49CF4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FormDataExtVOMeta extends FormDataExtMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final String DATA_ID="dataId";
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> DATA_ID_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,DATA_ID, java.lang.String.class, "数据", "数据", java.lang.String.class, null);
	
	/**
	 * 字符串1 , 类型: java.lang.String
	*/
	public static final String SS1="ss1";
	
	/**
	 * 字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS1_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS1, java.lang.String.class, "字符串1", "字符串1", java.lang.String.class, null);
	
	/**
	 * 字符串2 , 类型: java.lang.String
	*/
	public static final String SS2="ss2";
	
	/**
	 * 字符串2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS2_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS2, java.lang.String.class, "字符串2", "字符串2", java.lang.String.class, null);
	
	/**
	 * 字符串3 , 类型: java.lang.String
	*/
	public static final String SS3="ss3";
	
	/**
	 * 字符串3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS3_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS3, java.lang.String.class, "字符串3", "字符串3", java.lang.String.class, null);
	
	/**
	 * 字符串4 , 类型: java.lang.String
	*/
	public static final String SS4="ss4";
	
	/**
	 * 字符串4 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS4_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS4, java.lang.String.class, "字符串4", "字符串4", java.lang.String.class, null);
	
	/**
	 * 字符串5 , 类型: java.lang.String
	*/
	public static final String SS5="ss5";
	
	/**
	 * 字符串5 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS5_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS5, java.lang.String.class, "字符串5", "字符串5", java.lang.String.class, null);
	
	/**
	 * 字符串6 , 类型: java.lang.String
	*/
	public static final String SS6="ss6";
	
	/**
	 * 字符串6 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS6_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS6, java.lang.String.class, "字符串6", "字符串6", java.lang.String.class, null);
	
	/**
	 * 字符串7 , 类型: java.lang.String
	*/
	public static final String SS7="ss7";
	
	/**
	 * 字符串7 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS7_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS7, java.lang.String.class, "字符串7", "字符串7", java.lang.String.class, null);
	
	/**
	 * 字符串8 , 类型: java.lang.String
	*/
	public static final String SS8="ss8";
	
	/**
	 * 字符串8 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS8_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS8, java.lang.String.class, "字符串8", "字符串8", java.lang.String.class, null);
	
	/**
	 * 字符串9 , 类型: java.lang.String
	*/
	public static final String SS9="ss9";
	
	/**
	 * 字符串9 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS9_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS9, java.lang.String.class, "字符串9", "字符串9", java.lang.String.class, null);
	
	/**
	 * 字符串10 , 类型: java.lang.String
	*/
	public static final String SS10="ss10";
	
	/**
	 * 字符串10 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> SS10_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,SS10, java.lang.String.class, "字符串10", "字符串10", java.lang.String.class, null);
	
	/**
	 * 字符串11 , 类型: java.lang.String
	*/
	public static final String S11="s11";
	
	/**
	 * 字符串11 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S11_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S11, java.lang.String.class, "字符串11", "字符串11", java.lang.String.class, null);
	
	/**
	 * 字符串12 , 类型: java.lang.String
	*/
	public static final String S12="s12";
	
	/**
	 * 字符串12 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S12_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S12, java.lang.String.class, "字符串12", "字符串12", java.lang.String.class, null);
	
	/**
	 * 字符串13 , 类型: java.lang.String
	*/
	public static final String S13="s13";
	
	/**
	 * 字符串13 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S13_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S13, java.lang.String.class, "字符串13", "字符串13", java.lang.String.class, null);
	
	/**
	 * 字符串14 , 类型: java.lang.String
	*/
	public static final String S14="s14";
	
	/**
	 * 字符串14 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S14_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S14, java.lang.String.class, "字符串14", "字符串14", java.lang.String.class, null);
	
	/**
	 * 字符串15 , 类型: java.lang.String
	*/
	public static final String S15="s15";
	
	/**
	 * 字符串15 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S15_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S15, java.lang.String.class, "字符串15", "字符串15", java.lang.String.class, null);
	
	/**
	 * 字符串16 , 类型: java.lang.String
	*/
	public static final String S16="s16";
	
	/**
	 * 字符串16 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S16_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S16, java.lang.String.class, "字符串16", "字符串16", java.lang.String.class, null);
	
	/**
	 * 字符串17 , 类型: java.lang.String
	*/
	public static final String S17="s17";
	
	/**
	 * 字符串17 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S17_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S17, java.lang.String.class, "字符串17", "字符串17", java.lang.String.class, null);
	
	/**
	 * 字符串18 , 类型: java.lang.String
	*/
	public static final String S18="s18";
	
	/**
	 * 字符串18 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S18_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S18, java.lang.String.class, "字符串18", "字符串18", java.lang.String.class, null);
	
	/**
	 * 字符串19 , 类型: java.lang.String
	*/
	public static final String S19="s19";
	
	/**
	 * 字符串19 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S19_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S19, java.lang.String.class, "字符串19", "字符串19", java.lang.String.class, null);
	
	/**
	 * 字符串20 , 类型: java.lang.String
	*/
	public static final String S20="s20";
	
	/**
	 * 字符串20 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> S20_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,S20, java.lang.String.class, "字符串20", "字符串20", java.lang.String.class, null);
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final String LS1="ls1";
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> LS1_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,LS1, java.lang.String.class, "长字符串1", "长字符串1", java.lang.String.class, null);
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final String LS2="ls2";
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> LS2_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,LS2, java.lang.String.class, "长字符串1", "长字符串1", java.lang.String.class, null);
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final String LS3="ls3";
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> LS3_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,LS3, java.lang.String.class, "长字符串1", "长字符串1", java.lang.String.class, null);
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final String LS4="ls4";
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> LS4_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,LS4, java.lang.String.class, "长字符串1", "长字符串1", java.lang.String.class, null);
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final String LS5="ls5";
	
	/**
	 * 长字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> LS5_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,LS5, java.lang.String.class, "长字符串1", "长字符串1", java.lang.String.class, null);
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final String TS1="ts1";
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> TS1_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,TS1, java.lang.String.class, "文本", "文本", java.lang.String.class, null);
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final String TS2="ts2";
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> TS2_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,TS2, java.lang.String.class, "文本", "文本", java.lang.String.class, null);
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final String TS3="ts3";
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> TS3_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,TS3, java.lang.String.class, "文本", "文本", java.lang.String.class, null);
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final String TS4="ts4";
	
	/**
	 * 文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> TS4_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,TS4, java.lang.String.class, "文本", "文本", java.lang.String.class, null);
	
	/**
	 * 时间1 , 类型: java.util.Date
	*/
	public static final String D1="d1";
	
	/**
	 * 时间1 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> D1_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,D1, java.util.Date.class, "时间1", "时间1", java.util.Date.class, null);
	
	/**
	 * 时间2 , 类型: java.util.Date
	*/
	public static final String D2="d2";
	
	/**
	 * 时间2 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> D2_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,D2, java.util.Date.class, "时间2", "时间2", java.util.Date.class, null);
	
	/**
	 * 时间3 , 类型: java.util.Date
	*/
	public static final String D3="d3";
	
	/**
	 * 时间3 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> D3_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,D3, java.util.Date.class, "时间3", "时间3", java.util.Date.class, null);
	
	/**
	 * 时间4 , 类型: java.util.Date
	*/
	public static final String D4="d4";
	
	/**
	 * 时间4 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> D4_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,D4, java.util.Date.class, "时间4", "时间4", java.util.Date.class, null);
	
	/**
	 * 时间5 , 类型: java.util.Date
	*/
	public static final String D5="d5";
	
	/**
	 * 时间5 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> D5_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,D5, java.util.Date.class, "时间5", "时间5", java.util.Date.class, null);
	
	/**
	 * 时间6 , 类型: java.util.Date
	*/
	public static final String D6="d6";
	
	/**
	 * 时间6 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> D6_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,D6, java.util.Date.class, "时间6", "时间6", java.util.Date.class, null);
	
	/**
	 * 整形1 , 类型: java.lang.Integer
	*/
	public static final String I1="i1";
	
	/**
	 * 整形1 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> I1_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,I1, java.lang.Integer.class, "整形1", "整形1", java.lang.Integer.class, null);
	
	/**
	 * 整形2 , 类型: java.lang.Integer
	*/
	public static final String I2="i2";
	
	/**
	 * 整形2 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> I2_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,I2, java.lang.Integer.class, "整形2", "整形2", java.lang.Integer.class, null);
	
	/**
	 * 整形3 , 类型: java.lang.Integer
	*/
	public static final String I3="i3";
	
	/**
	 * 整形3 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> I3_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,I3, java.lang.Integer.class, "整形3", "整形3", java.lang.Integer.class, null);
	
	/**
	 * 整形4 , 类型: java.lang.Integer
	*/
	public static final String I4="i4";
	
	/**
	 * 整形4 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> I4_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,I4, java.lang.Integer.class, "整形4", "整形4", java.lang.Integer.class, null);
	
	/**
	 * 整形5 , 类型: java.lang.Integer
	*/
	public static final String I5="i5";
	
	/**
	 * 整形5 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> I5_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,I5, java.lang.Integer.class, "整形5", "整形5", java.lang.Integer.class, null);
	
	/**
	 * 浮点1 , 类型: java.math.BigDecimal
	*/
	public static final String F1="f1";
	
	/**
	 * 浮点1 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F1_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F1, java.math.BigDecimal.class, "浮点1", "浮点1", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点2 , 类型: java.math.BigDecimal
	*/
	public static final String F2="f2";
	
	/**
	 * 浮点2 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F2_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F2, java.math.BigDecimal.class, "浮点2", "浮点2", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点3 , 类型: java.math.BigDecimal
	*/
	public static final String F3="f3";
	
	/**
	 * 浮点3 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F3_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F3, java.math.BigDecimal.class, "浮点3", "浮点3", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点4 , 类型: java.math.BigDecimal
	*/
	public static final String F4="f4";
	
	/**
	 * 浮点4 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F4_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F4, java.math.BigDecimal.class, "浮点4", "浮点4", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点5 , 类型: java.math.BigDecimal
	*/
	public static final String F5="f5";
	
	/**
	 * 浮点5 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F5_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F5, java.math.BigDecimal.class, "浮点5", "浮点5", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点6 , 类型: java.math.BigDecimal
	*/
	public static final String F6="f6";
	
	/**
	 * 浮点6 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F6_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F6, java.math.BigDecimal.class, "浮点6", "浮点6", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点7 , 类型: java.math.BigDecimal
	*/
	public static final String F7="f7";
	
	/**
	 * 浮点7 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F7_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F7, java.math.BigDecimal.class, "浮点7", "浮点7", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点8 , 类型: java.math.BigDecimal
	*/
	public static final String F8="f8";
	
	/**
	 * 浮点8 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F8_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F8, java.math.BigDecimal.class, "浮点8", "浮点8", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点9 , 类型: java.math.BigDecimal
	*/
	public static final String F9="f9";
	
	/**
	 * 浮点9 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F9_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F9, java.math.BigDecimal.class, "浮点9", "浮点9", java.math.BigDecimal.class, null);
	
	/**
	 * 浮点10 , 类型: java.math.BigDecimal
	*/
	public static final String F10="f10";
	
	/**
	 * 浮点10 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.math.BigDecimal> F10_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,F10, java.math.BigDecimal.class, "浮点10", "浮点10", java.math.BigDecimal.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.FormDataExtVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.FormDataExtVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , DATA_ID , SS1 , SS2 , SS3 , SS4 , SS5 , SS6 , SS7 , SS8 , SS9 , SS10 , S11 , S12 , S13 , S14 , S15 , S16 , S17 , S18 , S19 , S20 , LS1 , LS2 , LS3 , LS4 , LS5 , TS1 , TS2 , TS3 , TS4 , D1 , D2 , D3 , D4 , D5 , D6 , I1 , I2 , I3 , I4 , I5 , F1 , F2 , F3 , F4 , F5 , F6 , F7 , F8 , F9 , F10 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.FormDataExtVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public FormDataExtVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public FormDataExtVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public FormDataExtVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public FormDataExtVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public FormDataExtVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public FormDataExtVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public FormDataExtVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public FormDataExtVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public FormDataExtVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public FormDataExtVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public FormDataExtVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public FormDataExtVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FormDataExt setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 数据
		 * @param dataId 数据
		 * @return 当前对象
		*/
		public FormDataExt setDataId(String dataId) {
			super.change(DATA_ID,super.getDataId(),dataId);
			super.setDataId(dataId);
			return this;
		}
		
		/**
		 * 设置 字符串1
		 * @param ss1 字符串1
		 * @return 当前对象
		*/
		public FormDataExt setSs1(String ss1) {
			super.change(SS1,super.getSs1(),ss1);
			super.setSs1(ss1);
			return this;
		}
		
		/**
		 * 设置 字符串2
		 * @param ss2 字符串2
		 * @return 当前对象
		*/
		public FormDataExt setSs2(String ss2) {
			super.change(SS2,super.getSs2(),ss2);
			super.setSs2(ss2);
			return this;
		}
		
		/**
		 * 设置 字符串3
		 * @param ss3 字符串3
		 * @return 当前对象
		*/
		public FormDataExt setSs3(String ss3) {
			super.change(SS3,super.getSs3(),ss3);
			super.setSs3(ss3);
			return this;
		}
		
		/**
		 * 设置 字符串4
		 * @param ss4 字符串4
		 * @return 当前对象
		*/
		public FormDataExt setSs4(String ss4) {
			super.change(SS4,super.getSs4(),ss4);
			super.setSs4(ss4);
			return this;
		}
		
		/**
		 * 设置 字符串5
		 * @param ss5 字符串5
		 * @return 当前对象
		*/
		public FormDataExt setSs5(String ss5) {
			super.change(SS5,super.getSs5(),ss5);
			super.setSs5(ss5);
			return this;
		}
		
		/**
		 * 设置 字符串6
		 * @param ss6 字符串6
		 * @return 当前对象
		*/
		public FormDataExt setSs6(String ss6) {
			super.change(SS6,super.getSs6(),ss6);
			super.setSs6(ss6);
			return this;
		}
		
		/**
		 * 设置 字符串7
		 * @param ss7 字符串7
		 * @return 当前对象
		*/
		public FormDataExt setSs7(String ss7) {
			super.change(SS7,super.getSs7(),ss7);
			super.setSs7(ss7);
			return this;
		}
		
		/**
		 * 设置 字符串8
		 * @param ss8 字符串8
		 * @return 当前对象
		*/
		public FormDataExt setSs8(String ss8) {
			super.change(SS8,super.getSs8(),ss8);
			super.setSs8(ss8);
			return this;
		}
		
		/**
		 * 设置 字符串9
		 * @param ss9 字符串9
		 * @return 当前对象
		*/
		public FormDataExt setSs9(String ss9) {
			super.change(SS9,super.getSs9(),ss9);
			super.setSs9(ss9);
			return this;
		}
		
		/**
		 * 设置 字符串10
		 * @param ss10 字符串10
		 * @return 当前对象
		*/
		public FormDataExt setSs10(String ss10) {
			super.change(SS10,super.getSs10(),ss10);
			super.setSs10(ss10);
			return this;
		}
		
		/**
		 * 设置 字符串11
		 * @param s11 字符串11
		 * @return 当前对象
		*/
		public FormDataExt setS11(String s11) {
			super.change(S11,super.getS11(),s11);
			super.setS11(s11);
			return this;
		}
		
		/**
		 * 设置 字符串12
		 * @param s12 字符串12
		 * @return 当前对象
		*/
		public FormDataExt setS12(String s12) {
			super.change(S12,super.getS12(),s12);
			super.setS12(s12);
			return this;
		}
		
		/**
		 * 设置 字符串13
		 * @param s13 字符串13
		 * @return 当前对象
		*/
		public FormDataExt setS13(String s13) {
			super.change(S13,super.getS13(),s13);
			super.setS13(s13);
			return this;
		}
		
		/**
		 * 设置 字符串14
		 * @param s14 字符串14
		 * @return 当前对象
		*/
		public FormDataExt setS14(String s14) {
			super.change(S14,super.getS14(),s14);
			super.setS14(s14);
			return this;
		}
		
		/**
		 * 设置 字符串15
		 * @param s15 字符串15
		 * @return 当前对象
		*/
		public FormDataExt setS15(String s15) {
			super.change(S15,super.getS15(),s15);
			super.setS15(s15);
			return this;
		}
		
		/**
		 * 设置 字符串16
		 * @param s16 字符串16
		 * @return 当前对象
		*/
		public FormDataExt setS16(String s16) {
			super.change(S16,super.getS16(),s16);
			super.setS16(s16);
			return this;
		}
		
		/**
		 * 设置 字符串17
		 * @param s17 字符串17
		 * @return 当前对象
		*/
		public FormDataExt setS17(String s17) {
			super.change(S17,super.getS17(),s17);
			super.setS17(s17);
			return this;
		}
		
		/**
		 * 设置 字符串18
		 * @param s18 字符串18
		 * @return 当前对象
		*/
		public FormDataExt setS18(String s18) {
			super.change(S18,super.getS18(),s18);
			super.setS18(s18);
			return this;
		}
		
		/**
		 * 设置 字符串19
		 * @param s19 字符串19
		 * @return 当前对象
		*/
		public FormDataExt setS19(String s19) {
			super.change(S19,super.getS19(),s19);
			super.setS19(s19);
			return this;
		}
		
		/**
		 * 设置 字符串20
		 * @param s20 字符串20
		 * @return 当前对象
		*/
		public FormDataExt setS20(String s20) {
			super.change(S20,super.getS20(),s20);
			super.setS20(s20);
			return this;
		}
		
		/**
		 * 设置 长字符串1
		 * @param ls1 长字符串1
		 * @return 当前对象
		*/
		public FormDataExt setLs1(String ls1) {
			super.change(LS1,super.getLs1(),ls1);
			super.setLs1(ls1);
			return this;
		}
		
		/**
		 * 设置 长字符串1
		 * @param ls2 长字符串1
		 * @return 当前对象
		*/
		public FormDataExt setLs2(String ls2) {
			super.change(LS2,super.getLs2(),ls2);
			super.setLs2(ls2);
			return this;
		}
		
		/**
		 * 设置 长字符串1
		 * @param ls3 长字符串1
		 * @return 当前对象
		*/
		public FormDataExt setLs3(String ls3) {
			super.change(LS3,super.getLs3(),ls3);
			super.setLs3(ls3);
			return this;
		}
		
		/**
		 * 设置 长字符串1
		 * @param ls4 长字符串1
		 * @return 当前对象
		*/
		public FormDataExt setLs4(String ls4) {
			super.change(LS4,super.getLs4(),ls4);
			super.setLs4(ls4);
			return this;
		}
		
		/**
		 * 设置 长字符串1
		 * @param ls5 长字符串1
		 * @return 当前对象
		*/
		public FormDataExt setLs5(String ls5) {
			super.change(LS5,super.getLs5(),ls5);
			super.setLs5(ls5);
			return this;
		}
		
		/**
		 * 设置 文本
		 * @param ts1 文本
		 * @return 当前对象
		*/
		public FormDataExt setTs1(String ts1) {
			super.change(TS1,super.getTs1(),ts1);
			super.setTs1(ts1);
			return this;
		}
		
		/**
		 * 设置 文本
		 * @param ts2 文本
		 * @return 当前对象
		*/
		public FormDataExt setTs2(String ts2) {
			super.change(TS2,super.getTs2(),ts2);
			super.setTs2(ts2);
			return this;
		}
		
		/**
		 * 设置 文本
		 * @param ts3 文本
		 * @return 当前对象
		*/
		public FormDataExt setTs3(String ts3) {
			super.change(TS3,super.getTs3(),ts3);
			super.setTs3(ts3);
			return this;
		}
		
		/**
		 * 设置 文本
		 * @param ts4 文本
		 * @return 当前对象
		*/
		public FormDataExt setTs4(String ts4) {
			super.change(TS4,super.getTs4(),ts4);
			super.setTs4(ts4);
			return this;
		}
		
		/**
		 * 设置 时间1
		 * @param d1 时间1
		 * @return 当前对象
		*/
		public FormDataExt setD1(Date d1) {
			super.change(D1,super.getD1(),d1);
			super.setD1(d1);
			return this;
		}
		
		/**
		 * 设置 时间2
		 * @param d2 时间2
		 * @return 当前对象
		*/
		public FormDataExt setD2(Date d2) {
			super.change(D2,super.getD2(),d2);
			super.setD2(d2);
			return this;
		}
		
		/**
		 * 设置 时间3
		 * @param d3 时间3
		 * @return 当前对象
		*/
		public FormDataExt setD3(Date d3) {
			super.change(D3,super.getD3(),d3);
			super.setD3(d3);
			return this;
		}
		
		/**
		 * 设置 时间4
		 * @param d4 时间4
		 * @return 当前对象
		*/
		public FormDataExt setD4(Date d4) {
			super.change(D4,super.getD4(),d4);
			super.setD4(d4);
			return this;
		}
		
		/**
		 * 设置 时间5
		 * @param d5 时间5
		 * @return 当前对象
		*/
		public FormDataExt setD5(Date d5) {
			super.change(D5,super.getD5(),d5);
			super.setD5(d5);
			return this;
		}
		
		/**
		 * 设置 时间6
		 * @param d6 时间6
		 * @return 当前对象
		*/
		public FormDataExt setD6(Date d6) {
			super.change(D6,super.getD6(),d6);
			super.setD6(d6);
			return this;
		}
		
		/**
		 * 设置 整形1
		 * @param i1 整形1
		 * @return 当前对象
		*/
		public FormDataExt setI1(Integer i1) {
			super.change(I1,super.getI1(),i1);
			super.setI1(i1);
			return this;
		}
		
		/**
		 * 设置 整形2
		 * @param i2 整形2
		 * @return 当前对象
		*/
		public FormDataExt setI2(Integer i2) {
			super.change(I2,super.getI2(),i2);
			super.setI2(i2);
			return this;
		}
		
		/**
		 * 设置 整形3
		 * @param i3 整形3
		 * @return 当前对象
		*/
		public FormDataExt setI3(Integer i3) {
			super.change(I3,super.getI3(),i3);
			super.setI3(i3);
			return this;
		}
		
		/**
		 * 设置 整形4
		 * @param i4 整形4
		 * @return 当前对象
		*/
		public FormDataExt setI4(Integer i4) {
			super.change(I4,super.getI4(),i4);
			super.setI4(i4);
			return this;
		}
		
		/**
		 * 设置 整形5
		 * @param i5 整形5
		 * @return 当前对象
		*/
		public FormDataExt setI5(Integer i5) {
			super.change(I5,super.getI5(),i5);
			super.setI5(i5);
			return this;
		}
		
		/**
		 * 设置 浮点1
		 * @param f1 浮点1
		 * @return 当前对象
		*/
		public FormDataExt setF1(BigDecimal f1) {
			super.change(F1,super.getF1(),f1);
			super.setF1(f1);
			return this;
		}
		
		/**
		 * 设置 浮点2
		 * @param f2 浮点2
		 * @return 当前对象
		*/
		public FormDataExt setF2(BigDecimal f2) {
			super.change(F2,super.getF2(),f2);
			super.setF2(f2);
			return this;
		}
		
		/**
		 * 设置 浮点3
		 * @param f3 浮点3
		 * @return 当前对象
		*/
		public FormDataExt setF3(BigDecimal f3) {
			super.change(F3,super.getF3(),f3);
			super.setF3(f3);
			return this;
		}
		
		/**
		 * 设置 浮点4
		 * @param f4 浮点4
		 * @return 当前对象
		*/
		public FormDataExt setF4(BigDecimal f4) {
			super.change(F4,super.getF4(),f4);
			super.setF4(f4);
			return this;
		}
		
		/**
		 * 设置 浮点5
		 * @param f5 浮点5
		 * @return 当前对象
		*/
		public FormDataExt setF5(BigDecimal f5) {
			super.change(F5,super.getF5(),f5);
			super.setF5(f5);
			return this;
		}
		
		/**
		 * 设置 浮点6
		 * @param f6 浮点6
		 * @return 当前对象
		*/
		public FormDataExt setF6(BigDecimal f6) {
			super.change(F6,super.getF6(),f6);
			super.setF6(f6);
			return this;
		}
		
		/**
		 * 设置 浮点7
		 * @param f7 浮点7
		 * @return 当前对象
		*/
		public FormDataExt setF7(BigDecimal f7) {
			super.change(F7,super.getF7(),f7);
			super.setF7(f7);
			return this;
		}
		
		/**
		 * 设置 浮点8
		 * @param f8 浮点8
		 * @return 当前对象
		*/
		public FormDataExt setF8(BigDecimal f8) {
			super.change(F8,super.getF8(),f8);
			super.setF8(f8);
			return this;
		}
		
		/**
		 * 设置 浮点9
		 * @param f9 浮点9
		 * @return 当前对象
		*/
		public FormDataExt setF9(BigDecimal f9) {
			super.change(F9,super.getF9(),f9);
			super.setF9(f9);
			return this;
		}
		
		/**
		 * 设置 浮点10
		 * @param f10 浮点10
		 * @return 当前对象
		*/
		public FormDataExt setF10(BigDecimal f10) {
			super.change(F10,super.getF10(),f10);
			super.setF10(f10);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FormDataExt setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FormDataExt setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FormDataExt setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FormDataExt setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FormDataExt setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FormDataExt setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FormDataExt setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public FormDataExt setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public FormDataExtVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public FormDataExtVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setF10(this.getF10());
			inst.setLs2(this.getLs2());
			inst.setLs1(this.getLs1());
			inst.setF1(this.getF1());
			inst.setLs4(this.getLs4());
			inst.setF2(this.getF2());
			inst.setLs3(this.getLs3());
			inst.setF3(this.getF3());
			inst.setF4(this.getF4());
			inst.setLs5(this.getLs5());
			inst.setF5(this.getF5());
			inst.setF6(this.getF6());
			inst.setF7(this.getF7());
			inst.setTs2(this.getTs2());
			inst.setF8(this.getF8());
			inst.setTs1(this.getTs1());
			inst.setF9(this.getF9());
			inst.setTs4(this.getTs4());
			inst.setTs3(this.getTs3());
			inst.setId(this.getId());
			inst.setVersion(this.getVersion());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setSs10(this.getSs10());
			inst.setD1(this.getD1());
			inst.setD2(this.getD2());
			inst.setD3(this.getD3());
			inst.setSs1(this.getSs1());
			inst.setD4(this.getD4());
			inst.setD5(this.getD5());
			inst.setSs3(this.getSs3());
			inst.setS11(this.getS11());
			inst.setD6(this.getD6());
			inst.setSs2(this.getSs2());
			inst.setDataId(this.getDataId());
			inst.setSs5(this.getSs5());
			inst.setS13(this.getS13());
			inst.setSs4(this.getSs4());
			inst.setS12(this.getS12());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setSs7(this.getSs7());
			inst.setS15(this.getS15());
			inst.setSs6(this.getSs6());
			inst.setS14(this.getS14());
			inst.setSs9(this.getSs9());
			inst.setS17(this.getS17());
			inst.setSs8(this.getSs8());
			inst.setS16(this.getS16());
			inst.setS19(this.getS19());
			inst.setS18(this.getS18());
			inst.setI1(this.getI1());
			inst.setI2(this.getI2());
			inst.setI3(this.getI3());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setI4(this.getI4());
			inst.setI5(this.getI5());
			inst.setS20(this.getS20());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
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