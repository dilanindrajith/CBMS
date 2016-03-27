package com.cbms.common;

import java.io.Serializable;

public enum AccessTypeEnum implements Serializable {
	WEB("WEB"), MOBILE("MOBILE");

	private String accessType;

	AccessTypeEnum(String accessType) {
		this.accessType = accessType;
	}

	public String getAccessType() {
		return accessType;
	}
};
