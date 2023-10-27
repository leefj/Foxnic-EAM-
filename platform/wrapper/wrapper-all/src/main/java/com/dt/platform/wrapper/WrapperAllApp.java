package com.dt.platform.wrapper;

import com.dt.platform.framework.PlatformMeta;
import com.foxnicweb.web.contract.framework.ContractMeta;
import com.foxnicweb.web.customer.framework.CustomerMeta;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		// 基础包
		FoxnicWebMeta.SERVICE_STORAGE_PACKAGE ,
		FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE ,
		FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		FoxnicWebMeta.SERVICE_HRM_PACKAGE,
		FoxnicWebMeta.SERVICE_PCM_PACKAGE,
		FoxnicWebMeta.SERVICE_CHANGES_PACKAGE,
		FoxnicWebMeta.SERVICE_BPM_PACKAGE,
		FoxnicWebMeta.SERVICE_DATA_PERM_PACKAGE,
		FoxnicWebMeta.SERVICE_JOB_PACKAGE,
		FoxnicWebMeta.SERVICE_DOCS_PACKAGE,
		FoxnicWebMeta.SERVICE_EXAMPLE_PACKAGE,
		// FRAMEWORK
		PlatformMeta.FRAMEWORK_PACKAGE,
		// Common
		PlatformMeta.COMMON_PACKAGE,
		// Mobile
		PlatformMeta.MOBILE_PACKAGE,
		// Eam
		PlatformMeta.SERVICE_EAM_PACKAGE,
		// Datacenter
		PlatformMeta.DATACENTER_PACKAGE,
		// Hr
		PlatformMeta.SERVICE_HR_PACKAGE,
		// Ops
		PlatformMeta.OPS_PACKAGE,
		// Oa
		PlatformMeta.OA_PACKAGE,
		// Kn
		PlatformMeta.KNOWLEDGEBASE_PACKAGE,
		// Job
		PlatformMeta.JOB_PACKAGE,
		// 合同-Jar引用
		ContractMeta.SERVICE_CONTRACT_PACKAGE,
		// 客户-Jar引用
		CustomerMeta.SERVICE_CUSTOMER_PACKAGE,

})
@SpringBootApplication
public class WrapperAllApp {
	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
		Logger.info("系统启动完成!");
	}
}
