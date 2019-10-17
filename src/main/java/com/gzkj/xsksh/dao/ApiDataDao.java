package com.gzkj.xsksh.dao;

import com.gzkj.xsksh.entity.ApiData;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ApiData)表数据库访问层
 *
 * @author cjj
 * @since 2019-10-15 14:05:18
 */
public interface ApiDataDao {

    /**
     * 新增数据
     *
     * @param apiData 实例对象
     * @return 影响行数
     */
    int insert(ApiData apiData);
    
    /**
     * 批量新增数据
     *
     * @param apiData 实例对象
     * @return 影响行数
     */
    int insertBatchs(List<ApiData> apiData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 通过主键List删除数据
     *
     * @param idList 主键列表
     * @return 影响行数
     */
    int delete(List<String> idList);

    /**
     * 修改数据
     *
     * @param apiData 实例对象
     * @return 影响行数
     */
    int update(ApiData apiData);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ApiData queryById(String id);

    /**
     * 查询指定行数据
     * @return 对象列表
     */
    List<ApiData> queryAll();

    int queryByUrl(String s);

    ApiData queryLikeUrl(String s);
}