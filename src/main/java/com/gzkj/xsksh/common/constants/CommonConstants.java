package com.gzkj.xsksh.common.constants;

public class CommonConstants {

    public static int PW_ENCORDER_SALT = 12;

    public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    public static final Integer EX_USER_PASS_INVALID_CODE = 40001;

    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40301;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;
    public static final Integer EX_FORM_ERROR_CODE = 422;


    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_ACCOUNT = "currentUserAccount";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";

    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    public static int GetKafkaMessageException=10000;
    public static int MessageFormatException=10001;
    public static int CreatePartitionException=10002;
    public static int CreateCheckFileSizeException=10003;
    public static int AppendToHdfsException=10004;
    public static int NoSuchFileOrDictionaryException=10005;

    /**
     * kafka异常
     */

}
