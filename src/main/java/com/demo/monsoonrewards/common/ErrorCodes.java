package com.demo.monsoonrewards.common;

public enum ErrorCodes {
	MONTH_RANGE_ERROR(1, "MONTH_RANGE_ERROR");

	private final Integer numCode;
	private final String errorCode;

	private ErrorCodes(int numCode, String errorCode) {
		this.numCode = numCode;
		this.errorCode = errorCode;
	}

	public Integer getNumCode() {
		return numCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
