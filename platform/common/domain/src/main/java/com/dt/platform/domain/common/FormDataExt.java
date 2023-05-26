package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_FORM_DATA_EXT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.FormDataExtMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据扩展
 * <p>数据扩展 , 数据表 sys_form_data_ext 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 20:03:45
 * @sign 7381DE5C81A5B2E734538E84A6B2902C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_form_data_ext")
@ApiModel(description = "数据扩展 ; 数据扩展 , 数据表 sys_form_data_ext 的PO类型")
public class FormDataExt extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_FORM_DATA_EXT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 数据：数据
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "数据")
	private String dataId;
	
	/**
	 * 字符串1：字符串1
	*/
	@ApiModelProperty(required = false,value="字符串1" , notes = "字符串1")
	private String ss1;
	
	/**
	 * 字符串2：字符串2
	*/
	@ApiModelProperty(required = false,value="字符串2" , notes = "字符串2")
	private String ss2;
	
	/**
	 * 字符串3：字符串3
	*/
	@ApiModelProperty(required = false,value="字符串3" , notes = "字符串3")
	private String ss3;
	
	/**
	 * 字符串4：字符串4
	*/
	@ApiModelProperty(required = false,value="字符串4" , notes = "字符串4")
	private String ss4;
	
	/**
	 * 字符串5：字符串5
	*/
	@ApiModelProperty(required = false,value="字符串5" , notes = "字符串5")
	private String ss5;
	
	/**
	 * 字符串6：字符串6
	*/
	@ApiModelProperty(required = false,value="字符串6" , notes = "字符串6")
	private String ss6;
	
	/**
	 * 字符串7：字符串7
	*/
	@ApiModelProperty(required = false,value="字符串7" , notes = "字符串7")
	private String ss7;
	
	/**
	 * 字符串8：字符串8
	*/
	@ApiModelProperty(required = false,value="字符串8" , notes = "字符串8")
	private String ss8;
	
	/**
	 * 字符串9：字符串9
	*/
	@ApiModelProperty(required = false,value="字符串9" , notes = "字符串9")
	private String ss9;
	
	/**
	 * 字符串10：字符串10
	*/
	@ApiModelProperty(required = false,value="字符串10" , notes = "字符串10")
	private String ss10;
	
	/**
	 * 字符串11：字符串11
	*/
	@ApiModelProperty(required = false,value="字符串11" , notes = "字符串11")
	private String s11;
	
	/**
	 * 字符串12：字符串12
	*/
	@ApiModelProperty(required = false,value="字符串12" , notes = "字符串12")
	private String s12;
	
	/**
	 * 字符串13：字符串13
	*/
	@ApiModelProperty(required = false,value="字符串13" , notes = "字符串13")
	private String s13;
	
	/**
	 * 字符串14：字符串14
	*/
	@ApiModelProperty(required = false,value="字符串14" , notes = "字符串14")
	private String s14;
	
	/**
	 * 字符串15：字符串15
	*/
	@ApiModelProperty(required = false,value="字符串15" , notes = "字符串15")
	private String s15;
	
	/**
	 * 字符串16：字符串16
	*/
	@ApiModelProperty(required = false,value="字符串16" , notes = "字符串16")
	private String s16;
	
	/**
	 * 字符串17：字符串17
	*/
	@ApiModelProperty(required = false,value="字符串17" , notes = "字符串17")
	private String s17;
	
	/**
	 * 字符串18：字符串18
	*/
	@ApiModelProperty(required = false,value="字符串18" , notes = "字符串18")
	private String s18;
	
	/**
	 * 字符串19：字符串19
	*/
	@ApiModelProperty(required = false,value="字符串19" , notes = "字符串19")
	private String s19;
	
	/**
	 * 字符串20：字符串20
	*/
	@ApiModelProperty(required = false,value="字符串20" , notes = "字符串20")
	private String s20;
	
	/**
	 * 长字符串1：长字符串1
	*/
	@ApiModelProperty(required = false,value="长字符串1" , notes = "长字符串1")
	private String ls1;
	
	/**
	 * 长字符串1：长字符串1
	*/
	@ApiModelProperty(required = false,value="长字符串1" , notes = "长字符串1")
	private String ls2;
	
	/**
	 * 长字符串1：长字符串1
	*/
	@ApiModelProperty(required = false,value="长字符串1" , notes = "长字符串1")
	private String ls3;
	
	/**
	 * 长字符串1：长字符串1
	*/
	@ApiModelProperty(required = false,value="长字符串1" , notes = "长字符串1")
	private String ls4;
	
	/**
	 * 长字符串1：长字符串1
	*/
	@ApiModelProperty(required = false,value="长字符串1" , notes = "长字符串1")
	private String ls5;
	
	/**
	 * 文本：文本
	*/
	@ApiModelProperty(required = false,value="文本" , notes = "文本")
	private String ts1;
	
	/**
	 * 文本：文本
	*/
	@ApiModelProperty(required = false,value="文本" , notes = "文本")
	private String ts2;
	
	/**
	 * 文本：文本
	*/
	@ApiModelProperty(required = false,value="文本" , notes = "文本")
	private String ts3;
	
	/**
	 * 文本：文本
	*/
	@ApiModelProperty(required = false,value="文本" , notes = "文本")
	private String ts4;
	
	/**
	 * 时间1：时间1
	*/
	@ApiModelProperty(required = false,value="时间1" , notes = "时间1")
	private Date d1;
	
	/**
	 * 时间2：时间2
	*/
	@ApiModelProperty(required = false,value="时间2" , notes = "时间2")
	private Date d2;
	
	/**
	 * 时间3：时间3
	*/
	@ApiModelProperty(required = false,value="时间3" , notes = "时间3")
	private Date d3;
	
	/**
	 * 时间4：时间4
	*/
	@ApiModelProperty(required = false,value="时间4" , notes = "时间4")
	private Date d4;
	
	/**
	 * 时间5：时间5
	*/
	@ApiModelProperty(required = false,value="时间5" , notes = "时间5")
	private Date d5;
	
	/**
	 * 时间6：时间6
	*/
	@ApiModelProperty(required = false,value="时间6" , notes = "时间6")
	private Date d6;
	
	/**
	 * 整形1：整形1
	*/
	@ApiModelProperty(required = false,value="整形1" , notes = "整形1")
	private Integer i1;
	
	/**
	 * 整形2：整形2
	*/
	@ApiModelProperty(required = false,value="整形2" , notes = "整形2")
	private Integer i2;
	
	/**
	 * 整形3：整形3
	*/
	@ApiModelProperty(required = false,value="整形3" , notes = "整形3")
	private Integer i3;
	
	/**
	 * 整形4：整形4
	*/
	@ApiModelProperty(required = false,value="整形4" , notes = "整形4")
	private Integer i4;
	
	/**
	 * 整形5：整形5
	*/
	@ApiModelProperty(required = false,value="整形5" , notes = "整形5")
	private Integer i5;
	
	/**
	 * 浮点1：浮点1
	*/
	@ApiModelProperty(required = false,value="浮点1" , notes = "浮点1")
	private BigDecimal f1;
	
	/**
	 * 浮点2：浮点2
	*/
	@ApiModelProperty(required = false,value="浮点2" , notes = "浮点2")
	private BigDecimal f2;
	
	/**
	 * 浮点3：浮点3
	*/
	@ApiModelProperty(required = false,value="浮点3" , notes = "浮点3")
	private BigDecimal f3;
	
	/**
	 * 浮点4：浮点4
	*/
	@ApiModelProperty(required = false,value="浮点4" , notes = "浮点4")
	private BigDecimal f4;
	
	/**
	 * 浮点5：浮点5
	*/
	@ApiModelProperty(required = false,value="浮点5" , notes = "浮点5")
	private BigDecimal f5;
	
	/**
	 * 浮点6：浮点6
	*/
	@ApiModelProperty(required = false,value="浮点6" , notes = "浮点6")
	private BigDecimal f6;
	
	/**
	 * 浮点7：浮点7
	*/
	@ApiModelProperty(required = false,value="浮点7" , notes = "浮点7")
	private BigDecimal f7;
	
	/**
	 * 浮点8：浮点8
	*/
	@ApiModelProperty(required = false,value="浮点8" , notes = "浮点8")
	private BigDecimal f8;
	
	/**
	 * 浮点9：浮点9
	*/
	@ApiModelProperty(required = false,value="浮点9" , notes = "浮点9")
	private BigDecimal f9;
	
	/**
	 * 浮点10：浮点10
	*/
	@ApiModelProperty(required = false,value="浮点10" , notes = "浮点10")
	private BigDecimal f10;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public FormDataExt setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 数据
	 * @return 数据
	*/
	public String getDataId() {
		return dataId;
	}
	
	/**
	 * 设置 数据
	 * @param dataId 数据
	 * @return 当前对象
	*/
	public FormDataExt setDataId(String dataId) {
		this.dataId=dataId;
		return this;
	}
	
	/**
	 * 获得 字符串1<br>
	 * 字符串1
	 * @return 字符串1
	*/
	public String getSs1() {
		return ss1;
	}
	
	/**
	 * 设置 字符串1
	 * @param ss1 字符串1
	 * @return 当前对象
	*/
	public FormDataExt setSs1(String ss1) {
		this.ss1=ss1;
		return this;
	}
	
	/**
	 * 获得 字符串2<br>
	 * 字符串2
	 * @return 字符串2
	*/
	public String getSs2() {
		return ss2;
	}
	
	/**
	 * 设置 字符串2
	 * @param ss2 字符串2
	 * @return 当前对象
	*/
	public FormDataExt setSs2(String ss2) {
		this.ss2=ss2;
		return this;
	}
	
	/**
	 * 获得 字符串3<br>
	 * 字符串3
	 * @return 字符串3
	*/
	public String getSs3() {
		return ss3;
	}
	
	/**
	 * 设置 字符串3
	 * @param ss3 字符串3
	 * @return 当前对象
	*/
	public FormDataExt setSs3(String ss3) {
		this.ss3=ss3;
		return this;
	}
	
	/**
	 * 获得 字符串4<br>
	 * 字符串4
	 * @return 字符串4
	*/
	public String getSs4() {
		return ss4;
	}
	
	/**
	 * 设置 字符串4
	 * @param ss4 字符串4
	 * @return 当前对象
	*/
	public FormDataExt setSs4(String ss4) {
		this.ss4=ss4;
		return this;
	}
	
	/**
	 * 获得 字符串5<br>
	 * 字符串5
	 * @return 字符串5
	*/
	public String getSs5() {
		return ss5;
	}
	
	/**
	 * 设置 字符串5
	 * @param ss5 字符串5
	 * @return 当前对象
	*/
	public FormDataExt setSs5(String ss5) {
		this.ss5=ss5;
		return this;
	}
	
	/**
	 * 获得 字符串6<br>
	 * 字符串6
	 * @return 字符串6
	*/
	public String getSs6() {
		return ss6;
	}
	
	/**
	 * 设置 字符串6
	 * @param ss6 字符串6
	 * @return 当前对象
	*/
	public FormDataExt setSs6(String ss6) {
		this.ss6=ss6;
		return this;
	}
	
	/**
	 * 获得 字符串7<br>
	 * 字符串7
	 * @return 字符串7
	*/
	public String getSs7() {
		return ss7;
	}
	
	/**
	 * 设置 字符串7
	 * @param ss7 字符串7
	 * @return 当前对象
	*/
	public FormDataExt setSs7(String ss7) {
		this.ss7=ss7;
		return this;
	}
	
	/**
	 * 获得 字符串8<br>
	 * 字符串8
	 * @return 字符串8
	*/
	public String getSs8() {
		return ss8;
	}
	
	/**
	 * 设置 字符串8
	 * @param ss8 字符串8
	 * @return 当前对象
	*/
	public FormDataExt setSs8(String ss8) {
		this.ss8=ss8;
		return this;
	}
	
	/**
	 * 获得 字符串9<br>
	 * 字符串9
	 * @return 字符串9
	*/
	public String getSs9() {
		return ss9;
	}
	
	/**
	 * 设置 字符串9
	 * @param ss9 字符串9
	 * @return 当前对象
	*/
	public FormDataExt setSs9(String ss9) {
		this.ss9=ss9;
		return this;
	}
	
	/**
	 * 获得 字符串10<br>
	 * 字符串10
	 * @return 字符串10
	*/
	public String getSs10() {
		return ss10;
	}
	
	/**
	 * 设置 字符串10
	 * @param ss10 字符串10
	 * @return 当前对象
	*/
	public FormDataExt setSs10(String ss10) {
		this.ss10=ss10;
		return this;
	}
	
	/**
	 * 获得 字符串11<br>
	 * 字符串11
	 * @return 字符串11
	*/
	public String getS11() {
		return s11;
	}
	
	/**
	 * 设置 字符串11
	 * @param s11 字符串11
	 * @return 当前对象
	*/
	public FormDataExt setS11(String s11) {
		this.s11=s11;
		return this;
	}
	
	/**
	 * 获得 字符串12<br>
	 * 字符串12
	 * @return 字符串12
	*/
	public String getS12() {
		return s12;
	}
	
	/**
	 * 设置 字符串12
	 * @param s12 字符串12
	 * @return 当前对象
	*/
	public FormDataExt setS12(String s12) {
		this.s12=s12;
		return this;
	}
	
	/**
	 * 获得 字符串13<br>
	 * 字符串13
	 * @return 字符串13
	*/
	public String getS13() {
		return s13;
	}
	
	/**
	 * 设置 字符串13
	 * @param s13 字符串13
	 * @return 当前对象
	*/
	public FormDataExt setS13(String s13) {
		this.s13=s13;
		return this;
	}
	
	/**
	 * 获得 字符串14<br>
	 * 字符串14
	 * @return 字符串14
	*/
	public String getS14() {
		return s14;
	}
	
	/**
	 * 设置 字符串14
	 * @param s14 字符串14
	 * @return 当前对象
	*/
	public FormDataExt setS14(String s14) {
		this.s14=s14;
		return this;
	}
	
	/**
	 * 获得 字符串15<br>
	 * 字符串15
	 * @return 字符串15
	*/
	public String getS15() {
		return s15;
	}
	
	/**
	 * 设置 字符串15
	 * @param s15 字符串15
	 * @return 当前对象
	*/
	public FormDataExt setS15(String s15) {
		this.s15=s15;
		return this;
	}
	
	/**
	 * 获得 字符串16<br>
	 * 字符串16
	 * @return 字符串16
	*/
	public String getS16() {
		return s16;
	}
	
	/**
	 * 设置 字符串16
	 * @param s16 字符串16
	 * @return 当前对象
	*/
	public FormDataExt setS16(String s16) {
		this.s16=s16;
		return this;
	}
	
	/**
	 * 获得 字符串17<br>
	 * 字符串17
	 * @return 字符串17
	*/
	public String getS17() {
		return s17;
	}
	
	/**
	 * 设置 字符串17
	 * @param s17 字符串17
	 * @return 当前对象
	*/
	public FormDataExt setS17(String s17) {
		this.s17=s17;
		return this;
	}
	
	/**
	 * 获得 字符串18<br>
	 * 字符串18
	 * @return 字符串18
	*/
	public String getS18() {
		return s18;
	}
	
	/**
	 * 设置 字符串18
	 * @param s18 字符串18
	 * @return 当前对象
	*/
	public FormDataExt setS18(String s18) {
		this.s18=s18;
		return this;
	}
	
	/**
	 * 获得 字符串19<br>
	 * 字符串19
	 * @return 字符串19
	*/
	public String getS19() {
		return s19;
	}
	
	/**
	 * 设置 字符串19
	 * @param s19 字符串19
	 * @return 当前对象
	*/
	public FormDataExt setS19(String s19) {
		this.s19=s19;
		return this;
	}
	
	/**
	 * 获得 字符串20<br>
	 * 字符串20
	 * @return 字符串20
	*/
	public String getS20() {
		return s20;
	}
	
	/**
	 * 设置 字符串20
	 * @param s20 字符串20
	 * @return 当前对象
	*/
	public FormDataExt setS20(String s20) {
		this.s20=s20;
		return this;
	}
	
	/**
	 * 获得 长字符串1<br>
	 * 长字符串1
	 * @return 长字符串1
	*/
	public String getLs1() {
		return ls1;
	}
	
	/**
	 * 设置 长字符串1
	 * @param ls1 长字符串1
	 * @return 当前对象
	*/
	public FormDataExt setLs1(String ls1) {
		this.ls1=ls1;
		return this;
	}
	
	/**
	 * 获得 长字符串1<br>
	 * 长字符串1
	 * @return 长字符串1
	*/
	public String getLs2() {
		return ls2;
	}
	
	/**
	 * 设置 长字符串1
	 * @param ls2 长字符串1
	 * @return 当前对象
	*/
	public FormDataExt setLs2(String ls2) {
		this.ls2=ls2;
		return this;
	}
	
	/**
	 * 获得 长字符串1<br>
	 * 长字符串1
	 * @return 长字符串1
	*/
	public String getLs3() {
		return ls3;
	}
	
	/**
	 * 设置 长字符串1
	 * @param ls3 长字符串1
	 * @return 当前对象
	*/
	public FormDataExt setLs3(String ls3) {
		this.ls3=ls3;
		return this;
	}
	
	/**
	 * 获得 长字符串1<br>
	 * 长字符串1
	 * @return 长字符串1
	*/
	public String getLs4() {
		return ls4;
	}
	
	/**
	 * 设置 长字符串1
	 * @param ls4 长字符串1
	 * @return 当前对象
	*/
	public FormDataExt setLs4(String ls4) {
		this.ls4=ls4;
		return this;
	}
	
	/**
	 * 获得 长字符串1<br>
	 * 长字符串1
	 * @return 长字符串1
	*/
	public String getLs5() {
		return ls5;
	}
	
	/**
	 * 设置 长字符串1
	 * @param ls5 长字符串1
	 * @return 当前对象
	*/
	public FormDataExt setLs5(String ls5) {
		this.ls5=ls5;
		return this;
	}
	
	/**
	 * 获得 文本<br>
	 * 文本
	 * @return 文本
	*/
	public String getTs1() {
		return ts1;
	}
	
	/**
	 * 设置 文本
	 * @param ts1 文本
	 * @return 当前对象
	*/
	public FormDataExt setTs1(String ts1) {
		this.ts1=ts1;
		return this;
	}
	
	/**
	 * 获得 文本<br>
	 * 文本
	 * @return 文本
	*/
	public String getTs2() {
		return ts2;
	}
	
	/**
	 * 设置 文本
	 * @param ts2 文本
	 * @return 当前对象
	*/
	public FormDataExt setTs2(String ts2) {
		this.ts2=ts2;
		return this;
	}
	
	/**
	 * 获得 文本<br>
	 * 文本
	 * @return 文本
	*/
	public String getTs3() {
		return ts3;
	}
	
	/**
	 * 设置 文本
	 * @param ts3 文本
	 * @return 当前对象
	*/
	public FormDataExt setTs3(String ts3) {
		this.ts3=ts3;
		return this;
	}
	
	/**
	 * 获得 文本<br>
	 * 文本
	 * @return 文本
	*/
	public String getTs4() {
		return ts4;
	}
	
	/**
	 * 设置 文本
	 * @param ts4 文本
	 * @return 当前对象
	*/
	public FormDataExt setTs4(String ts4) {
		this.ts4=ts4;
		return this;
	}
	
	/**
	 * 获得 时间1<br>
	 * 时间1
	 * @return 时间1
	*/
	public Date getD1() {
		return d1;
	}
	
	/**
	 * 设置 时间1
	 * @param d1 时间1
	 * @return 当前对象
	*/
	public FormDataExt setD1(Date d1) {
		this.d1=d1;
		return this;
	}
	
	/**
	 * 获得 时间2<br>
	 * 时间2
	 * @return 时间2
	*/
	public Date getD2() {
		return d2;
	}
	
	/**
	 * 设置 时间2
	 * @param d2 时间2
	 * @return 当前对象
	*/
	public FormDataExt setD2(Date d2) {
		this.d2=d2;
		return this;
	}
	
	/**
	 * 获得 时间3<br>
	 * 时间3
	 * @return 时间3
	*/
	public Date getD3() {
		return d3;
	}
	
	/**
	 * 设置 时间3
	 * @param d3 时间3
	 * @return 当前对象
	*/
	public FormDataExt setD3(Date d3) {
		this.d3=d3;
		return this;
	}
	
	/**
	 * 获得 时间4<br>
	 * 时间4
	 * @return 时间4
	*/
	public Date getD4() {
		return d4;
	}
	
	/**
	 * 设置 时间4
	 * @param d4 时间4
	 * @return 当前对象
	*/
	public FormDataExt setD4(Date d4) {
		this.d4=d4;
		return this;
	}
	
	/**
	 * 获得 时间5<br>
	 * 时间5
	 * @return 时间5
	*/
	public Date getD5() {
		return d5;
	}
	
	/**
	 * 设置 时间5
	 * @param d5 时间5
	 * @return 当前对象
	*/
	public FormDataExt setD5(Date d5) {
		this.d5=d5;
		return this;
	}
	
	/**
	 * 获得 时间6<br>
	 * 时间6
	 * @return 时间6
	*/
	public Date getD6() {
		return d6;
	}
	
	/**
	 * 设置 时间6
	 * @param d6 时间6
	 * @return 当前对象
	*/
	public FormDataExt setD6(Date d6) {
		this.d6=d6;
		return this;
	}
	
	/**
	 * 获得 整形1<br>
	 * 整形1
	 * @return 整形1
	*/
	public Integer getI1() {
		return i1;
	}
	
	/**
	 * 设置 整形1
	 * @param i1 整形1
	 * @return 当前对象
	*/
	public FormDataExt setI1(Integer i1) {
		this.i1=i1;
		return this;
	}
	
	/**
	 * 获得 整形2<br>
	 * 整形2
	 * @return 整形2
	*/
	public Integer getI2() {
		return i2;
	}
	
	/**
	 * 设置 整形2
	 * @param i2 整形2
	 * @return 当前对象
	*/
	public FormDataExt setI2(Integer i2) {
		this.i2=i2;
		return this;
	}
	
	/**
	 * 获得 整形3<br>
	 * 整形3
	 * @return 整形3
	*/
	public Integer getI3() {
		return i3;
	}
	
	/**
	 * 设置 整形3
	 * @param i3 整形3
	 * @return 当前对象
	*/
	public FormDataExt setI3(Integer i3) {
		this.i3=i3;
		return this;
	}
	
	/**
	 * 获得 整形4<br>
	 * 整形4
	 * @return 整形4
	*/
	public Integer getI4() {
		return i4;
	}
	
	/**
	 * 设置 整形4
	 * @param i4 整形4
	 * @return 当前对象
	*/
	public FormDataExt setI4(Integer i4) {
		this.i4=i4;
		return this;
	}
	
	/**
	 * 获得 整形5<br>
	 * 整形5
	 * @return 整形5
	*/
	public Integer getI5() {
		return i5;
	}
	
	/**
	 * 设置 整形5
	 * @param i5 整形5
	 * @return 当前对象
	*/
	public FormDataExt setI5(Integer i5) {
		this.i5=i5;
		return this;
	}
	
	/**
	 * 获得 浮点1<br>
	 * 浮点1
	 * @return 浮点1
	*/
	public BigDecimal getF1() {
		return f1;
	}
	
	/**
	 * 设置 浮点1
	 * @param f1 浮点1
	 * @return 当前对象
	*/
	public FormDataExt setF1(BigDecimal f1) {
		this.f1=f1;
		return this;
	}
	
	/**
	 * 获得 浮点2<br>
	 * 浮点2
	 * @return 浮点2
	*/
	public BigDecimal getF2() {
		return f2;
	}
	
	/**
	 * 设置 浮点2
	 * @param f2 浮点2
	 * @return 当前对象
	*/
	public FormDataExt setF2(BigDecimal f2) {
		this.f2=f2;
		return this;
	}
	
	/**
	 * 获得 浮点3<br>
	 * 浮点3
	 * @return 浮点3
	*/
	public BigDecimal getF3() {
		return f3;
	}
	
	/**
	 * 设置 浮点3
	 * @param f3 浮点3
	 * @return 当前对象
	*/
	public FormDataExt setF3(BigDecimal f3) {
		this.f3=f3;
		return this;
	}
	
	/**
	 * 获得 浮点4<br>
	 * 浮点4
	 * @return 浮点4
	*/
	public BigDecimal getF4() {
		return f4;
	}
	
	/**
	 * 设置 浮点4
	 * @param f4 浮点4
	 * @return 当前对象
	*/
	public FormDataExt setF4(BigDecimal f4) {
		this.f4=f4;
		return this;
	}
	
	/**
	 * 获得 浮点5<br>
	 * 浮点5
	 * @return 浮点5
	*/
	public BigDecimal getF5() {
		return f5;
	}
	
	/**
	 * 设置 浮点5
	 * @param f5 浮点5
	 * @return 当前对象
	*/
	public FormDataExt setF5(BigDecimal f5) {
		this.f5=f5;
		return this;
	}
	
	/**
	 * 获得 浮点6<br>
	 * 浮点6
	 * @return 浮点6
	*/
	public BigDecimal getF6() {
		return f6;
	}
	
	/**
	 * 设置 浮点6
	 * @param f6 浮点6
	 * @return 当前对象
	*/
	public FormDataExt setF6(BigDecimal f6) {
		this.f6=f6;
		return this;
	}
	
	/**
	 * 获得 浮点7<br>
	 * 浮点7
	 * @return 浮点7
	*/
	public BigDecimal getF7() {
		return f7;
	}
	
	/**
	 * 设置 浮点7
	 * @param f7 浮点7
	 * @return 当前对象
	*/
	public FormDataExt setF7(BigDecimal f7) {
		this.f7=f7;
		return this;
	}
	
	/**
	 * 获得 浮点8<br>
	 * 浮点8
	 * @return 浮点8
	*/
	public BigDecimal getF8() {
		return f8;
	}
	
	/**
	 * 设置 浮点8
	 * @param f8 浮点8
	 * @return 当前对象
	*/
	public FormDataExt setF8(BigDecimal f8) {
		this.f8=f8;
		return this;
	}
	
	/**
	 * 获得 浮点9<br>
	 * 浮点9
	 * @return 浮点9
	*/
	public BigDecimal getF9() {
		return f9;
	}
	
	/**
	 * 设置 浮点9
	 * @param f9 浮点9
	 * @return 当前对象
	*/
	public FormDataExt setF9(BigDecimal f9) {
		this.f9=f9;
		return this;
	}
	
	/**
	 * 获得 浮点10<br>
	 * 浮点10
	 * @return 浮点10
	*/
	public BigDecimal getF10() {
		return f10;
	}
	
	/**
	 * 设置 浮点10
	 * @param f10 浮点10
	 * @return 当前对象
	*/
	public FormDataExt setF10(BigDecimal f10) {
		this.f10=f10;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public FormDataExt setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public FormDataExt setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public FormDataExt setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public FormDataExt setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public FormDataExt setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public FormDataExt setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public FormDataExt setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public FormDataExt setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public FormDataExt setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormDataExt , 转换好的 FormDataExt 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormDataExt , 转换好的 PoJo 对象
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
	public FormDataExt clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FormDataExt duplicate(boolean all) {
		com.dt.platform.domain.common.meta.FormDataExtMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.FormDataExtMeta.$$proxy$$();
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
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormDataExt clone(boolean deep) {
		return EntityContext.clone(FormDataExt.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormDataExt
	 * @param formDataExtMap 包含实体信息的 Map 对象
	 * @return FormDataExt , 转换好的的 FormDataExt 对象
	*/
	@Transient
	public static FormDataExt createFrom(Map<String,Object> formDataExtMap) {
		if(formDataExtMap==null) return null;
		FormDataExt po = create();
		EntityContext.copyProperties(po,formDataExtMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormDataExt
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormDataExt , 转换好的的 FormDataExt 对象
	*/
	@Transient
	public static FormDataExt createFrom(Object pojo) {
		if(pojo==null) return null;
		FormDataExt po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 FormDataExt，等同于 new
	 * @return FormDataExt 对象
	*/
	@Transient
	public static FormDataExt create() {
		return new com.dt.platform.domain.common.meta.FormDataExtMeta.$$proxy$$();
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
			this.setF10(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F10)));
			this.setLs2(DataParser.parse(String.class, map.get(FormDataExtMeta.LS2)));
			this.setLs1(DataParser.parse(String.class, map.get(FormDataExtMeta.LS1)));
			this.setF1(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F1)));
			this.setLs4(DataParser.parse(String.class, map.get(FormDataExtMeta.LS4)));
			this.setF2(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F2)));
			this.setLs3(DataParser.parse(String.class, map.get(FormDataExtMeta.LS3)));
			this.setF3(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F3)));
			this.setF4(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F4)));
			this.setLs5(DataParser.parse(String.class, map.get(FormDataExtMeta.LS5)));
			this.setF5(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F5)));
			this.setF6(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F6)));
			this.setF7(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F7)));
			this.setTs2(DataParser.parse(String.class, map.get(FormDataExtMeta.TS2)));
			this.setF8(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F8)));
			this.setTs1(DataParser.parse(String.class, map.get(FormDataExtMeta.TS1)));
			this.setF9(DataParser.parse(BigDecimal.class, map.get(FormDataExtMeta.F9)));
			this.setTs4(DataParser.parse(String.class, map.get(FormDataExtMeta.TS4)));
			this.setTs3(DataParser.parse(String.class, map.get(FormDataExtMeta.TS3)));
			this.setId(DataParser.parse(String.class, map.get(FormDataExtMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FormDataExtMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FormDataExtMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FormDataExtMeta.DELETE_BY)));
			this.setSs10(DataParser.parse(String.class, map.get(FormDataExtMeta.SS10)));
			this.setD1(DataParser.parse(Date.class, map.get(FormDataExtMeta.D1)));
			this.setD2(DataParser.parse(Date.class, map.get(FormDataExtMeta.D2)));
			this.setD3(DataParser.parse(Date.class, map.get(FormDataExtMeta.D3)));
			this.setSs1(DataParser.parse(String.class, map.get(FormDataExtMeta.SS1)));
			this.setD4(DataParser.parse(Date.class, map.get(FormDataExtMeta.D4)));
			this.setD5(DataParser.parse(Date.class, map.get(FormDataExtMeta.D5)));
			this.setSs3(DataParser.parse(String.class, map.get(FormDataExtMeta.SS3)));
			this.setS11(DataParser.parse(String.class, map.get(FormDataExtMeta.S11)));
			this.setD6(DataParser.parse(Date.class, map.get(FormDataExtMeta.D6)));
			this.setSs2(DataParser.parse(String.class, map.get(FormDataExtMeta.SS2)));
			this.setDataId(DataParser.parse(String.class, map.get(FormDataExtMeta.DATA_ID)));
			this.setSs5(DataParser.parse(String.class, map.get(FormDataExtMeta.SS5)));
			this.setS13(DataParser.parse(String.class, map.get(FormDataExtMeta.S13)));
			this.setSs4(DataParser.parse(String.class, map.get(FormDataExtMeta.SS4)));
			this.setS12(DataParser.parse(String.class, map.get(FormDataExtMeta.S12)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FormDataExtMeta.UPDATE_BY)));
			this.setSs7(DataParser.parse(String.class, map.get(FormDataExtMeta.SS7)));
			this.setS15(DataParser.parse(String.class, map.get(FormDataExtMeta.S15)));
			this.setSs6(DataParser.parse(String.class, map.get(FormDataExtMeta.SS6)));
			this.setS14(DataParser.parse(String.class, map.get(FormDataExtMeta.S14)));
			this.setSs9(DataParser.parse(String.class, map.get(FormDataExtMeta.SS9)));
			this.setS17(DataParser.parse(String.class, map.get(FormDataExtMeta.S17)));
			this.setSs8(DataParser.parse(String.class, map.get(FormDataExtMeta.SS8)));
			this.setS16(DataParser.parse(String.class, map.get(FormDataExtMeta.S16)));
			this.setS19(DataParser.parse(String.class, map.get(FormDataExtMeta.S19)));
			this.setS18(DataParser.parse(String.class, map.get(FormDataExtMeta.S18)));
			this.setI1(DataParser.parse(Integer.class, map.get(FormDataExtMeta.I1)));
			this.setI2(DataParser.parse(Integer.class, map.get(FormDataExtMeta.I2)));
			this.setI3(DataParser.parse(Integer.class, map.get(FormDataExtMeta.I3)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FormDataExtMeta.UPDATE_TIME)));
			this.setI4(DataParser.parse(Integer.class, map.get(FormDataExtMeta.I4)));
			this.setI5(DataParser.parse(Integer.class, map.get(FormDataExtMeta.I5)));
			this.setS20(DataParser.parse(String.class, map.get(FormDataExtMeta.S20)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FormDataExtMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FormDataExtMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FormDataExtMeta.CREATE_TIME)));
			// others
			return true;
		} else {
			try {
				this.setF10( (BigDecimal)map.get(FormDataExtMeta.F10));
				this.setLs2( (String)map.get(FormDataExtMeta.LS2));
				this.setLs1( (String)map.get(FormDataExtMeta.LS1));
				this.setF1( (BigDecimal)map.get(FormDataExtMeta.F1));
				this.setLs4( (String)map.get(FormDataExtMeta.LS4));
				this.setF2( (BigDecimal)map.get(FormDataExtMeta.F2));
				this.setLs3( (String)map.get(FormDataExtMeta.LS3));
				this.setF3( (BigDecimal)map.get(FormDataExtMeta.F3));
				this.setF4( (BigDecimal)map.get(FormDataExtMeta.F4));
				this.setLs5( (String)map.get(FormDataExtMeta.LS5));
				this.setF5( (BigDecimal)map.get(FormDataExtMeta.F5));
				this.setF6( (BigDecimal)map.get(FormDataExtMeta.F6));
				this.setF7( (BigDecimal)map.get(FormDataExtMeta.F7));
				this.setTs2( (String)map.get(FormDataExtMeta.TS2));
				this.setF8( (BigDecimal)map.get(FormDataExtMeta.F8));
				this.setTs1( (String)map.get(FormDataExtMeta.TS1));
				this.setF9( (BigDecimal)map.get(FormDataExtMeta.F9));
				this.setTs4( (String)map.get(FormDataExtMeta.TS4));
				this.setTs3( (String)map.get(FormDataExtMeta.TS3));
				this.setId( (String)map.get(FormDataExtMeta.ID));
				this.setVersion( (Integer)map.get(FormDataExtMeta.VERSION));
				this.setDeleteTime( (Date)map.get(FormDataExtMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(FormDataExtMeta.DELETE_BY));
				this.setSs10( (String)map.get(FormDataExtMeta.SS10));
				this.setD1( (Date)map.get(FormDataExtMeta.D1));
				this.setD2( (Date)map.get(FormDataExtMeta.D2));
				this.setD3( (Date)map.get(FormDataExtMeta.D3));
				this.setSs1( (String)map.get(FormDataExtMeta.SS1));
				this.setD4( (Date)map.get(FormDataExtMeta.D4));
				this.setD5( (Date)map.get(FormDataExtMeta.D5));
				this.setSs3( (String)map.get(FormDataExtMeta.SS3));
				this.setS11( (String)map.get(FormDataExtMeta.S11));
				this.setD6( (Date)map.get(FormDataExtMeta.D6));
				this.setSs2( (String)map.get(FormDataExtMeta.SS2));
				this.setDataId( (String)map.get(FormDataExtMeta.DATA_ID));
				this.setSs5( (String)map.get(FormDataExtMeta.SS5));
				this.setS13( (String)map.get(FormDataExtMeta.S13));
				this.setSs4( (String)map.get(FormDataExtMeta.SS4));
				this.setS12( (String)map.get(FormDataExtMeta.S12));
				this.setUpdateBy( (String)map.get(FormDataExtMeta.UPDATE_BY));
				this.setSs7( (String)map.get(FormDataExtMeta.SS7));
				this.setS15( (String)map.get(FormDataExtMeta.S15));
				this.setSs6( (String)map.get(FormDataExtMeta.SS6));
				this.setS14( (String)map.get(FormDataExtMeta.S14));
				this.setSs9( (String)map.get(FormDataExtMeta.SS9));
				this.setS17( (String)map.get(FormDataExtMeta.S17));
				this.setSs8( (String)map.get(FormDataExtMeta.SS8));
				this.setS16( (String)map.get(FormDataExtMeta.S16));
				this.setS19( (String)map.get(FormDataExtMeta.S19));
				this.setS18( (String)map.get(FormDataExtMeta.S18));
				this.setI1( (Integer)map.get(FormDataExtMeta.I1));
				this.setI2( (Integer)map.get(FormDataExtMeta.I2));
				this.setI3( (Integer)map.get(FormDataExtMeta.I3));
				this.setUpdateTime( (Date)map.get(FormDataExtMeta.UPDATE_TIME));
				this.setI4( (Integer)map.get(FormDataExtMeta.I4));
				this.setI5( (Integer)map.get(FormDataExtMeta.I5));
				this.setS20( (String)map.get(FormDataExtMeta.S20));
				this.setCreateBy( (String)map.get(FormDataExtMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FormDataExtMeta.DELETED));
				this.setCreateTime( (Date)map.get(FormDataExtMeta.CREATE_TIME));
				// others
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
			this.setF10(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F10)));
			this.setLs2(DataParser.parse(String.class, r.getValue(FormDataExtMeta.LS2)));
			this.setLs1(DataParser.parse(String.class, r.getValue(FormDataExtMeta.LS1)));
			this.setF1(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F1)));
			this.setLs4(DataParser.parse(String.class, r.getValue(FormDataExtMeta.LS4)));
			this.setF2(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F2)));
			this.setLs3(DataParser.parse(String.class, r.getValue(FormDataExtMeta.LS3)));
			this.setF3(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F3)));
			this.setF4(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F4)));
			this.setLs5(DataParser.parse(String.class, r.getValue(FormDataExtMeta.LS5)));
			this.setF5(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F5)));
			this.setF6(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F6)));
			this.setF7(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F7)));
			this.setTs2(DataParser.parse(String.class, r.getValue(FormDataExtMeta.TS2)));
			this.setF8(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F8)));
			this.setTs1(DataParser.parse(String.class, r.getValue(FormDataExtMeta.TS1)));
			this.setF9(DataParser.parse(BigDecimal.class, r.getValue(FormDataExtMeta.F9)));
			this.setTs4(DataParser.parse(String.class, r.getValue(FormDataExtMeta.TS4)));
			this.setTs3(DataParser.parse(String.class, r.getValue(FormDataExtMeta.TS3)));
			this.setId(DataParser.parse(String.class, r.getValue(FormDataExtMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FormDataExtMeta.DELETE_BY)));
			this.setSs10(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS10)));
			this.setD1(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.D1)));
			this.setD2(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.D2)));
			this.setD3(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.D3)));
			this.setSs1(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS1)));
			this.setD4(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.D4)));
			this.setD5(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.D5)));
			this.setSs3(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS3)));
			this.setS11(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S11)));
			this.setD6(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.D6)));
			this.setSs2(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS2)));
			this.setDataId(DataParser.parse(String.class, r.getValue(FormDataExtMeta.DATA_ID)));
			this.setSs5(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS5)));
			this.setS13(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S13)));
			this.setSs4(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS4)));
			this.setS12(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S12)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FormDataExtMeta.UPDATE_BY)));
			this.setSs7(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS7)));
			this.setS15(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S15)));
			this.setSs6(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS6)));
			this.setS14(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S14)));
			this.setSs9(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS9)));
			this.setS17(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S17)));
			this.setSs8(DataParser.parse(String.class, r.getValue(FormDataExtMeta.SS8)));
			this.setS16(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S16)));
			this.setS19(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S19)));
			this.setS18(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S18)));
			this.setI1(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.I1)));
			this.setI2(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.I2)));
			this.setI3(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.I3)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.UPDATE_TIME)));
			this.setI4(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.I4)));
			this.setI5(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.I5)));
			this.setS20(DataParser.parse(String.class, r.getValue(FormDataExtMeta.S20)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FormDataExtMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FormDataExtMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FormDataExtMeta.CREATE_TIME)));
			return true;
		} else {
			try {
				this.setF10( (BigDecimal)r.getValue(FormDataExtMeta.F10));
				this.setLs2( (String)r.getValue(FormDataExtMeta.LS2));
				this.setLs1( (String)r.getValue(FormDataExtMeta.LS1));
				this.setF1( (BigDecimal)r.getValue(FormDataExtMeta.F1));
				this.setLs4( (String)r.getValue(FormDataExtMeta.LS4));
				this.setF2( (BigDecimal)r.getValue(FormDataExtMeta.F2));
				this.setLs3( (String)r.getValue(FormDataExtMeta.LS3));
				this.setF3( (BigDecimal)r.getValue(FormDataExtMeta.F3));
				this.setF4( (BigDecimal)r.getValue(FormDataExtMeta.F4));
				this.setLs5( (String)r.getValue(FormDataExtMeta.LS5));
				this.setF5( (BigDecimal)r.getValue(FormDataExtMeta.F5));
				this.setF6( (BigDecimal)r.getValue(FormDataExtMeta.F6));
				this.setF7( (BigDecimal)r.getValue(FormDataExtMeta.F7));
				this.setTs2( (String)r.getValue(FormDataExtMeta.TS2));
				this.setF8( (BigDecimal)r.getValue(FormDataExtMeta.F8));
				this.setTs1( (String)r.getValue(FormDataExtMeta.TS1));
				this.setF9( (BigDecimal)r.getValue(FormDataExtMeta.F9));
				this.setTs4( (String)r.getValue(FormDataExtMeta.TS4));
				this.setTs3( (String)r.getValue(FormDataExtMeta.TS3));
				this.setId( (String)r.getValue(FormDataExtMeta.ID));
				this.setVersion( (Integer)r.getValue(FormDataExtMeta.VERSION));
				this.setDeleteTime( (Date)r.getValue(FormDataExtMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(FormDataExtMeta.DELETE_BY));
				this.setSs10( (String)r.getValue(FormDataExtMeta.SS10));
				this.setD1( (Date)r.getValue(FormDataExtMeta.D1));
				this.setD2( (Date)r.getValue(FormDataExtMeta.D2));
				this.setD3( (Date)r.getValue(FormDataExtMeta.D3));
				this.setSs1( (String)r.getValue(FormDataExtMeta.SS1));
				this.setD4( (Date)r.getValue(FormDataExtMeta.D4));
				this.setD5( (Date)r.getValue(FormDataExtMeta.D5));
				this.setSs3( (String)r.getValue(FormDataExtMeta.SS3));
				this.setS11( (String)r.getValue(FormDataExtMeta.S11));
				this.setD6( (Date)r.getValue(FormDataExtMeta.D6));
				this.setSs2( (String)r.getValue(FormDataExtMeta.SS2));
				this.setDataId( (String)r.getValue(FormDataExtMeta.DATA_ID));
				this.setSs5( (String)r.getValue(FormDataExtMeta.SS5));
				this.setS13( (String)r.getValue(FormDataExtMeta.S13));
				this.setSs4( (String)r.getValue(FormDataExtMeta.SS4));
				this.setS12( (String)r.getValue(FormDataExtMeta.S12));
				this.setUpdateBy( (String)r.getValue(FormDataExtMeta.UPDATE_BY));
				this.setSs7( (String)r.getValue(FormDataExtMeta.SS7));
				this.setS15( (String)r.getValue(FormDataExtMeta.S15));
				this.setSs6( (String)r.getValue(FormDataExtMeta.SS6));
				this.setS14( (String)r.getValue(FormDataExtMeta.S14));
				this.setSs9( (String)r.getValue(FormDataExtMeta.SS9));
				this.setS17( (String)r.getValue(FormDataExtMeta.S17));
				this.setSs8( (String)r.getValue(FormDataExtMeta.SS8));
				this.setS16( (String)r.getValue(FormDataExtMeta.S16));
				this.setS19( (String)r.getValue(FormDataExtMeta.S19));
				this.setS18( (String)r.getValue(FormDataExtMeta.S18));
				this.setI1( (Integer)r.getValue(FormDataExtMeta.I1));
				this.setI2( (Integer)r.getValue(FormDataExtMeta.I2));
				this.setI3( (Integer)r.getValue(FormDataExtMeta.I3));
				this.setUpdateTime( (Date)r.getValue(FormDataExtMeta.UPDATE_TIME));
				this.setI4( (Integer)r.getValue(FormDataExtMeta.I4));
				this.setI5( (Integer)r.getValue(FormDataExtMeta.I5));
				this.setS20( (String)r.getValue(FormDataExtMeta.S20));
				this.setCreateBy( (String)r.getValue(FormDataExtMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FormDataExtMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FormDataExtMeta.CREATE_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}