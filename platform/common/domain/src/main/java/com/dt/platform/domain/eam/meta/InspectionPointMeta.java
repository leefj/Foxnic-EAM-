package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionPoint;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.InspectionPointPos;
import com.dt.platform.domain.eam.CheckItem;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 13:48:29
 * @sign 24DD05B5189BC8264146C960BA1DD4AF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionPointMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 巡检内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 巡检内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,CONTENT, java.lang.String.class, "巡检内容", "巡检内容", java.lang.String.class, null);
	
	/**
	 * 巡检路线 , 类型: java.lang.String
	*/
	public static final String ROUTE_ID="routeId";
	
	/**
	 * 巡检路线 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> ROUTE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ROUTE_ID, java.lang.String.class, "巡检路线", "巡检路线", java.lang.String.class, null);
	
	/**
	 * RFID , 类型: java.lang.String
	*/
	public static final String RFID="rfid";
	
	/**
	 * RFID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> RFID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,RFID, java.lang.String.class, "RFID", "RFID", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POS_ID="posId";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> POS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,POS_ID, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 位置详情 , 类型: java.lang.String
	*/
	public static final String POS="pos";
	
	/**
	 * 位置详情 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> POS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,POS, java.lang.String.class, "位置详情", "位置详情", java.lang.String.class, null);
	
	/**
	 * 位置经度 , 类型: java.math.BigDecimal
	*/
	public static final String POS_LONGITUDE="posLongitude";
	
	/**
	 * 位置经度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.math.BigDecimal> POS_LONGITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,POS_LONGITUDE, java.math.BigDecimal.class, "位置经度", "位置经度", java.math.BigDecimal.class, null);
	
	/**
	 * 位置纬度 , 类型: java.math.BigDecimal
	*/
	public static final String POS_LATITUDE="posLatitude";
	
	/**
	 * 位置纬度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.math.BigDecimal> POS_LATITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,POS_LATITUDE, java.math.BigDecimal.class, "位置纬度", "位置纬度", java.math.BigDecimal.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 关联设备 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 关联设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ASSET_ID, java.lang.String.class, "关联设备", "关联设备", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * asset , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * asset , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "asset", "asset", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * route , 类型: com.dt.platform.domain.eam.InspectionRoute
	*/
	public static final String ROUTE="route";
	
	/**
	 * route , 类型: com.dt.platform.domain.eam.InspectionRoute
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,com.dt.platform.domain.eam.InspectionRoute> ROUTE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ROUTE, com.dt.platform.domain.eam.InspectionRoute.class, "route", "route", com.dt.platform.domain.eam.InspectionRoute.class, null);
	
	/**
	 * inspectionPointPos , 类型: com.dt.platform.domain.eam.InspectionPointPos
	*/
	public static final String INSPECTION_POINT_POS="inspectionPointPos";
	
	/**
	 * inspectionPointPos , 类型: com.dt.platform.domain.eam.InspectionPointPos
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,com.dt.platform.domain.eam.InspectionPointPos> INSPECTION_POINT_POS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,INSPECTION_POINT_POS, com.dt.platform.domain.eam.InspectionPointPos.class, "inspectionPointPos", "inspectionPointPos", com.dt.platform.domain.eam.InspectionPointPos.class, null);
	
	/**
	 * checkItemList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.CheckItem
	*/
	public static final String CHECK_ITEM_LIST="checkItemList";
	
	/**
	 * checkItemList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.CheckItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,com.dt.platform.domain.eam.CheckItem> CHECK_ITEM_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,CHECK_ITEM_LIST, java.util.List.class, "checkItemList", "checkItemList", com.dt.platform.domain.eam.CheckItem.class, null);
	
	/**
	 * idsList , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS_LIST="idsList";
	
	/**
	 * idsList , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> IDS_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,IDS_LIST, java.util.List.class, "idsList", "idsList", java.lang.String.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * itemCount , 类型: java.lang.String
	*/
	public static final String ITEM_COUNT="itemCount";
	
	/**
	 * itemCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> ITEM_COUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ITEM_COUNT, java.lang.String.class, "itemCount", "itemCount", java.lang.String.class, null);
	
	/**
	 * itemDisableCount , 类型: java.lang.String
	*/
	public static final String ITEM_DISABLE_COUNT="itemDisableCount";
	
	/**
	 * itemDisableCount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPoint,java.lang.String> ITEM_DISABLE_COUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPoint.class ,ITEM_DISABLE_COUNT, java.lang.String.class, "itemDisableCount", "itemDisableCount", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , STATUS , CONTENT , ROUTE_ID , RFID , POS_ID , POS , POS_LONGITUDE , POS_LATITUDE , PICTURE_ID , NOTES , ASSET_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , ASSET , ROUTE , INSPECTION_POINT_POS , CHECK_ITEM_LIST , IDS_LIST , SELECTED_CODE , ITEM_COUNT , ITEM_DISABLE_COUNT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionPoint {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionPoint setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public InspectionPoint setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public InspectionPoint setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public InspectionPoint setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 巡检内容
		 * @param content 巡检内容
		 * @return 当前对象
		*/
		public InspectionPoint setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 巡检路线
		 * @param routeId 巡检路线
		 * @return 当前对象
		*/
		public InspectionPoint setRouteId(String routeId) {
			super.change(ROUTE_ID,super.getRouteId(),routeId);
			super.setRouteId(routeId);
			return this;
		}
		
		/**
		 * 设置 RFID
		 * @param rfid RFID
		 * @return 当前对象
		*/
		public InspectionPoint setRfid(String rfid) {
			super.change(RFID,super.getRfid(),rfid);
			super.setRfid(rfid);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param posId 位置
		 * @return 当前对象
		*/
		public InspectionPoint setPosId(String posId) {
			super.change(POS_ID,super.getPosId(),posId);
			super.setPosId(posId);
			return this;
		}
		
		/**
		 * 设置 位置详情
		 * @param pos 位置详情
		 * @return 当前对象
		*/
		public InspectionPoint setPos(String pos) {
			super.change(POS,super.getPos(),pos);
			super.setPos(pos);
			return this;
		}
		
		/**
		 * 设置 位置经度
		 * @param posLongitude 位置经度
		 * @return 当前对象
		*/
		public InspectionPoint setPosLongitude(BigDecimal posLongitude) {
			super.change(POS_LONGITUDE,super.getPosLongitude(),posLongitude);
			super.setPosLongitude(posLongitude);
			return this;
		}
		
		/**
		 * 设置 位置纬度
		 * @param posLatitude 位置纬度
		 * @return 当前对象
		*/
		public InspectionPoint setPosLatitude(BigDecimal posLatitude) {
			super.change(POS_LATITUDE,super.getPosLatitude(),posLatitude);
			super.setPosLatitude(posLatitude);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public InspectionPoint setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionPoint setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 关联设备
		 * @param assetId 关联设备
		 * @return 当前对象
		*/
		public InspectionPoint setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionPoint setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionPoint setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionPoint setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionPoint setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionPoint setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionPoint setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionPoint setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionPoint setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionPoint setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 asset
		 * @param asset asset
		 * @return 当前对象
		*/
		public InspectionPoint setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 route
		 * @param route route
		 * @return 当前对象
		*/
		public InspectionPoint setRoute(InspectionRoute route) {
			super.change(ROUTE,super.getRoute(),route);
			super.setRoute(route);
			return this;
		}
		
		/**
		 * 设置 inspectionPointPos
		 * @param inspectionPointPos inspectionPointPos
		 * @return 当前对象
		*/
		public InspectionPoint setInspectionPointPos(InspectionPointPos inspectionPointPos) {
			super.change(INSPECTION_POINT_POS,super.getInspectionPointPos(),inspectionPointPos);
			super.setInspectionPointPos(inspectionPointPos);
			return this;
		}
		
		/**
		 * 设置 checkItemList
		 * @param checkItemList checkItemList
		 * @return 当前对象
		*/
		public InspectionPoint setCheckItemList(List<CheckItem> checkItemList) {
			super.change(CHECK_ITEM_LIST,super.getCheckItemList(),checkItemList);
			super.setCheckItemList(checkItemList);
			return this;
		}
		
		/**
		 * 设置 idsList
		 * @param idsList idsList
		 * @return 当前对象
		*/
		public InspectionPoint setIdsList(List<String> idsList) {
			super.change(IDS_LIST,super.getIdsList(),idsList);
			super.setIdsList(idsList);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public InspectionPoint setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 itemCount
		 * @param itemCount itemCount
		 * @return 当前对象
		*/
		public InspectionPoint setItemCount(String itemCount) {
			super.change(ITEM_COUNT,super.getItemCount(),itemCount);
			super.setItemCount(itemCount);
			return this;
		}
		
		/**
		 * 设置 itemDisableCount
		 * @param itemDisableCount itemDisableCount
		 * @return 当前对象
		*/
		public InspectionPoint setItemDisableCount(String itemDisableCount) {
			super.change(ITEM_DISABLE_COUNT,super.getItemDisableCount(),itemDisableCount);
			super.setItemDisableCount(itemDisableCount);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InspectionPoint clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InspectionPoint duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setPosLatitude(this.getPosLatitude());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setPosId(this.getPosId());
			inst.setCreateBy(this.getCreateBy());
			inst.setRouteId(this.getRouteId());
			inst.setDeleted(this.getDeleted());
			inst.setPictureId(this.getPictureId());
			inst.setPos(this.getPos());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssetId(this.getAssetId());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setRfid(this.getRfid());
			inst.setPosLongitude(this.getPosLongitude());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setCheckItemList(this.getCheckItemList());
				inst.setRoute(this.getRoute());
				inst.setInspectionPointPos(this.getInspectionPointPos());
				inst.setAsset(this.getAsset());
				inst.setIdsList(this.getIdsList());
				inst.setSelectedCode(this.getSelectedCode());
				inst.setItemCount(this.getItemCount());
				inst.setItemDisableCount(this.getItemDisableCount());
			}
			inst.clearModifies();
			return inst;
		}

	}
}