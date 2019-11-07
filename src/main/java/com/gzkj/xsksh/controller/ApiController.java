package com.gzkj.xsksh.controller;

import com.gzkj.xsksh.service.ApiDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/10/15 16:00
 * @see com.gzkj.xsksh.controller
 */
@Api(tags = "大屏api接口")
@RequestMapping("/xsksh")
@RestController
public class ApiController {
    @Autowired
    ApiDataService xskshSevice;

    @ApiOperation("测试mvt")
    @GetMapping("/mvt/**")
    public Object mvt(HttpServletRequest request){
        return xskshSevice.mvt(request);
    }

    @ApiOperation("保存blob")
    @GetMapping("/blob")
    public Object blob(){
        return xskshSevice.blob();
    }
}
