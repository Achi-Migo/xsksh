package com.gzkj.xsksh.common.constants;

import com.gzkj.xsksh.common.util.YmlUtils;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/08/07 15:19
 * @see com.gzkj.xsksh.common.constants
 */

/**
 * @Value("${ssh.userName}") private String userName;
 * @Value("${ssh.userPwd}")
 */
public class BaseConst {
    public static final String EXECUTOR_TOPIC = "test_ogg";
    public static final String CHECK_FILE = "检查文件";
    public static final Long MAX_HDFS_SIZE = 104857600L;
    public static final String APPLICATION_YML = "application.yml";
    public static String SSH_IP = YmlUtils.getYml("ssh.ip");
    public static int SSH_PORT = Integer.parseInt(YmlUtils.getYml("ssh.port"));
    public static String SSH_USER_NAME = YmlUtils.getYml("ssh.userName");
    public static String SSH_USER_PWD = YmlUtils.getYml("ssh.userPwd");
    public static int Centos= Integer.parseInt(YmlUtils.getYml("centos"));
}
