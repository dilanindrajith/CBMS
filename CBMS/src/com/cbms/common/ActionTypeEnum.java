package com.cbms.common;

import java.io.Serializable;

public enum ActionTypeEnum implements Serializable {
	CREATE("create"), 
	MODIFY("modify"),
	CHNG_PWD("chng_pwd"),
	MODIFY_DATA("modify_data"), 
	DELETE("delete"), 
	VIEW("view"), 
	VIEW_PRINT("view_print"), 
	EXTERNAL("external"), 
	ASSIGN("assign"),
	APP_DASHBOARD_VIEW("app_db_view"),
	WEB_MAIN_DASHBOARD_VIEW("web_main_db_view"),
	WEB_SUB_DASHBOARD_VIEW("web_sub_db_view"),
	BRANCH("branch"),
	APP_HEADER("app_header");

	private String actionType;

	ActionTypeEnum(String actionType) {
		this.actionType = actionType;
	}

	public String getActionType() {
		return actionType;
	}
};
