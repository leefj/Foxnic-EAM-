package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.HostEnvInfo;
import java.util.Date;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.InformationSystem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:34:43
 * @sign 08D9D909E436CF7047501E3063967A97
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class HostEnvInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 信息系统 , 类型: java.lang.String
	*/
	public static final String SYSTEM_ID="systemId";
	
	/**
	 * 信息系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> SYSTEM_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,SYSTEM_ID, java.lang.String.class, "信息系统", "信息系统", java.lang.String.class, null);
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final String HOSTNAME="hostname";
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> HOSTNAME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,HOSTNAME, java.lang.String.class, "主机名称", "主机名称", java.lang.String.class, null);
	
	/**
	 * 物理IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * 物理IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,IP, java.lang.String.class, "物理IP", "物理IP", java.lang.String.class, null);
	
	/**
	 * IPv6 , 类型: java.lang.String
	*/
	public static final String IPV6="ipv6";
	
	/**
	 * IPv6 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> IPV6_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,IPV6, java.lang.String.class, "IPv6", "IPv6", java.lang.String.class, null);
	
	/**
	 * VIP , 类型: java.lang.String
	*/
	public static final String VIP="vip";
	
	/**
	 * VIP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> VIP_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,VIP, java.lang.String.class, "VIP", "VIP", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String HOST_DESC="hostDesc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> HOST_DESC_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,HOST_DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final String VOUCHER="voucher";
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> VOUCHER_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,VOUCHER, java.lang.String.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * ciphertextBoxData , 类型: com.dt.platform.domain.ops.CiphertextBoxData
	*/
	public static final String CIPHERTEXT_BOX_DATA="ciphertextBoxData";
	
	/**
	 * ciphertextBoxData , 类型: com.dt.platform.domain.ops.CiphertextBoxData
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,com.dt.platform.domain.ops.CiphertextBoxData> CIPHERTEXT_BOX_DATA_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,CIPHERTEXT_BOX_DATA, com.dt.platform.domain.ops.CiphertextBoxData.class, "ciphertextBoxData", "ciphertextBoxData", com.dt.platform.domain.ops.CiphertextBoxData.class, null);
	
	/**
	 * 信息系统 , 类型: com.dt.platform.domain.ops.InformationSystem
	*/
	public static final String INFO_SYSTEM="infoSystem";
	
	/**
	 * 信息系统 , 类型: com.dt.platform.domain.ops.InformationSystem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfo,com.dt.platform.domain.ops.InformationSystem> INFO_SYSTEM_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfo.class ,INFO_SYSTEM, com.dt.platform.domain.ops.InformationSystem.class, "信息系统", "信息系统", com.dt.platform.domain.ops.InformationSystem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , LABEL , SYSTEM_ID , HOSTNAME , IP , IPV6 , VIP , HOST_DESC , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CIPHERTEXT_BOX_DATA , INFO_SYSTEM };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.HostEnvInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public HostEnvInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public HostEnvInfo setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 信息系统
		 * @param systemId 信息系统
		 * @return 当前对象
		*/
		public HostEnvInfo setSystemId(String systemId) {
			super.change(SYSTEM_ID,super.getSystemId(),systemId);
			super.setSystemId(systemId);
			return this;
		}
		
		/**
		 * 设置 主机名称
		 * @param hostname 主机名称
		 * @return 当前对象
		*/
		public HostEnvInfo setHostname(String hostname) {
			super.change(HOSTNAME,super.getHostname(),hostname);
			super.setHostname(hostname);
			return this;
		}
		
		/**
		 * 设置 物理IP
		 * @param ip 物理IP
		 * @return 当前对象
		*/
		public HostEnvInfo setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 IPv6
		 * @param ipv6 IPv6
		 * @return 当前对象
		*/
		public HostEnvInfo setIpv6(String ipv6) {
			super.change(IPV6,super.getIpv6(),ipv6);
			super.setIpv6(ipv6);
			return this;
		}
		
		/**
		 * 设置 VIP
		 * @param vip VIP
		 * @return 当前对象
		*/
		public HostEnvInfo setVip(String vip) {
			super.change(VIP,super.getVip(),vip);
			super.setVip(vip);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param hostDesc 描述
		 * @return 当前对象
		*/
		public HostEnvInfo setHostDesc(String hostDesc) {
			super.change(HOST_DESC,super.getHostDesc(),hostDesc);
			super.setHostDesc(hostDesc);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucher 凭证
		 * @return 当前对象
		*/
		public HostEnvInfo setVoucher(String voucher) {
			super.change(VOUCHER,super.getVoucher(),voucher);
			super.setVoucher(voucher);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public HostEnvInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public HostEnvInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public HostEnvInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public HostEnvInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public HostEnvInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public HostEnvInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public HostEnvInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public HostEnvInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public HostEnvInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 ciphertextBoxData
		 * @param ciphertextBoxData ciphertextBoxData
		 * @return 当前对象
		*/
		public HostEnvInfo setCiphertextBoxData(CiphertextBoxData ciphertextBoxData) {
			super.change(CIPHERTEXT_BOX_DATA,super.getCiphertextBoxData(),ciphertextBoxData);
			super.setCiphertextBoxData(ciphertextBoxData);
			return this;
		}
		
		/**
		 * 设置 信息系统
		 * @param infoSystem 信息系统
		 * @return 当前对象
		*/
		public HostEnvInfo setInfoSystem(InformationSystem infoSystem) {
			super.change(INFO_SYSTEM,super.getInfoSystem(),infoSystem);
			super.setInfoSystem(infoSystem);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public HostEnvInfo clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public HostEnvInfo duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSystemId(this.getSystemId());
			inst.setNotes(this.getNotes());
			inst.setVoucher(this.getVoucher());
			inst.setIp(this.getIp());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLabel(this.getLabel());
			inst.setVersion(this.getVersion());
			inst.setHostname(this.getHostname());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setIpv6(this.getIpv6());
			inst.setHostDesc(this.getHostDesc());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setVip(this.getVip());
			if(all) {
				inst.setInfoSystem(this.getInfoSystem());
				inst.setCiphertextBoxData(this.getCiphertextBoxData());
			}
			inst.clearModifies();
			return inst;
		}

	}
}