package com.gzkj.xsksh.common.constants;

public interface SysContants {

    String CLIENT_ID = "gzkj";

    /**azkaban成功状态**/
    String AZK_SUCCESS = "success";

    //调度服务缓存key前缀
    String DISPATCH = "sp_";

    String NAME = "数据分析";
    String VERSION = "1.0";
    String DESCRIPTION = "数据分析平台";

    String FILE_TMP = "/gzkj/tmp/";

    String sh = "hive -f ./htve/";

    String FLOW_BASE_ROOT = "nodes:\r";
    String FLOW_NAME = "  - name: %s\r";
    String FLOW_TYPE = "    type: %s\r";

    String FLOW_DEPEND_ON = "    dependsOn:\r";
    String FLOW_DEPEND_ON_CENTENT = "      - %s\r";
    String FLOW_CONFIG = "    config:\r";
    String FLOW_CONFIG_COMMAND = "      command%s: %s\r";

    final String FLOW_PROJECT_FILE_NAME = "flow20.project";

    /**
     * code
     */
    byte VALIDATE_CODE_TYPE_LOGIN = 1;
    byte VALIDATE_CODE_TYPE_REGISTER = 2;

    String REDIS_VALIDATE_CODE_PREFIX = "code:";             //存放到redis中code的前缀
    Long REDIS_VALIDATE_CODE_EXPIRE = 360L;                       //验证码超时时间，单位秒

    /**
     * device 设备类型
     */
    byte DEVICE_TYPE_BROWER = 1;
    byte DEVICE_TYPE_APP = 2;

    /**
     * response code响应码
     */
    int RESPONSE_CODE_OK = 0;
    int RESPONSE_CODE_ERR = 1;

    /**
     *  删除字段
     */
    byte DELETE_YES = 1;
    byte DELETE_NO = 0;

    /**
     * 响应消息提示信息
     */
    String MSG_SUCCESS = "成功";
    String MSG_FAIL = "失败";

}