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

    /**
     * 新增数据
     *
     * @param apiData 实例对象
     * @return 成功失败
     */
    Object insert (ApiData apiData)throws Exception;
    
    /**
     * 批量新增数据
     *
     * @param apiData 实例对象
     * @return 成功失败
     */
    Object insertBatchs (List<ApiData> apiData)throws Exception;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Object deleteById (String id)throws Exception;

    /**
     * 通过主键list删除数据
     *
     * @param idList 主键列表
     * @return 是否成功
     */
    Object delete (List<String> idList)throws Exception;

    /**
     * 修改数据
     *
     * @param apiData 实例对象
     * @return 实例对象
     */
    Object update (ApiData apiData)throws Exception;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Object queryById (String id)throws Exception;

    /**
     * 查询多条数据
     *
     * @param pageNum 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    Object queryAllByPaging (int pageNum, int pageSize)throws Exception;

    Object blob();

    Object mvt(HttpServletRequest request);
}