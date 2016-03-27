package com.cbms.common;

import java.io.Serializable;

public enum LoginResponseTypeEnum implements Serializable {
	LOGIN_SUCCESS("LOGIN_SUCCESS"), LOGIN_INVALID("LOGIN_INVALID"), LOGIN_FAIL("LOGIN_FAIL"), LOCKED_USER("LOCKED_USER"), LOGIN_FAIL_SYSTEM_ERROR("LOGIN_FAIL_SYSTEM_ERROR");

	private String operationType;

	LoginResponseTypeEnum(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationType() {
		return operationType;
	}
};
