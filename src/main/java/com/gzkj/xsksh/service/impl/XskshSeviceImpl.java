package com.gzkj.xsksh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gzkj.xsksh.service.XskshSevice;
import com.gzkj.xsksh.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/10/12 16:47
 * @see com.gzkj.xsksh.service.impl
 */
@Service
@Transactional
public class XskshSeviceImpl implements XskshSevice {
    @Override
    public Object get(String orgId, String dateTime) {
        Object data = JSON.parse("{\n" +
                "  \"status\": 1,\n" +
                "  \"data\": [\n" +
                "  \t{\n" +
                "  \t\t\"selfAmount\": 2000,\n" +
                "\t\t\"inputAmount\": 3000,\n" +
                "\t\t\"rate\": 66.666,\n" +
                "\t\t\"dateTime\": \"2019-08\"\n" +
                "  \t}\n" +
                "  ]\n" +
                "}");
        return ResultVo.sucessResultVo(data);
    }
}
