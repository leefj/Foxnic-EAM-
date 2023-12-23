package com.dt.platform.domain.eam;

import com.dt.platform.constants.db.EAMTables.EAM_BRAND;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.sql.meta.DBTable;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.BusiRole;
import javax.persistence.Transient;
import java.util.List;
import java.util.Map;


public class DpEmployee extends Employee {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_BRAND.$TABLE;

	@ApiModelProperty(required = false,value="角色" , notes = "角色")
	private String dpRole;

	public String getDpRole() {
		return dpRole;
	}

	public void setDpRole(String dpRole) {
		this.dpRole = dpRole;
	}

	public List<BusiRole> getDpRoleList() {
		return dpRoleList;
	}

	public void setDpRoleList(List<BusiRole> dpRoleList) {
		this.dpRoleList = dpRoleList;
	}

	@ApiModelProperty(required = false,value="角色" , notes = "角色")
	private List<BusiRole> dpRoleList;


	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Brand , 转换好的 Brand 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Brand , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Brand
	 * @param brandMap 包含实体信息的 Map 对象
	 * @return Brand , 转换好的的 Brand 对象
	*/
	@Transient
	public static DpEmployee createFrom(Map<String,Object> brandMap) {
		if(brandMap==null) return null;
		DpEmployee po = EntityContext.create(DpEmployee.class, brandMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Brand
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Brand , 转换好的的 Brand 对象
	*/
	@Transient
	public static DpEmployee createFrom(Object pojo) {
		if(pojo==null) return null;
		DpEmployee po = EntityContext.create(DpEmployee.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Brand，等同于 new
	 * @return Brand 对象
	*/
	@Transient
	public static DpEmployee create() {
		return EntityContext.create(DpEmployee.class);
	}
}