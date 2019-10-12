package com.gzkj.xsksh.common.handler;

import com.gzkj.xsksh.common.constants.CommonConstants;
import com.gzkj.xsksh.common.exception.BaseException;
import com.gzkj.xsksh.common.exception.auth.ClientTokenException;
import com.gzkj.xsksh.common.exception.auth.UserInvalidException;
import com.gzkj.xsksh.common.msg.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice("com.gzkj")
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    public BaseResponse validateErrorHandler(HttpServletResponse response, BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors() && bindingResult.getFieldError() != null) {
            return new BaseResponse(CommonConstants.EX_FORM_ERROR_CODE, bindingResult.getFieldError().getDefaultMessage());
        } else {
            return new BaseResponse(CommonConstants.EX_FORM_ERROR_CODE, "Form validation error");
        }
    }

    @ExceptionHandler(ClientTokenException.class)
    public BaseResponse clientTokenExceptionHandler(HttpServletResponse response, ClientTokenException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }


    @ExceptionHandler(UserInvalidException.class)
    public BaseResponse userInvalidExceptionHandler(HttpServletResponse response, UserInvalidException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(CommonConstants.EX_OTHER_CODE, ex.getMessage());
    }

}
