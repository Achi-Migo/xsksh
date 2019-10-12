package com.gzkj.xsksh.controller;//package com.gzkj.kafka.controller;
//
//import com.gzkj.kafka.entity.KafkaConsumerTask;
//import com.gzkj.kafka.vo.KafkaMessage;
//import com.gzkj.kafka.common.exception.kafka.MessageFormatException;
//import com.gzkj.kafka.service.consumer.ConsumerSpringboot;
//import com.gzkj.kafka.dao.ConsumerDao;
//import com.gzkj.kafka.service.ConsumerService;
//import com.gzkj.kafka.vo.ResultVo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * <Description>
// *
// * @author CJJ
// * @version 1.0
// * @createDate 2019/08/07 15:26
// * @see com.gzkj.kafka.controller
// */
//@RestController
//@RequestMapping("/consumer")
//public class ConsumerController{
//
//
//    Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    ConsumerSpringboot consumer;
//    @Autowired
//    ConsumerService consumerService;
//    @Autowired
//    ConsumerDao kafkaConsumerDao;
//
//    @PutMapping("")
//    public ResultVo create(String bootstrapServers, String groupId, String topic) throws Exception {
//        return consumerService.create(bootstrapServers,groupId,topic);
//    }
//
//    @GetMapping("/send")
//    public ResultVo listen() {
//        return ResultVo.sucess();
//    }
//
//    @GetMapping("/test")
//    public ResultVo test() throws MessageFormatException {
//        KafkaMessage message = new KafkaMessage("{\"table\":\"test3.reimburse_xy\",\"op_type\":\"I\",\"op_ts\":\"2019-07-30 10:46:15.429773\",\"current_ts\":\"2019-07-30T11:05:59.592000\",\"pos\":\"00000000000000001101\",\"after\":{\"ID\":1,\"NAME\":\"test\"}}");
//        return ResultVo.sucessResultVo(message);
//    }
//
//    @GetMapping("/start")
//    public ResultVo start(String topic) {
//        return consumerService.multiplyRun(topic);
//    }
//
//    @GetMapping("/getMaxOffset")
//    public ResultVo getMaxOffset(String topic) {
//        return consumerService.getMaxOffset(topic);
//    }
//
//    @GetMapping("/shutdown")
//    public ResultVo shutdown(String topic) {
//        return consumerService.shutdown(topic);
//    }
//
//    @GetMapping("/start")
//    public ResultVo start(KafkaConsumerTask task) {
//        return consumerService.multiplyRun(task);
//    }
//
//    @GetMapping("/pause")
//    public ResultVo pause() {
//        return ResultVo.sucessResultVo("pause success");
//    }
//
//    @GetMapping("/dao")
//    public ResultVo dao() {
//        KafkaMessage message = new KafkaMessage("test_ogg", "test_ogg");
//        String location = kafkaConsumerDao.selectLocation(message);
//        logger.info(location);
//        return ResultVo.sucessResultVo("dao success");
//    }
//
//    @GetMapping("getAllConsumer")
//    public ResultVo getAllConsumer() {
//        return consumerService.getAllConsumer();
//    }
//
//    @GetMapping("/anti")
//    public ResultVo anti(HttpServletRequest request, HttpServletResponse response) {
//        String strClientIp = request.getHeader("x-forwarded-for");
//        if (strClientIp == null || strClientIp.length() == 0 || "unknown".equalsIgnoreCase(strClientIp)) {
//            strClientIp = request.getRemoteAddr();
//        }
//        logger.info(strClientIp);
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        logger.info(ip);
//
//        return ResultVo.sucessResultVo(strClientIp);
//
//
//    }
//
//}
