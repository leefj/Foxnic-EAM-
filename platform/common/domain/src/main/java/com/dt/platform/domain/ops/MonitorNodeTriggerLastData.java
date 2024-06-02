package com.dt.platform.domain.ops;

import com.alibaba.fastjson.JSONObject;

/**
 * 节点
 * <p>节点 , 数据表 ops_monitor_node 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-02 09:28:36
 * @sign BD6845AD8DA9E1B87279F9E9183C07BA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
 */


public class MonitorNodeTriggerLastData {

	private static final long serialVersionUID = 1L;

	private String id;


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;

	private JSONObject sourceData;

	public MonitorNodeTriggerLastData() {
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JSONObject getSourceData() {
		return sourceData;
	}

	public void setSourceData(JSONObject sourceData) {
		this.sourceData = sourceData;
	}




}