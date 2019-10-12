//package com.gzkj.xsksh.controller;
//
//import com.gzkj.xsksh.entity.KafkaConsumerException;
//import com.gzkj.xsksh.service.KafkaConsumerExceptionService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * (KafkaConsumerException)表控制层
// *
// * @author makejava
// * @since 2019-08-15 15:23:13
// */
//@RestController
//@RequestMapping("kafkaConsumerException")
//public class KafkaConsumerExceptionController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private KafkaConsumerExceptionService kafkaConsumerExceptionService;
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public KafkaConsumerException selectOne(String id) {
//        return this.kafkaConsumerExceptionService.queryById(id);
//    }
//
//}