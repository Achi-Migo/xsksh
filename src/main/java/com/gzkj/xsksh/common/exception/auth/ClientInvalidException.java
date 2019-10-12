package com.gzkj.xsksh.common.exception.auth;


import com.gzkj.xsksh.common.constants.CommonConstants;
import com.gzkj.xsksh.common.exception.BaseException;

public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
