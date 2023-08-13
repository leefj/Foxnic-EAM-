package com.dt.platform.wrapper;

import com.dt.platform.framework.PlatformMeta;
import com.foxnicweb.web.contract.framework.ContractMeta;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		// Foxnic-Web
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
		// COMMON
		PlatformMeta.COMMON_PACKAGE,
		// MOBILE
		PlatformMeta.MOBILE_PACKAGE,
		// EAM
		PlatformMeta.SERVICE_EAM_PACKAGE,
		PlatformMeta.DATACENTER_PACKAGE,
		// HR
		PlatformMeta.SERVICE_HR_PACKAGE,
		// CMS
		PlatformMeta.CMS_PACKAGE,
		// OPS
		PlatformMeta.OPS_PACKAGE,
		// OA
		PlatformMeta.OA_PACKAGE,
		// KN
		PlatformMeta.KNOWLEDGEBASE_PACKAGE,
		// JOB
		PlatformMeta.JOB_PACKAGE,
		// 自定义
		PlatformMeta.CUSTOMER_PACKAGE,
		// 合同
		ContractMeta.SERVICE_CONTRACT_PACKAGE
		//PlatformMeta.VEHICLE_PACKAGE,
		//PlatformMeta.WMS_PACKAGE,
		//PlatformMeta.WORKORDER_PACKAGE,
})
@SpringBootApplication
public class WrapperAllApp {
	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}
}
