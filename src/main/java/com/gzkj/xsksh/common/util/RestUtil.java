package com.gzkj.xsksh.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/10/14 9:18
 * @see com.gzkj.xsksh.common.util
 */
@Component
public class RestUtil {
    @Autowired
    RestTemplate restTemplate;

    public Object requestFor(String url,HttpMethod method,JSONObject requestBody,Class<Object> tClass){
        HttpEntity httpEntity = init(method, requestBody);
        ResponseEntity<Object> o = restTemplate.exchange(url, method, httpEntity, Object.class);
        Object body = o.getBody();
        if (tClass == null) {
            return body;
        }
        if (body instanceof List) {
            List<Map<String, Object>> o1 = (List<Map<String, Object>>) body;
            String s = JSON.toJSONString(o1);
            return JSONArray.parseArray(s, tClass);
        } else if (body instanceof Map) {
            Map<String, Object> o1 = (Map<String, Object>) body;
            String s = JSON.toJSONString(o1);
            return JSON.parseObject(s, tClass);
        }
        return JSON.toJSONString(body);
    }

    private HttpEntity init(HttpMethod method, JSONObject body) {
        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.AUTHORIZATION, restDto.getBasic());
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<MultiValueMap<String, String>> httpEntity = null;
        if (method==HttpMethod.GET) {
            httpEntity = new HttpEntity<>(headers);
        } else if (method==HttpMethod.POST) {
            httpEntity = new HttpEntity(body.toJSONString(), headers);
        }
        return httpEntity;
    }
}
