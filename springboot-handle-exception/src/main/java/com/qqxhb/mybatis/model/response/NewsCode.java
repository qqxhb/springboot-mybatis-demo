package com.qqxhb.mybatis.model.response;

import lombok.ToString;

@ToString
public enum NewsCode implements ResultCode {
	REQUIRED_PARAMISNULL(false, 3000, "必填参数为空！");
	// 操作代码
	boolean success;
	// 操作代码
	int code;
	// 提示信息
	String message;

	private NewsCode(boolean success, int code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

	@Override
	public boolean success() {
		return success;
	}

	@Override
	public int code() {
		return code;
	}

	@Override
	public String message() {
		return message;
	}
}
