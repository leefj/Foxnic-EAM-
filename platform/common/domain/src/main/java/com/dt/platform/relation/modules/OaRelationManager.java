package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.OaTables;

import com.dt.platform.domain.oa.SystemInformation;
import com.dt.platform.domain.oa.meta.SystemInformationMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class OaRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupSystemInformation();
	}


	public void setupSystemInformation() {

		this.property(SystemInformationMeta.TYPE_DATA_PROP)
				.using(OaTables.OA_SYSTEM_INFORMATION.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='oa_system_information_type'");

	}


}
