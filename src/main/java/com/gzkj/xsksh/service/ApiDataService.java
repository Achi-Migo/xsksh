package com.gzkj.xsksh.service;

import com.gzkj.xsksh.entity.ApiData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (ApiData)表服务接口
 *
 * @author cjj
 * @since 2019-10-15 14:05:17
 */
public interface ApiDataService {


    Object blob();

    Object mvt(HttpServletRequest request);
}