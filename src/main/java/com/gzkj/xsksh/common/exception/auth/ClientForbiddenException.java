package com.gzkj.xsksh.common.exception.auth;

import com.gzkj.xsksh.common.constants.CommonConstants;
import com.gzkj.xsksh.common.exception.BaseException;

public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
