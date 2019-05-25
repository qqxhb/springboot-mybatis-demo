package com.qqxhb.mybatis.exception;

import com.qqxhb.mybatis.model.response.ResultCode;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 错误代码
	ResultCode resultCode;

	public CustomException(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

}
