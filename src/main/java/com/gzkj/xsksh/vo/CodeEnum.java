package com.gzkj.xsksh.vo;

public enum  CodeEnum {
    /**
     * 基础状态码
     */
    DP_SUCCESS(0, "请求成功"),
    DP_ERROR_FAIL(1,"请求失败"),
    DP_SERVER_ERROR(-1,"系统异常"),
    DP_UPLOADFILE_NULL_ERROR(100001,"上传文件,文件不能为空"),
    DP_BASE_PARA_VALUE_NULL(100002,"参数值为空"),
    DP_UNAUTHENTICAED(401,"未登录"),
    DP_DENY_ACCESS(403,"权限不够"),


    /**
     * 任务调度状态码
     */
    DP_DISPATHCH_CREATE_PROJECT_ERROR(100010,"项目创建失败,失败原因:%s"),
    DP_DISPATHCH_UPDATE_PROJECT_ERROR(100010,"项目修改失败,失败原因:%s"),
    DP_DISPATHCH_REMOVE_SCHEDULE_ERROR(100011,"取消调度任务失败"),
    DP_DISPATHCH_OPERATION_FALIED(100012,"操作失败"),
    DP_DISPATHCH_GETFLOW_RUN_RECORD_ERROR(100013,"获取流执行记录失败"),
    DP_DISPATHCH_GETFLOW_DETAILS_ERROE(100014,"获取流执行详情失败");


    private CodeEnum(Object code, String message) {
        this.code = code;
        this.message = message;
    }

    private Object code;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }
}
