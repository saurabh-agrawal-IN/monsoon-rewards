package com.demo.monsoonrewards.common;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = -4787279967170186515L;
	private ErrorCodes errorCode;
	private String message;
	private String details;
	private String hint;
	private String nextAction;

	protected CustomException() {
	}

	public CustomException(ErrorCodes errorCode, String message, String details, String hint, String nextAction) {
		this.errorCode = errorCode;
		this.message = message;
		this.details = details;
		this.hint = hint;
		this.nextAction = nextAction;
	}
	
	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getNextAction() {
		return nextAction;
	}

	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

	@Override
	public String toString() {
		return "CustomException {errorCode: " + errorCode + ", message: " + message + ", details: " + details + ", hint: " + hint + ", nextAction: "
				+ nextAction + "}";
	}
}
