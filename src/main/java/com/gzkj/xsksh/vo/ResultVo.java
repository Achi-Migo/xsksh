package com.gzkj.xsksh.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Created by admin on 2017/11/9.
 */
@Data
public class  ResultVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Object code = CodeEnum.DP_SUCCESS.getCode();

    /**
     * 提示信息
     */
    private String message;

    /**
     * 业务数据
     */
    private T data;

    /**
     * 额外数据块
     */
    private T chunk;

    public T getChunk() {
        return chunk;
    }

    public void setChunk(T chunk) {
        this.chunk = chunk;
    }

    @Override
    public String toString() {
        JSONObject toJsonString = new JSONObject();
        toJsonString.put("code", code);
        toJsonString.put("message", message);
        toJsonString.put("data", data);
        return toJsonString.toString();
    }

    public void setErrorMsg(CodeEnum errorCode, String errorMsg) {
        this.code = errorCode.getCode();
        this.message = errorMsg;
    }

    public static ResultVo errorResultVo(String msg) {
        ResultVo ResultVo = new ResultVo();
        ResultVo.setErrorMsg(CodeEnum.DP_ERROR_FAIL, msg);
        return ResultVo;
    }

    public static ResultVo errorResultVo(CodeEnum errorCode) {
        ResultVo ResultVo = new ResultVo();
        ResultVo.setErrorMsg(errorCode, errorCode.getMessage());
        return ResultVo;
    }

    public static ResultVo errorResultVo(CodeEnum errorCode, String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setErrorMsg(errorCode, message);
        return resultVo;
    }

    public void setCodeEnum(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public void setCodeEnum(CodeEnum codeEnum, String message) {
        this.code = codeEnum.getCode();
        this.message = message;
    }

    public void setCodeEnum(String message) {
        this.code = CodeEnum.DP_SUCCESS.getCode();
        this.message = message;
    }

    public void setSuccessMessage(String message) {
        this.code = CodeEnum.DP_SUCCESS.getCode();
        this.message = message;
    }

    public static ResultVo successMessage(String message) {
        ResultVo ResultVo = new ResultVo();
        ResultVo.code = CodeEnum.DP_SUCCESS.getCode();
        ResultVo.message = message;
        return ResultVo;
    }


    /**
     * @param object
     * @return
     * @description 默认成功返回s
     * @author yongzhang14@iflytek.com
     * @date 2017/12/11 18:41
     */
    public static ResultVo sucessResultVo(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CodeEnum.DP_SUCCESS.getCode());
        resultVo.setMessage(CodeEnum.DP_SUCCESS.getMessage());
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo sucessResultVo(String message, String... args) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CodeEnum.DP_SUCCESS.getCode());
        resultVo.setMessage(CodeEnum.DP_SUCCESS.getMessage());
        String format = MessageFormat.format(message, args);
        resultVo.setData(format);
        return resultVo;
    }

    public static ResultVo sucess() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(CodeEnum.DP_SUCCESS.getCode());
        resultVo.setMessage(CodeEnum.DP_SUCCESS.getMessage());
        return resultVo;
    }
}
