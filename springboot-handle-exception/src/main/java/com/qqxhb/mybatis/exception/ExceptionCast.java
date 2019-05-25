package com.qqxhb.mybatis.exception;

import com.qqxhb.mybatis.model.response.ResultCode;

public class ExceptionCast {

	public static void cast(ResultCode resultCode) {
		throw new CustomException(resultCode);
	}
}
