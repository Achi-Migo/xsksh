package com.gzkj.xsksh.common.exception.auth;


import com.gzkj.xsksh.common.constants.CommonConstants;
import com.gzkj.xsksh.common.exception.BaseException;


public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_PASS_INVALID_CODE);
    }
}
