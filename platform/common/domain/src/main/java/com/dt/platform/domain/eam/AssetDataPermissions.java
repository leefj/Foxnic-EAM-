package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DATA_PERMISSIONS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetDataPermissionsMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产数据权限
 * <p>资产数据权限 , 数据表 eam_asset_data_permissions 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-26 07:51:03
 * @sign CB43B0BCB8C2479D0971F2F596B639D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_data_permissions")
@ApiModel(description = "资产数据权限 ; 资产数据权限 , 数据表 eam_asset_data_permissions 的PO类型")
public class AssetDataPermissions extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DATA_PERMISSIONS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "523894324979568640")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "资产全局数据角色_管理员")
	private String name;
	
	/**
	 * 权限状态：权限状态
	*/
	@ApiModelProperty(required = false,value="权限状态" , notes = "权限状态" , example = "disable")
	private String status;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属" , example = "asset")
	private String ownerCode;
	
	/**
	 * 权限编码：权限编码
	*/
	@ApiModelProperty(required = false,value="权限编码" , notes = "权限编码" , example = "data_perm_1")
	private String code;
	
	/**
	 * 业务角色：业务角色
	*/
	@ApiModelProperty(required = false,value="业务角色" , notes = "业务角色" , example = "eam_data_perm_default_1")
	private String roleCode;
	
	/**
	 * 所属权限状态：所属权限状态
	*/
	@ApiModelProperty(required = false,value="所属权限状态" , notes = "所属权限状态" , example = "disable")
	private String ownOrgAuthorityEnable;
	
	/**
	 * 所在所属状态：所在所属状态
	*/
	@ApiModelProperty(required = false,value="所在所属状态" , notes = "所在所属状态" , example = "disable")
	private String ownOrgLocalEnable;
	
	/**
	 * 所属联动状态：所属联动状态
	*/
	@ApiModelProperty(required = false,value="所属联动状态" , notes = "所属联动状态" , example = "disable")
	private String ownOrgCascadeEnable;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String ownOrgNotes;
	
	/**
	 * 组织权限状态：组织权限状态
	*/
	@ApiModelProperty(required = false,value="组织权限状态" , notes = "组织权限状态" , example = "disable")
	private String orgAuthorityEnable;
	
	/**
	 * 所在组织状态：所在组织状态
	*/
	@ApiModelProperty(required = false,value="所在组织状态" , notes = "所在组织状态" , example = "disable")
	private String orgLocalEnable;
	
	/**
	 * 组织联动状态：组织联动状态
	*/
	@ApiModelProperty(required = false,value="组织联动状态" , notes = "组织联动状态" , example = "disable")
	private String orgCascadeEnable;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String orgNotes;
	
	/**
	 * 分类权限状态：分类权限状态
	*/
	@ApiModelProperty(required = false,value="分类权限状态" , notes = "分类权限状态" , example = "disable")
	private String catalogAuthorityEnable;
	
	/**
	 * 分类级联状态：分类级联状态
	*/
	@ApiModelProperty(required = false,value="分类级联状态" , notes = "分类级联状态" , example = "disable")
	private String catalogCascadeEnable;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String catalogNotes;
	
	/**
	 * 位置权限状态：位置权限状态
	*/
	@ApiModelProperty(required = false,value="位置权限状态" , notes = "位置权限状态" , example = "disable")
	private String positionAuthorityEnable;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String positionNotes;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseAuthorityEnable;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String warehouseNotes;
	
	/**
	 * 优先级：优先级
	*/
	@ApiModelProperty(required = false,value="优先级" , notes = "优先级" , example = "100")
	private Integer priority;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-12-16 04:09:01")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-03-20 06:32:23")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "45")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 业务角色：业务角色
	*/
	@ApiModelProperty(required = false,value="业务角色" , notes = "业务角色")
	private BusiRole busiRole;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<Catalog> category;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<String> categoryIds;
	
	/**
	 * 组织节点：组织节点
	*/
	@ApiModelProperty(required = false,value="组织节点" , notes = "组织节点")
	private List<Organization> organization;
	
	/**
	 * 组织节点：组织节点
	*/
	@ApiModelProperty(required = false,value="组织节点" , notes = "组织节点")
	private List<String> organizationIds;
	
	/**
	 * 所属组织节点：所属组织节点
	*/
	@ApiModelProperty(required = false,value="所属组织节点" , notes = "所属组织节点")
	private List<Organization> ownOrganization;
	
	/**
	 * 所属组织节点：所属组织节点
	*/
	@ApiModelProperty(required = false,value="所属组织节点" , notes = "所属组织节点")
	private List<String> ownOrganizationIds;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private List<Position> position;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private List<String> positionIds;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private List<Warehouse> warehouse;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private List<String> warehouseIds;
	
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
	public AssetDataPermissions setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public AssetDataPermissions setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 权限状态<br>
	 * 权限状态
	 * @return 权限状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 权限状态
	 * @param status 权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 权限编码<br>
	 * 权限编码
	 * @return 权限编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 权限编码
	 * @param code 权限编码
	 * @return 当前对象
	*/
	public AssetDataPermissions setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 业务角色<br>
	 * 业务角色
	 * @return 业务角色
	*/
	public String getRoleCode() {
		return roleCode;
	}
	
	/**
	 * 设置 业务角色
	 * @param roleCode 业务角色
	 * @return 当前对象
	*/
	public AssetDataPermissions setRoleCode(String roleCode) {
		this.roleCode=roleCode;
		return this;
	}
	
	/**
	 * 获得 所属权限状态<br>
	 * 所属权限状态
	 * @return 所属权限状态
	*/
	public String getOwnOrgAuthorityEnable() {
		return ownOrgAuthorityEnable;
	}
	
	/**
	 * 设置 所属权限状态
	 * @param ownOrgAuthorityEnable 所属权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnOrgAuthorityEnable(String ownOrgAuthorityEnable) {
		this.ownOrgAuthorityEnable=ownOrgAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 所在所属状态<br>
	 * 所在所属状态
	 * @return 所在所属状态
	*/
	public String getOwnOrgLocalEnable() {
		return ownOrgLocalEnable;
	}
	
	/**
	 * 设置 所在所属状态
	 * @param ownOrgLocalEnable 所在所属状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnOrgLocalEnable(String ownOrgLocalEnable) {
		this.ownOrgLocalEnable=ownOrgLocalEnable;
		return this;
	}
	
	/**
	 * 获得 所属联动状态<br>
	 * 所属联动状态
	 * @return 所属联动状态
	*/
	public String getOwnOrgCascadeEnable() {
		return ownOrgCascadeEnable;
	}
	
	/**
	 * 设置 所属联动状态
	 * @param ownOrgCascadeEnable 所属联动状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnOrgCascadeEnable(String ownOrgCascadeEnable) {
		this.ownOrgCascadeEnable=ownOrgCascadeEnable;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getOwnOrgNotes() {
		return ownOrgNotes;
	}
	
	/**
	 * 设置 备注
	 * @param ownOrgNotes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnOrgNotes(String ownOrgNotes) {
		this.ownOrgNotes=ownOrgNotes;
		return this;
	}
	
	/**
	 * 获得 组织权限状态<br>
	 * 组织权限状态
	 * @return 组织权限状态
	*/
	public String getOrgAuthorityEnable() {
		return orgAuthorityEnable;
	}
	
	/**
	 * 设置 组织权限状态
	 * @param orgAuthorityEnable 组织权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgAuthorityEnable(String orgAuthorityEnable) {
		this.orgAuthorityEnable=orgAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 所在组织状态<br>
	 * 所在组织状态
	 * @return 所在组织状态
	*/
	public String getOrgLocalEnable() {
		return orgLocalEnable;
	}
	
	/**
	 * 设置 所在组织状态
	 * @param orgLocalEnable 所在组织状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgLocalEnable(String orgLocalEnable) {
		this.orgLocalEnable=orgLocalEnable;
		return this;
	}
	
	/**
	 * 获得 组织联动状态<br>
	 * 组织联动状态
	 * @return 组织联动状态
	*/
	public String getOrgCascadeEnable() {
		return orgCascadeEnable;
	}
	
	/**
	 * 设置 组织联动状态
	 * @param orgCascadeEnable 组织联动状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgCascadeEnable(String orgCascadeEnable) {
		this.orgCascadeEnable=orgCascadeEnable;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getOrgNotes() {
		return orgNotes;
	}
	
	/**
	 * 设置 备注
	 * @param orgNotes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgNotes(String orgNotes) {
		this.orgNotes=orgNotes;
		return this;
	}
	
	/**
	 * 获得 分类权限状态<br>
	 * 分类权限状态
	 * @return 分类权限状态
	*/
	public String getCatalogAuthorityEnable() {
		return catalogAuthorityEnable;
	}
	
	/**
	 * 设置 分类权限状态
	 * @param catalogAuthorityEnable 分类权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setCatalogAuthorityEnable(String catalogAuthorityEnable) {
		this.catalogAuthorityEnable=catalogAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 分类级联状态<br>
	 * 分类级联状态
	 * @return 分类级联状态
	*/
	public String getCatalogCascadeEnable() {
		return catalogCascadeEnable;
	}
	
	/**
	 * 设置 分类级联状态
	 * @param catalogCascadeEnable 分类级联状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setCatalogCascadeEnable(String catalogCascadeEnable) {
		this.catalogCascadeEnable=catalogCascadeEnable;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getCatalogNotes() {
		return catalogNotes;
	}
	
	/**
	 * 设置 备注
	 * @param catalogNotes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setCatalogNotes(String catalogNotes) {
		this.catalogNotes=catalogNotes;
		return this;
	}
	
	/**
	 * 获得 位置权限状态<br>
	 * 位置权限状态
	 * @return 位置权限状态
	*/
	public String getPositionAuthorityEnable() {
		return positionAuthorityEnable;
	}
	
	/**
	 * 设置 位置权限状态
	 * @param positionAuthorityEnable 位置权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setPositionAuthorityEnable(String positionAuthorityEnable) {
		this.positionAuthorityEnable=positionAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getPositionNotes() {
		return positionNotes;
	}
	
	/**
	 * 设置 备注
	 * @param positionNotes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setPositionNotes(String positionNotes) {
		this.positionNotes=positionNotes;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseAuthorityEnable() {
		return warehouseAuthorityEnable;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseAuthorityEnable 仓库
	 * @return 当前对象
	*/
	public AssetDataPermissions setWarehouseAuthorityEnable(String warehouseAuthorityEnable) {
		this.warehouseAuthorityEnable=warehouseAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getWarehouseNotes() {
		return warehouseNotes;
	}
	
	/**
	 * 设置 备注
	 * @param warehouseNotes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setWarehouseNotes(String warehouseNotes) {
		this.warehouseNotes=warehouseNotes;
		return this;
	}
	
	/**
	 * 获得 优先级<br>
	 * 优先级
	 * @return 优先级
	*/
	public Integer getPriority() {
		return priority;
	}
	
	/**
	 * 设置 优先级
	 * @param priority 优先级
	 * @return 当前对象
	*/
	public AssetDataPermissions setPriority(Integer priority) {
		this.priority=priority;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setNotes(String notes) {
		this.notes=notes;
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
	public AssetDataPermissions setCreateBy(String createBy) {
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
	public AssetDataPermissions setCreateTime(Date createTime) {
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
	public AssetDataPermissions setUpdateBy(String updateBy) {
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
	public AssetDataPermissions setUpdateTime(Date updateTime) {
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
	public AssetDataPermissions setDeleted(Integer deleted) {
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
	public AssetDataPermissions setDeleted(Boolean deletedBool) {
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
	public AssetDataPermissions setDeleteBy(String deleteBy) {
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
	public AssetDataPermissions setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public AssetDataPermissions setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public AssetDataPermissions setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 业务角色<br>
	 * 业务角色
	 * @return 业务角色
	*/
	public BusiRole getBusiRole() {
		return busiRole;
	}
	
	/**
	 * 设置 业务角色
	 * @param busiRole 业务角色
	 * @return 当前对象
	*/
	public AssetDataPermissions setBusiRole(BusiRole busiRole) {
		this.busiRole=busiRole;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<Catalog> getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions setCategory(List<Catalog> category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param entity 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions addCategory(Catalog... entity) {
		if(this.category==null) category=new ArrayList<>();
		this.category.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryIds 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions setCategoryIds(List<String> categoryIds) {
		this.categoryIds=categoryIds;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions addCategoryId(String... categoryId) {
		if(this.categoryIds==null) categoryIds=new ArrayList<>();
		this.categoryIds.addAll(Arrays.asList(categoryId));
		return this;
	}
	
	/**
	 * 获得 组织节点<br>
	 * 组织节点
	 * @return 组织节点
	*/
	public List<Organization> getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 组织节点
	 * @param organization 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrganization(List<Organization> organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 添加 组织节点
	 * @param entity 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions addOrganization(Organization... entity) {
		if(this.organization==null) organization=new ArrayList<>();
		this.organization.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 组织节点<br>
	 * 组织节点
	 * @return 组织节点
	*/
	public List<String> getOrganizationIds() {
		return organizationIds;
	}
	
	/**
	 * 设置 组织节点
	 * @param organizationIds 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrganizationIds(List<String> organizationIds) {
		this.organizationIds=organizationIds;
		return this;
	}
	
	/**
	 * 添加 组织节点
	 * @param organizationId 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions addOrganizationId(String... organizationId) {
		if(this.organizationIds==null) organizationIds=new ArrayList<>();
		this.organizationIds.addAll(Arrays.asList(organizationId));
		return this;
	}
	
	/**
	 * 获得 所属组织节点<br>
	 * 所属组织节点
	 * @return 所属组织节点
	*/
	public List<Organization> getOwnOrganization() {
		return ownOrganization;
	}
	
	/**
	 * 设置 所属组织节点
	 * @param ownOrganization 所属组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnOrganization(List<Organization> ownOrganization) {
		this.ownOrganization=ownOrganization;
		return this;
	}
	
	/**
	 * 添加 所属组织节点
	 * @param entity 所属组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions addOwnOrganization(Organization... entity) {
		if(this.ownOrganization==null) ownOrganization=new ArrayList<>();
		this.ownOrganization.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 所属组织节点<br>
	 * 所属组织节点
	 * @return 所属组织节点
	*/
	public List<String> getOwnOrganizationIds() {
		return ownOrganizationIds;
	}
	
	/**
	 * 设置 所属组织节点
	 * @param ownOrganizationIds 所属组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnOrganizationIds(List<String> ownOrganizationIds) {
		this.ownOrganizationIds=ownOrganizationIds;
		return this;
	}
	
	/**
	 * 添加 所属组织节点
	 * @param ownOrganizationId 所属组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions addOwnOrganizationId(String... ownOrganizationId) {
		if(this.ownOrganizationIds==null) ownOrganizationIds=new ArrayList<>();
		this.ownOrganizationIds.addAll(Arrays.asList(ownOrganizationId));
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public List<Position> getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions setPosition(List<Position> position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 添加 存放位置
	 * @param entity 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions addPosition(Position... entity) {
		if(this.position==null) position=new ArrayList<>();
		this.position.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public List<String> getPositionIds() {
		return positionIds;
	}
	
	/**
	 * 设置 存放位置
	 * @param positionIds 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions setPositionIds(List<String> positionIds) {
		this.positionIds=positionIds;
		return this;
	}
	
	/**
	 * 添加 存放位置
	 * @param positionId 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions addPositionId(String... positionId) {
		if(this.positionIds==null) positionIds=new ArrayList<>();
		this.positionIds.addAll(Arrays.asList(positionId));
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public List<Warehouse> getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public AssetDataPermissions setWarehouse(List<Warehouse> warehouse) {
		this.warehouse=warehouse;
		return this;
	}
	
	/**
	 * 添加 仓库
	 * @param entity 仓库
	 * @return 当前对象
	*/
	public AssetDataPermissions addWarehouse(Warehouse... entity) {
		if(this.warehouse==null) warehouse=new ArrayList<>();
		this.warehouse.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public List<String> getWarehouseIds() {
		return warehouseIds;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseIds 仓库
	 * @return 当前对象
	*/
	public AssetDataPermissions setWarehouseIds(List<String> warehouseIds) {
		this.warehouseIds=warehouseIds;
		return this;
	}
	
	/**
	 * 添加 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public AssetDataPermissions addWarehouseId(String... warehouseId) {
		if(this.warehouseIds==null) warehouseIds=new ArrayList<>();
		this.warehouseIds.addAll(Arrays.asList(warehouseId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDataPermissions , 转换好的 AssetDataPermissions 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDataPermissions , 转换好的 PoJo 对象
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
	public AssetDataPermissions clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDataPermissions duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDataPermissionsMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDataPermissionsMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setPositionNotes(this.getPositionNotes());
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setCatalogCascadeEnable(this.getCatalogCascadeEnable());
		inst.setCatalogNotes(this.getCatalogNotes());
		inst.setOwnOrgLocalEnable(this.getOwnOrgLocalEnable());
		inst.setWarehouseAuthorityEnable(this.getWarehouseAuthorityEnable());
		inst.setOrgAuthorityEnable(this.getOrgAuthorityEnable());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setOrgNotes(this.getOrgNotes());
		inst.setRoleCode(this.getRoleCode());
		inst.setOrgLocalEnable(this.getOrgLocalEnable());
		inst.setOwnOrgNotes(this.getOwnOrgNotes());
		inst.setCatalogAuthorityEnable(this.getCatalogAuthorityEnable());
		inst.setId(this.getId());
		inst.setOwnOrgCascadeEnable(this.getOwnOrgCascadeEnable());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPriority(this.getPriority());
		inst.setVersion(this.getVersion());
		inst.setOrgCascadeEnable(this.getOrgCascadeEnable());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOwnOrgAuthorityEnable(this.getOwnOrgAuthorityEnable());
		inst.setName(this.getName());
		inst.setPositionAuthorityEnable(this.getPositionAuthorityEnable());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setWarehouseNotes(this.getWarehouseNotes());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnOrganization(this.getOwnOrganization());
			inst.setPositionIds(this.getPositionIds());
			inst.setCategoryIds(this.getCategoryIds());
			inst.setOrganizationIds(this.getOrganizationIds());
			inst.setBusiRole(this.getBusiRole());
			inst.setOrganization(this.getOrganization());
			inst.setOwnOrganizationIds(this.getOwnOrganizationIds());
			inst.setPosition(this.getPosition());
			inst.setCategory(this.getCategory());
			inst.setWarehouse(this.getWarehouse());
			inst.setWarehouseIds(this.getWarehouseIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDataPermissions clone(boolean deep) {
		return EntityContext.clone(AssetDataPermissions.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDataPermissions
	 * @param assetDataPermissionsMap 包含实体信息的 Map 对象
	 * @return AssetDataPermissions , 转换好的的 AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissions createFrom(Map<String,Object> assetDataPermissionsMap) {
		if(assetDataPermissionsMap==null) return null;
		AssetDataPermissions po = create();
		EntityContext.copyProperties(po,assetDataPermissionsMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDataPermissions
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDataPermissions , 转换好的的 AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissions createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDataPermissions po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetDataPermissions，等同于 new
	 * @return AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissions create() {
		return new com.dt.platform.domain.eam.meta.AssetDataPermissionsMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.CODE)));
			this.setPositionNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.POSITION_NOTES)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.OWNER_CODE)));
			this.setCatalogCascadeEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.CATALOG_CASCADE_ENABLE)));
			this.setCatalogNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.CATALOG_NOTES)));
			this.setOwnOrgLocalEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.OWN_ORG_LOCAL_ENABLE)));
			this.setWarehouseAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.WAREHOUSE_AUTHORITY_ENABLE)));
			this.setOrgAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.ORG_AUTHORITY_ENABLE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.UPDATE_BY)));
			this.setOrgNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.ORG_NOTES)));
			this.setRoleCode(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.ROLE_CODE)));
			this.setOrgLocalEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.ORG_LOCAL_ENABLE)));
			this.setOwnOrgNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.OWN_ORG_NOTES)));
			this.setCatalogAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.CATALOG_AUTHORITY_ENABLE)));
			this.setId(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.ID)));
			this.setOwnOrgCascadeEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.OWN_ORG_CASCADE_ENABLE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDataPermissionsMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(Integer.class, map.get(AssetDataPermissionsMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDataPermissionsMeta.VERSION)));
			this.setOrgCascadeEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.ORG_CASCADE_ENABLE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDataPermissionsMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDataPermissionsMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDataPermissionsMeta.DELETE_TIME)));
			this.setOwnOrgAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.OWN_ORG_AUTHORITY_ENABLE)));
			this.setName(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.NAME)));
			this.setPositionAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.POSITION_AUTHORITY_ENABLE)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.DELETE_BY)));
			this.setWarehouseNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.WAREHOUSE_NOTES)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDataPermissionsMeta.STATUS)));
			// others
			this.setBusiRole(DataParser.parse(BusiRole.class, map.get(AssetDataPermissionsMeta.BUSI_ROLE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(AssetDataPermissionsMeta.CODE));
				this.setPositionNotes( (String)map.get(AssetDataPermissionsMeta.POSITION_NOTES));
				this.setNotes( (String)map.get(AssetDataPermissionsMeta.NOTES));
				this.setOwnerCode( (String)map.get(AssetDataPermissionsMeta.OWNER_CODE));
				this.setCatalogCascadeEnable( (String)map.get(AssetDataPermissionsMeta.CATALOG_CASCADE_ENABLE));
				this.setCatalogNotes( (String)map.get(AssetDataPermissionsMeta.CATALOG_NOTES));
				this.setOwnOrgLocalEnable( (String)map.get(AssetDataPermissionsMeta.OWN_ORG_LOCAL_ENABLE));
				this.setWarehouseAuthorityEnable( (String)map.get(AssetDataPermissionsMeta.WAREHOUSE_AUTHORITY_ENABLE));
				this.setOrgAuthorityEnable( (String)map.get(AssetDataPermissionsMeta.ORG_AUTHORITY_ENABLE));
				this.setUpdateBy( (String)map.get(AssetDataPermissionsMeta.UPDATE_BY));
				this.setOrgNotes( (String)map.get(AssetDataPermissionsMeta.ORG_NOTES));
				this.setRoleCode( (String)map.get(AssetDataPermissionsMeta.ROLE_CODE));
				this.setOrgLocalEnable( (String)map.get(AssetDataPermissionsMeta.ORG_LOCAL_ENABLE));
				this.setOwnOrgNotes( (String)map.get(AssetDataPermissionsMeta.OWN_ORG_NOTES));
				this.setCatalogAuthorityEnable( (String)map.get(AssetDataPermissionsMeta.CATALOG_AUTHORITY_ENABLE));
				this.setId( (String)map.get(AssetDataPermissionsMeta.ID));
				this.setOwnOrgCascadeEnable( (String)map.get(AssetDataPermissionsMeta.OWN_ORG_CASCADE_ENABLE));
				this.setUpdateTime( (Date)map.get(AssetDataPermissionsMeta.UPDATE_TIME));
				this.setPriority( (Integer)map.get(AssetDataPermissionsMeta.PRIORITY));
				this.setVersion( (Integer)map.get(AssetDataPermissionsMeta.VERSION));
				this.setOrgCascadeEnable( (String)map.get(AssetDataPermissionsMeta.ORG_CASCADE_ENABLE));
				this.setCreateBy( (String)map.get(AssetDataPermissionsMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDataPermissionsMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDataPermissionsMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetDataPermissionsMeta.DELETE_TIME));
				this.setOwnOrgAuthorityEnable( (String)map.get(AssetDataPermissionsMeta.OWN_ORG_AUTHORITY_ENABLE));
				this.setName( (String)map.get(AssetDataPermissionsMeta.NAME));
				this.setPositionAuthorityEnable( (String)map.get(AssetDataPermissionsMeta.POSITION_AUTHORITY_ENABLE));
				this.setTenantId( (String)map.get(AssetDataPermissionsMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDataPermissionsMeta.DELETE_BY));
				this.setWarehouseNotes( (String)map.get(AssetDataPermissionsMeta.WAREHOUSE_NOTES));
				this.setStatus( (String)map.get(AssetDataPermissionsMeta.STATUS));
				// others
				this.setBusiRole( (BusiRole)map.get(AssetDataPermissionsMeta.BUSI_ROLE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.CODE)));
			this.setPositionNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.POSITION_NOTES)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.OWNER_CODE)));
			this.setCatalogCascadeEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.CATALOG_CASCADE_ENABLE)));
			this.setCatalogNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.CATALOG_NOTES)));
			this.setOwnOrgLocalEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.OWN_ORG_LOCAL_ENABLE)));
			this.setWarehouseAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.WAREHOUSE_AUTHORITY_ENABLE)));
			this.setOrgAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.ORG_AUTHORITY_ENABLE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.UPDATE_BY)));
			this.setOrgNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.ORG_NOTES)));
			this.setRoleCode(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.ROLE_CODE)));
			this.setOrgLocalEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.ORG_LOCAL_ENABLE)));
			this.setOwnOrgNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.OWN_ORG_NOTES)));
			this.setCatalogAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.CATALOG_AUTHORITY_ENABLE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.ID)));
			this.setOwnOrgCascadeEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.OWN_ORG_CASCADE_ENABLE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDataPermissionsMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(Integer.class, r.getValue(AssetDataPermissionsMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDataPermissionsMeta.VERSION)));
			this.setOrgCascadeEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.ORG_CASCADE_ENABLE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDataPermissionsMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDataPermissionsMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDataPermissionsMeta.DELETE_TIME)));
			this.setOwnOrgAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.OWN_ORG_AUTHORITY_ENABLE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.NAME)));
			this.setPositionAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.POSITION_AUTHORITY_ENABLE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.DELETE_BY)));
			this.setWarehouseNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.WAREHOUSE_NOTES)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDataPermissionsMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(AssetDataPermissionsMeta.CODE));
				this.setPositionNotes( (String)r.getValue(AssetDataPermissionsMeta.POSITION_NOTES));
				this.setNotes( (String)r.getValue(AssetDataPermissionsMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(AssetDataPermissionsMeta.OWNER_CODE));
				this.setCatalogCascadeEnable( (String)r.getValue(AssetDataPermissionsMeta.CATALOG_CASCADE_ENABLE));
				this.setCatalogNotes( (String)r.getValue(AssetDataPermissionsMeta.CATALOG_NOTES));
				this.setOwnOrgLocalEnable( (String)r.getValue(AssetDataPermissionsMeta.OWN_ORG_LOCAL_ENABLE));
				this.setWarehouseAuthorityEnable( (String)r.getValue(AssetDataPermissionsMeta.WAREHOUSE_AUTHORITY_ENABLE));
				this.setOrgAuthorityEnable( (String)r.getValue(AssetDataPermissionsMeta.ORG_AUTHORITY_ENABLE));
				this.setUpdateBy( (String)r.getValue(AssetDataPermissionsMeta.UPDATE_BY));
				this.setOrgNotes( (String)r.getValue(AssetDataPermissionsMeta.ORG_NOTES));
				this.setRoleCode( (String)r.getValue(AssetDataPermissionsMeta.ROLE_CODE));
				this.setOrgLocalEnable( (String)r.getValue(AssetDataPermissionsMeta.ORG_LOCAL_ENABLE));
				this.setOwnOrgNotes( (String)r.getValue(AssetDataPermissionsMeta.OWN_ORG_NOTES));
				this.setCatalogAuthorityEnable( (String)r.getValue(AssetDataPermissionsMeta.CATALOG_AUTHORITY_ENABLE));
				this.setId( (String)r.getValue(AssetDataPermissionsMeta.ID));
				this.setOwnOrgCascadeEnable( (String)r.getValue(AssetDataPermissionsMeta.OWN_ORG_CASCADE_ENABLE));
				this.setUpdateTime( (Date)r.getValue(AssetDataPermissionsMeta.UPDATE_TIME));
				this.setPriority( (Integer)r.getValue(AssetDataPermissionsMeta.PRIORITY));
				this.setVersion( (Integer)r.getValue(AssetDataPermissionsMeta.VERSION));
				this.setOrgCascadeEnable( (String)r.getValue(AssetDataPermissionsMeta.ORG_CASCADE_ENABLE));
				this.setCreateBy( (String)r.getValue(AssetDataPermissionsMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDataPermissionsMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDataPermissionsMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetDataPermissionsMeta.DELETE_TIME));
				this.setOwnOrgAuthorityEnable( (String)r.getValue(AssetDataPermissionsMeta.OWN_ORG_AUTHORITY_ENABLE));
				this.setName( (String)r.getValue(AssetDataPermissionsMeta.NAME));
				this.setPositionAuthorityEnable( (String)r.getValue(AssetDataPermissionsMeta.POSITION_AUTHORITY_ENABLE));
				this.setTenantId( (String)r.getValue(AssetDataPermissionsMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDataPermissionsMeta.DELETE_BY));
				this.setWarehouseNotes( (String)r.getValue(AssetDataPermissionsMeta.WAREHOUSE_NOTES));
				this.setStatus( (String)r.getValue(AssetDataPermissionsMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}