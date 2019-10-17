package com.gzkj.xsksh.service.impl;

import com.alibaba.fastjson.JSON;
import com.fcibook.quick.http.QuickHttp;
import com.gzkj.xsksh.common.util.EncodeUtils;
import com.gzkj.xsksh.common.util.JFileUtils;
import com.gzkj.xsksh.dao.ApiDataDao;
import com.gzkj.xsksh.entity.ApiData;
import com.gzkj.xsksh.service.XskshSevice;
import com.gzkj.xsksh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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
