package com.gzkj.xsksh.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/08/08 11:15
 * @see com.gzkj.xsksh.service.consumer
 */
public class ResponseMessage {
    static Logger logger = LoggerFactory.getLogger(ResponseMessage.class);
    public ResponseMessage() {
    }

    public static void isSuccess() {
        logger.info("操作成功!");
    }

    public static void isSuccess(boolean b) {
        isSuccess(b,"");
    }
    public static void isSuccess(boolean b, String msg) {
        if (b) {
            logger.info(msg+"操作成功!");
        }else {
            logger.info(msg+"操作失败!");
        }
    }
    public static void isSuccess(String msg) {
            logger.info(msg);
    }

}
