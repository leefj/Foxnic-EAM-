package com.dt.platform.relation;

import com.dt.platform.relation.modules.DCRelationManager;
import com.dt.platform.relation.modules.HRMRelationManager;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.relation.modules.OAuthRelationManager;
import org.github.foxnic.web.relation.modules.SystemRelationManager;


public class EAMRelationManager extends RelationManager {

	public EAMRelationManager() {
		super(
				new OAuthRelationManager(),
				new SystemRelationManager(),
				//
				new HRMRelationManager(),
				new DCRelationManager(),
				new SystemRelationManager()
		);
		//启动动态刷入
		startMonitor();
	}

	public void startMonitor() {
//		if(SpringUtil.isReady()) {
//			SimpleTaskManager tm=new SimpleTaskManager();
//			tm.doIntervalTask(new Runnable() {
//				@Override
//				public void run() {
//					doReConfigAndValidate();
//				}
//			}, 3000);
//		}
	}

	
	protected void doReConfigAndValidate() {
		EAMRelationManager.this.reconfig();
//		FoxnicWebRelationManager.this.validate();
//		Logger.info("FoxnicWebRelationManager Reconfig");
	}

	
	@Override
	protected void config() {}

	 

 
	 

}