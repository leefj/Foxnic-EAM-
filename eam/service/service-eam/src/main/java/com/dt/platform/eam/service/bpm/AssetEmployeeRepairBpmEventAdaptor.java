package com.dt.platform.eam.service.bpm;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetEmployeeRepair;
import com.dt.platform.eam.service.IAssetEmployeeRepairService;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.framework.bpm.BpmEventAdaptor;
import org.github.foxnic.web.framework.bpm.BpmAssistant;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;



/**
 * <p>
 * 资产报修 流程回调事件适配器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-01 06:12:33
*/

public class AssetEmployeeRepairBpmEventAdaptor extends BpmEventAdaptor<AssetEmployeeRepair,IAssetEmployeeRepairService> {

	public AssetEmployeeRepairBpmEventAdaptor(IAssetEmployeeRepairService service) {
		super(service);
	}

	/***
	 * 流程暂存开始，通过返回 BpmActionResult  的 success 或  failure 控制暂存过程是否继续进行
	 * */
	protected BpmActionResult onTemporarySaveStart(BpmEvent event) {


		System.out.println("onTemporarySaveStart result"+event.getActionResult().code());
		System.out.println("onTemporarySaveStart result"+event.getActionResult().getData());
		System.out.println("onTemporarySaveStart result"+event.getActionResult().getMessage());

		return event.getActionResult();
	}


	/***
	 * 流程提交/启动开始，通过返回 BpmActionResult  的 success 或  failure 控制流程提交/启动过程是否继续进行
	 * */
	protected BpmActionResult onProcessSubmitStart(BpmEvent event) {

		System.out.println("onProcessSubmitStart result"+event.getActionResult().code());
		System.out.println("onProcessSubmitStart result"+event.getActionResult().getData());
		System.out.println("onProcessSubmitStart result"+event.getActionResult().getMessage());
		if(event.getActionResult().isSuccess()){
			 this.dao().execute("update eam_asset_employee_repair set status=? where id=?", AssetHandleStatusEnum.APPROVAL.code(), event.getBillId());
		}
		return event.getActionResult();
	}

	/***
	 * 流程待办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程待办处理过程是否继续进行
	 * */
	protected BpmActionResult onTaskStart(BpmEvent event) {

		System.out.println("onTaskStart result"+event.getActionResult().code());
		System.out.println("onTaskStart result"+event.getActionResult().getData());
		System.out.println("onTaskStart result"+event.getActionResult().getMessage());
		if(event.getActionResult().isSuccess()){
			this.dao().execute("update eam_asset_employee_repair set status=? where id=?", AssetHandleStatusEnum.APPROVAL.code(), event.getBillId());
		}
		return event.getActionResult();
	}

	/***
	 * 流程节点执行前，此事件由 camunda 提供，返回值仅记录无意义
	 * */
	protected BpmActionResult onNodeStart(BpmEvent event) {
		System.out.println("onNodeStart result"+event.getActionResult().code());
		System.out.println("onNodeStart result"+event.getActionResult().getData());
		System.out.println("onNodeStart result"+event.getActionResult().getMessage());
		return event.getActionResult();
	}

	/***
	 * 流程节点执行后，此事件由 camunda 提供，返回值仅记录无意义
	 * */
	protected BpmActionResult onNodeEnd(BpmEvent event) {

		System.out.println("onNodeEnd result"+event.getActionResult().code());
		System.out.println("onNodeEnd result"+event.getActionResult().getData());
		System.out.println("onNodeEnd result"+event.getActionResult().getMessage());
		return event.getActionResult();
	}

	/***
	 * 流程撤回开始，通过返回 BpmActionResult  的 success 或  failure 控制流程撤回处理过程是否继续进行
	 * */
	protected BpmActionResult onFetchBackStart(BpmEvent event) {

		System.out.println("onFetchBackStart result"+event.getActionResult().code());
		System.out.println("onFetchBackStart result"+event.getActionResult().getData());
		System.out.println("onFetchBackStart result"+event.getActionResult().getMessage());
		return event.getActionResult();
	}

	/***
	 * 流程撤回结束，返回值无意义
	 * */
	protected BpmActionResult onFetchBackEnd(BpmEvent event) {
		System.out.println("onFetchBackEnd result"+event);

		return event.getActionResult();
	}

	/***
	 * 流程跳转开始，通过返回 BpmActionResult  的 success 或  failure 控制流程跳转处理过程是否继续进行
	 * */
	protected BpmActionResult onJumpStart(BpmEvent event) {


		System.out.println("onJumpStart result"+event.getActionResult().code());
		System.out.println("onJumpStart result"+event.getActionResult().getData());
		System.out.println("onJumpStart result"+event.getActionResult().getMessage());
		return event.getActionResult();
	}

	/***
	 * 流程跳转结束， 返回值无意义
	 * */
	protected BpmActionResult onJumpEnd(BpmEvent event) {
		System.out.println("onJumpEnd result"+event);
		return event.getActionResult();
	}

	/***
	 * 流程转办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程转办处理过程是否继续进行
	 * */
	protected BpmActionResult onDelegateStart(BpmEvent event) {

		System.out.println("onDelegateStart result"+event.getActionResult().code());
		System.out.println("onDelegateStart result"+event.getActionResult().getData());
		System.out.println("onJumponDelegateStartStart result"+event.getActionResult().getMessage());
		return event.getActionResult();
	}

	/***
	 * 流程转办处理结束，返回值无意义
	 * */
	protected BpmActionResult onDelegateEnd(BpmEvent event) {


		System.out.println("onDelegateEnd result"+event);

		return event.getActionResult();
	}

	/***
	 * 流程废弃开始，通过返回 BpmActionResult  的 success 或  failure 控制流程废弃处理过程是否继续进行
	 * */
	protected BpmActionResult onProcessAbandonStart(BpmEvent event) {
		System.out.println("onProcessAbandonStart result"+event.getActionResult().code());
		System.out.println("onProcessAbandonStart result"+event.getActionResult().getData());
		System.out.println("onProcessAbandonStart result"+event.getActionResult().getMessage());
		return event.getActionResult();
	}

	/***
	 * 流程废弃结束，返回值无意义
	 * */
	protected BpmActionResult onProcessAbandonEnd(BpmEvent event) {

		System.out.println("onProcessAbandonEnd result"+event);

		return event.getActionResult();
	}

}