package com.gzkj.xsksh.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.sound.midi.Soundbank;
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
    public Object requestFor(String url){
        return requestFor(url,HttpMethod.GET,null,null);
    }

    public Object requestFor(String url,HttpMethod method,JSONObject requestBody,Class<Object> tClass){
        HttpEntity httpEntity = init(method, requestBody);
        ResponseEntity<Object> o = restTemplate.exchange(url, method, httpEntity, Object.class);
        Object body = o.getBody();
        System.out.println(body);
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

    public static void main(String[] args) {
        RestUtil restUtil=new RestUtil();
        Object o = restUtil.requestFor("https://restapi.amap.com/v3/log/init?s=rsv3&product=JsInit&key=5536efb3bbadfd5b439a7f888327b8f6&t=1571110131937&resolution=1366*150&mob=0&vt=1&dpr=1&scale=1&detect=false&callback=jsonp_728043_&platform=JS&logversion=2.0&appname=http%3A%2F%2F192.168.2.36%3A5500%2F&csid=60387D8E-6AC5-44A8-98D1-38E9AC33F79A&sdkversion=1.4.15");
        System.out.println(o);
    }
}
