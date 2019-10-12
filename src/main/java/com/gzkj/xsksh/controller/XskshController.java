package com.gzkj.xsksh.controller;

import com.gzkj.xsksh.service.XskshSevice;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/10/12 16:44
 * @see com.gzkj.xsksh.controller
 */

@Api(tags = "线损可视化相关接口")
@RestController
@RequestMapping("/xsksh")
public class XskshController {

    @Autowired
    XskshSevice xskshSevice;

    @ApiOperation("办公自用电输入比率")
    @GetMapping("/officeSelfElecs")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgId",value = "区域码",defaultValue = "F2CDDDB8654B0068E0430A8A018B0068"),
            @ApiImplicitParam(name = "dateTime",value = "日期",defaultValue = "2019-08")
    })
    public Object officeSelfElecs(@RequestParam("orgId") @NotBlank String orgId,@RequestParam("dateTime") @NotBlank String dateTime){
        return xskshSevice.get(orgId,dateTime);
    }

}