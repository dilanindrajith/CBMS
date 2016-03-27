package com.cbms.common;

import java.io.Serializable;

public enum UserTypeEnum implements Serializable {
	SUPER_ADMIN("SUPER ADMIN"), ADMIN("ADMIN"), SUPER_USER("SUPER USER"), USER("USER");

	private String userType;

	UserTypeEnum(String userType) {
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}
};
