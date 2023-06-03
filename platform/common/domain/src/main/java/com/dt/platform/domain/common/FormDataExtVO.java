package com.dt.platform.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.dt.platform.domain.common.meta.FormDataExtVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据扩展VO类型
 * <p>数据扩展 , 数据表 sys_form_data_ext 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:55
 * @sign 188AEF99CBD7688EB635A42F7AF49CF4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "数据扩展VO类型 ; 数据扩展 , 数据表 sys_form_data_ext 的通用VO类型" , parent = FormDataExt.class)
public class FormDataExtVO extends FormDataExt {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public FormDataExtVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public FormDataExtVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public FormDataExtVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public FormDataExtVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public FormDataExtVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public FormDataExtVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public FormDataExtVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public FormDataExtVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public FormDataExtVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public FormDataExtVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public FormDataExtVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public FormDataExtVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public FormDataExtVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public FormDataExtVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormDataExtVO , 转换好的 FormDataExtVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormDataExtVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		com.dt.platform.domain.common.meta.FormDataExtVOMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.FormDataExtVOMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormDataExtVO clone(boolean deep) {
		return EntityContext.clone(FormDataExtVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormDataExtVO
	 * @param formDataExtMap 包含实体信息的 Map 对象
	 * @return FormDataExtVO , 转换好的的 FormDataExt 对象
	*/
	@Transient
	public static FormDataExtVO createFrom(Map<String,Object> formDataExtMap) {
		if(formDataExtMap==null) return null;
		FormDataExtVO vo = create();
		EntityContext.copyProperties(vo,formDataExtMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 FormDataExtVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormDataExtVO , 转换好的的 FormDataExt 对象
	*/
	@Transient
	public static FormDataExtVO createFrom(Object pojo) {
		if(pojo==null) return null;
		FormDataExtVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 FormDataExtVO，等同于 new
	 * @return FormDataExtVO 对象
	*/
	@Transient
	public static FormDataExtVO create() {
		return new com.dt.platform.domain.common.meta.FormDataExtVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setF10(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F10)));
			this.setLs2(DataParser.parse(String.class, map.get(FormDataExtVOMeta.LS2)));
			this.setLs1(DataParser.parse(String.class, map.get(FormDataExtVOMeta.LS1)));
			this.setF1(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F1)));
			this.setLs4(DataParser.parse(String.class, map.get(FormDataExtVOMeta.LS4)));
			this.setF2(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F2)));
			this.setLs3(DataParser.parse(String.class, map.get(FormDataExtVOMeta.LS3)));
			this.setF3(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F3)));
			this.setF4(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F4)));
			this.setLs5(DataParser.parse(String.class, map.get(FormDataExtVOMeta.LS5)));
			this.setF5(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F5)));
			this.setF6(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F6)));
			this.setF7(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F7)));
			this.setTs2(DataParser.parse(String.class, map.get(FormDataExtVOMeta.TS2)));
			this.setF8(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F8)));
			this.setTs1(DataParser.parse(String.class, map.get(FormDataExtVOMeta.TS1)));
			this.setF9(DataParser.parse(BigDecimal.class, map.get(FormDataExtVOMeta.F9)));
			this.setTs4(DataParser.parse(String.class, map.get(FormDataExtVOMeta.TS4)));
			this.setTs3(DataParser.parse(String.class, map.get(FormDataExtVOMeta.TS3)));
			this.setId(DataParser.parse(String.class, map.get(FormDataExtVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FormDataExtVOMeta.DELETE_BY)));
			this.setSs10(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS10)));
			this.setD1(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.D1)));
			this.setD2(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.D2)));
			this.setD3(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.D3)));
			this.setSs1(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS1)));
			this.setD4(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.D4)));
			this.setD5(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.D5)));
			this.setSs3(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS3)));
			this.setS11(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S11)));
			this.setD6(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.D6)));
			this.setSs2(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS2)));
			this.setDataId(DataParser.parse(String.class, map.get(FormDataExtVOMeta.DATA_ID)));
			this.setSs5(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS5)));
			this.setS13(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S13)));
			this.setSs4(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS4)));
			this.setS12(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S12)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FormDataExtVOMeta.UPDATE_BY)));
			this.setSs7(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS7)));
			this.setS15(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S15)));
			this.setSs6(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS6)));
			this.setS14(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S14)));
			this.setSs9(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS9)));
			this.setS17(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S17)));
			this.setSs8(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SS8)));
			this.setS16(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S16)));
			this.setS19(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S19)));
			this.setS18(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S18)));
			this.setI1(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.I1)));
			this.setI2(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.I2)));
			this.setI3(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.I3)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.UPDATE_TIME)));
			this.setI4(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.I4)));
			this.setI5(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.I5)));
			this.setS20(DataParser.parse(String.class, map.get(FormDataExtVOMeta.S20)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FormDataExtVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FormDataExtVOMeta.CREATE_TIME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(FormDataExtVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(FormDataExtVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(FormDataExtVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(FormDataExtVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(FormDataExtVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(FormDataExtVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setF10( (BigDecimal)map.get(FormDataExtVOMeta.F10));
				this.setLs2( (String)map.get(FormDataExtVOMeta.LS2));
				this.setLs1( (String)map.get(FormDataExtVOMeta.LS1));
				this.setF1( (BigDecimal)map.get(FormDataExtVOMeta.F1));
				this.setLs4( (String)map.get(FormDataExtVOMeta.LS4));
				this.setF2( (BigDecimal)map.get(FormDataExtVOMeta.F2));
				this.setLs3( (String)map.get(FormDataExtVOMeta.LS3));
				this.setF3( (BigDecimal)map.get(FormDataExtVOMeta.F3));
				this.setF4( (BigDecimal)map.get(FormDataExtVOMeta.F4));
				this.setLs5( (String)map.get(FormDataExtVOMeta.LS5));
				this.setF5( (BigDecimal)map.get(FormDataExtVOMeta.F5));
				this.setF6( (BigDecimal)map.get(FormDataExtVOMeta.F6));
				this.setF7( (BigDecimal)map.get(FormDataExtVOMeta.F7));
				this.setTs2( (String)map.get(FormDataExtVOMeta.TS2));
				this.setF8( (BigDecimal)map.get(FormDataExtVOMeta.F8));
				this.setTs1( (String)map.get(FormDataExtVOMeta.TS1));
				this.setF9( (BigDecimal)map.get(FormDataExtVOMeta.F9));
				this.setTs4( (String)map.get(FormDataExtVOMeta.TS4));
				this.setTs3( (String)map.get(FormDataExtVOMeta.TS3));
				this.setId( (String)map.get(FormDataExtVOMeta.ID));
				this.setVersion( (Integer)map.get(FormDataExtVOMeta.VERSION));
				this.setDeleteTime( (Date)map.get(FormDataExtVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(FormDataExtVOMeta.DELETE_BY));
				this.setSs10( (String)map.get(FormDataExtVOMeta.SS10));
				this.setD1( (Date)map.get(FormDataExtVOMeta.D1));
				this.setD2( (Date)map.get(FormDataExtVOMeta.D2));
				this.setD3( (Date)map.get(FormDataExtVOMeta.D3));
				this.setSs1( (String)map.get(FormDataExtVOMeta.SS1));
				this.setD4( (Date)map.get(FormDataExtVOMeta.D4));
				this.setD5( (Date)map.get(FormDataExtVOMeta.D5));
				this.setSs3( (String)map.get(FormDataExtVOMeta.SS3));
				this.setS11( (String)map.get(FormDataExtVOMeta.S11));
				this.setD6( (Date)map.get(FormDataExtVOMeta.D6));
				this.setSs2( (String)map.get(FormDataExtVOMeta.SS2));
				this.setDataId( (String)map.get(FormDataExtVOMeta.DATA_ID));
				this.setSs5( (String)map.get(FormDataExtVOMeta.SS5));
				this.setS13( (String)map.get(FormDataExtVOMeta.S13));
				this.setSs4( (String)map.get(FormDataExtVOMeta.SS4));
				this.setS12( (String)map.get(FormDataExtVOMeta.S12));
				this.setUpdateBy( (String)map.get(FormDataExtVOMeta.UPDATE_BY));
				this.setSs7( (String)map.get(FormDataExtVOMeta.SS7));
				this.setS15( (String)map.get(FormDataExtVOMeta.S15));
				this.setSs6( (String)map.get(FormDataExtVOMeta.SS6));
				this.setS14( (String)map.get(FormDataExtVOMeta.S14));
				this.setSs9( (String)map.get(FormDataExtVOMeta.SS9));
				this.setS17( (String)map.get(FormDataExtVOMeta.S17));
				this.setSs8( (String)map.get(FormDataExtVOMeta.SS8));
				this.setS16( (String)map.get(FormDataExtVOMeta.S16));
				this.setS19( (String)map.get(FormDataExtVOMeta.S19));
				this.setS18( (String)map.get(FormDataExtVOMeta.S18));
				this.setI1( (Integer)map.get(FormDataExtVOMeta.I1));
				this.setI2( (Integer)map.get(FormDataExtVOMeta.I2));
				this.setI3( (Integer)map.get(FormDataExtVOMeta.I3));
				this.setUpdateTime( (Date)map.get(FormDataExtVOMeta.UPDATE_TIME));
				this.setI4( (Integer)map.get(FormDataExtVOMeta.I4));
				this.setI5( (Integer)map.get(FormDataExtVOMeta.I5));
				this.setS20( (String)map.get(FormDataExtVOMeta.S20));
				this.setCreateBy( (String)map.get(FormDataExtVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FormDataExtVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(FormDataExtVOMeta.CREATE_TIME));
				// others
				this.setSearchField( (String)map.get(FormDataExtVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(FormDataExtVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(FormDataExtVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(FormDataExtVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(FormDataExtVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(FormDataExtVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(FormDataExtVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(FormDataExtVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(FormDataExtVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(FormDataExtVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setF10(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F10)));
			this.setLs2(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.LS2)));
			this.setLs1(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.LS1)));
			this.setF1(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F1)));
			this.setLs4(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.LS4)));
			this.setF2(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F2)));
			this.setLs3(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.LS3)));
			this.setF3(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F3)));
			this.setF4(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F4)));
			this.setLs5(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.LS5)));
			this.setF5(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F5)));
			this.setF6(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F6)));
			this.setF7(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F7)));
			this.setTs2(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.TS2)));
			this.setF8(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F8)));
			this.setTs1(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.TS1)));
			this.setF9(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtVOMeta.F9)));
			this.setTs4(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.TS4)));
			this.setTs3(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.TS3)));
			this.setId(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.DELETE_BY)));
			this.setSs10(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS10)));
			this.setD1(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.D1)));
			this.setD2(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.D2)));
			this.setD3(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.D3)));
			this.setSs1(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS1)));
			this.setD4(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.D4)));
			this.setD5(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.D5)));
			this.setSs3(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS3)));
			this.setS11(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S11)));
			this.setD6(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.D6)));
			this.setSs2(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS2)));
			this.setDataId(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.DATA_ID)));
			this.setSs5(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS5)));
			this.setS13(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S13)));
			this.setSs4(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS4)));
			this.setS12(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S12)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.UPDATE_BY)));
			this.setSs7(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS7)));
			this.setS15(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S15)));
			this.setSs6(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS6)));
			this.setS14(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S14)));
			this.setSs9(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS9)));
			this.setS17(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S17)));
			this.setSs8(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.SS8)));
			this.setS16(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S16)));
			this.setS19(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S19)));
			this.setS18(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S18)));
			this.setI1(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.I1)));
			this.setI2(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.I2)));
			this.setI3(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.I3)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.UPDATE_TIME)));
			this.setI4(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.I4)));
			this.setI5(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.I5)));
			this.setS20(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.S20)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FormDataExtVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FormDataExtVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FormDataExtVOMeta.CREATE_TIME)));
			return true;
		} else {
			try {
				this.setF10( (BigDecimal)r.getValue(FormDataExtVOMeta.F10));
				this.setLs2( (String)r.getValue(FormDataExtVOMeta.LS2));
				this.setLs1( (String)r.getValue(FormDataExtVOMeta.LS1));
				this.setF1( (BigDecimal)r.getValue(FormDataExtVOMeta.F1));
				this.setLs4( (String)r.getValue(FormDataExtVOMeta.LS4));
				this.setF2( (BigDecimal)r.getValue(FormDataExtVOMeta.F2));
				this.setLs3( (String)r.getValue(FormDataExtVOMeta.LS3));
				this.setF3( (BigDecimal)r.getValue(FormDataExtVOMeta.F3));
				this.setF4( (BigDecimal)r.getValue(FormDataExtVOMeta.F4));
				this.setLs5( (String)r.getValue(FormDataExtVOMeta.LS5));
				this.setF5( (BigDecimal)r.getValue(FormDataExtVOMeta.F5));
				this.setF6( (BigDecimal)r.getValue(FormDataExtVOMeta.F6));
				this.setF7( (BigDecimal)r.getValue(FormDataExtVOMeta.F7));
				this.setTs2( (String)r.getValue(FormDataExtVOMeta.TS2));
				this.setF8( (BigDecimal)r.getValue(FormDataExtVOMeta.F8));
				this.setTs1( (String)r.getValue(FormDataExtVOMeta.TS1));
				this.setF9( (BigDecimal)r.getValue(FormDataExtVOMeta.F9));
				this.setTs4( (String)r.getValue(FormDataExtVOMeta.TS4));
				this.setTs3( (String)r.getValue(FormDataExtVOMeta.TS3));
				this.setId( (String)r.getValue(FormDataExtVOMeta.ID));
				this.setVersion( (Integer)r.getValue(FormDataExtVOMeta.VERSION));
				this.setDeleteTime( (Date)r.getValue(FormDataExtVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(FormDataExtVOMeta.DELETE_BY));
				this.setSs10( (String)r.getValue(FormDataExtVOMeta.SS10));
				this.setD1( (Date)r.getValue(FormDataExtVOMeta.D1));
				this.setD2( (Date)r.getValue(FormDataExtVOMeta.D2));
				this.setD3( (Date)r.getValue(FormDataExtVOMeta.D3));
				this.setSs1( (String)r.getValue(FormDataExtVOMeta.SS1));
				this.setD4( (Date)r.getValue(FormDataExtVOMeta.D4));
				this.setD5( (Date)r.getValue(FormDataExtVOMeta.D5));
				this.setSs3( (String)r.getValue(FormDataExtVOMeta.SS3));
				this.setS11( (String)r.getValue(FormDataExtVOMeta.S11));
				this.setD6( (Date)r.getValue(FormDataExtVOMeta.D6));
				this.setSs2( (String)r.getValue(FormDataExtVOMeta.SS2));
				this.setDataId( (String)r.getValue(FormDataExtVOMeta.DATA_ID));
				this.setSs5( (String)r.getValue(FormDataExtVOMeta.SS5));
				this.setS13( (String)r.getValue(FormDataExtVOMeta.S13));
				this.setSs4( (String)r.getValue(FormDataExtVOMeta.SS4));
				this.setS12( (String)r.getValue(FormDataExtVOMeta.S12));
				this.setUpdateBy( (String)r.getValue(FormDataExtVOMeta.UPDATE_BY));
				this.setSs7( (String)r.getValue(FormDataExtVOMeta.SS7));
				this.setS15( (String)r.getValue(FormDataExtVOMeta.S15));
				this.setSs6( (String)r.getValue(FormDataExtVOMeta.SS6));
				this.setS14( (String)r.getValue(FormDataExtVOMeta.S14));
				this.setSs9( (String)r.getValue(FormDataExtVOMeta.SS9));
				this.setS17( (String)r.getValue(FormDataExtVOMeta.S17));
				this.setSs8( (String)r.getValue(FormDataExtVOMeta.SS8));
				this.setS16( (String)r.getValue(FormDataExtVOMeta.S16));
				this.setS19( (String)r.getValue(FormDataExtVOMeta.S19));
				this.setS18( (String)r.getValue(FormDataExtVOMeta.S18));
				this.setI1( (Integer)r.getValue(FormDataExtVOMeta.I1));
				this.setI2( (Integer)r.getValue(FormDataExtVOMeta.I2));
				this.setI3( (Integer)r.getValue(FormDataExtVOMeta.I3));
				this.setUpdateTime( (Date)r.getValue(FormDataExtVOMeta.UPDATE_TIME));
				this.setI4( (Integer)r.getValue(FormDataExtVOMeta.I4));
				this.setI5( (Integer)r.getValue(FormDataExtVOMeta.I5));
				this.setS20( (String)r.getValue(FormDataExtVOMeta.S20));
				this.setCreateBy( (String)r.getValue(FormDataExtVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FormDataExtVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FormDataExtVOMeta.CREATE_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}