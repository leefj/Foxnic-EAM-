package com.dt.platform.eam.service.bpm;

import com.dt.platform.domain.eam.AssetCollection;
import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.dt.platform.eam.service.IAssetCollectionReturnService;
import com.dt.platform.eam.service.IAssetCollectionService;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.framework.bpm.BpmEventAdaptor;


/**
 * <p>
 * 资产报废 流程回调事件适配器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 11:07:39
*/

public class AssetCollectionBpmEventAdaptor extends BpmEventAdaptor<AssetCollection, IAssetCollectionService> {

	public AssetCollectionBpmEventAdaptor(IAssetCollectionService service) {
		super(service);
	}

	/***
	 * 流程暂存开始，通过返回 BpmActionResult  的 success 或  failure 控制暂存过程是否继续进行
	 * */
	protected BpmActionResult onTemporarySaveStart(BpmEvent event) {
		return event.getActionResult();
	}


	/***
	 * 流程提交/启动开始，通过返回 BpmActionResult  的 success 或  failure 控制流程提交/启动过程是否继续进行
	 * */
	protected BpmActionResult onProcessSubmitStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程待办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程待办处理过程是否继续进行
	 * */
	protected BpmActionResult onTaskStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程节点执行前，此事件由 camunda 提供，返回值仅记录无意义
	 * */
	protected BpmActionResult onNodeStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程节点执行后，此事件由 camunda 提供，返回值仅记录无意义
	 * */
	protected BpmActionResult onNodeEnd(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程撤回开始，通过返回 BpmActionResult  的 success 或  failure 控制流程撤回处理过程是否继续进行
	 * */
	protected BpmActionResult onFetchBackStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程撤回结束，返回值无意义
	 * */
	protected BpmActionResult onFetchBackEnd(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程跳转开始，通过返回 BpmActionResult  的 success 或  failure 控制流程跳转处理过程是否继续进行
	 * */
	protected BpmActionResult onJumpStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程跳转结束， 返回值无意义
	 * */
	protected BpmActionResult onJumpEnd(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程转办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程转办处理过程是否继续进行
	 * */
	protected BpmActionResult onDelegateStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程转办处理结束，返回值无意义
	 * */
	protected BpmActionResult onDelegateEnd(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程废弃开始，通过返回 BpmActionResult  的 success 或  failure 控制流程废弃处理过程是否继续进行
	 * */
	protected BpmActionResult onProcessAbandonStart(BpmEvent event) {
		return event.getActionResult();
	}

	/***
	 * 流程废弃结束，返回值无意义
	 * */
	protected BpmActionResult onProcessAbandonEnd(BpmEvent event) {
		return event.getActionResult();
	}

}