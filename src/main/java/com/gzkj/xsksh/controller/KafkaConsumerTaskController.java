//package com.gzkj.xsksh.controller;
//
//import com.gzkj.xsksh.entity.KafkaConsumerTask;
//import com.gzkj.xsksh.service.ConsumerService;
//import com.gzkj.xsksh.service.KafkaConsumerTaskService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//
//import javax.annotation.Resource;
//import javax.validation.constraints.NotBlank;
//
///**
// * kafka消费任务(KafkaConsumerTask)表控制层
// *
// * @author cjj
// * @since 2019-08-19 09:30:55
// */
//@Api(tags = "kafka消费任务")
//@RestController
//@RequestMapping("kafkaConsumerTask")
//public class KafkaConsumerTaskController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private KafkaConsumerTaskService kafkaConsumerTaskService;
//    @Autowired
//    private ConsumerService consumerService;
//
//    @ApiOperation("新增")
//    @PostMapping("")
//    public Object insert(@RequestBody KafkaConsumerTask kafkaConsumerTask) throws Exception {
//        return kafkaConsumerTaskService.insert(kafkaConsumerTask);
//    }
//
//
//    @ApiIgnore
//    @ApiOperation("根据id删除(物理)")
//    @ApiImplicitParam(name = "id", value = "唯一标识")
//    @DeleteMapping("{id}")
//    public Object deleteById(@PathVariable("id") @NotBlank String id) throws Exception {
//        return kafkaConsumerTaskService.deleteById(id);
//    }
//
//
//    @ApiOperation("根据id集合删除")
//    @ApiImplicitParam(name = "ids", value = "唯一标识 集合")
//    @DeleteMapping("")
//    public Object delete(String ids) throws Exception {
//        return kafkaConsumerTaskService.delete(ids);
//    }
//
//    @ApiIgnore
//    @ApiOperation("修改")
//    @PutMapping("")
//    public Object update(KafkaConsumerTask kafkaConsumerTask) throws Exception {
//        return kafkaConsumerTaskService.update(kafkaConsumerTask);
//    }
//
//    @ApiOperation("查询抽取的表信息")
//    @ApiImplicitParam(name = "taskId", value = "任务id")
//    @GetMapping("info/{taskId}")
//    public Object info(@PathVariable(value = "taskId", required = true) String taskId) {
//        return kafkaConsumerTaskService.queryInfoById(taskId);
//    }
//
//
//    @ApiOperation("分页查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNum", value = "页码"),
//            @ApiImplicitParam(name = "pageSize", value = "分页大小")
//    })
//    @GetMapping("all")
//    public Object all(@RequestParam @NotBlank int pageNum, @RequestParam @NotBlank int pageSize) throws Exception {
//        return kafkaConsumerTaskService.queryAllByPaging(pageNum, pageSize);
//    }
//
//    @ApiOperation("启动")
//    @ApiImplicitParam(name = "id", value = "任务 id")
//    @PutMapping("startup/{id}")
//    public Object start(@PathVariable("id") @NotBlank String id) {
//        return consumerService.startup(id);
//    }
//
//
//    @ApiOperation("状态查询")
//    @ApiImplicitParam(name = "id", value = "任务 id")
//    @GetMapping("status/{id}")
//    public Object status(@PathVariable("id") @NotBlank String id) {
//        return consumerService.status(id);
//    }
//
//    @ApiOperation("关闭")
//    @PutMapping("shutdown/{id}")
//    @ApiImplicitParam(name = "id", value = "任务 id")
//    public Object shutdown(@PathVariable("id") @NotBlank String id) {
//        return consumerService.shutdown(id);
//    }
//
//
//}