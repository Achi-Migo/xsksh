package com.gzkj.xsksh.service.impl;

import com.fcibook.quick.http.QuickHttp;
import com.gzkj.xsksh.common.util.EncodeUtils;
import com.gzkj.xsksh.common.util.JFileUtils;
import com.gzkj.xsksh.entity.ApiData;
import com.gzkj.xsksh.dao.ApiDataDao;
import com.gzkj.xsksh.service.ApiDataService;
import com.gzkj.xsksh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

/**
 * (ApiData)表服务实现类
 *
 * @author cjj
 * @since 2019-10-15 14:05:18
 */
@Transactional
@Service
public class ApiDataServiceImpl implements ApiDataService {
    @Resource
    private ApiDataDao apiDataDao;
    //        String[] removeKeys= new String[]{"t","resolution","detect","appname"};
    String[] removeKeys = new String[]{};

    @Override
    public Object blob() {
        int insert = 0;
        byte[] bytes = new byte[1024];
        String path = this.getClass().getResource("/static").getPath();
        List<String> strings = null;
        try {
            strings = JFileUtils.readLines(new File(path + "/url.txt"), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : strings) {
            try {
//                Thread.sleep(1000);
                s = EncodeUtils.urlDecode(s);
                System.out.println(s);
                bytes = new QuickHttp()
                        .url(s)
                        .get()
                        .bytes();
            } catch (Exception e) {
                e.printStackTrace();
                bytes = null;
            }

            for (String removeKey : removeKeys) {
                s = s.replaceAll("&" + removeKey + "=.*&", "&");
            }
            System.out.println(s);
            ApiData apiData = new ApiData(UUID.randomUUID().toString(), s, bytes);
            int i = apiDataDao.queryByUrl(s);
            if (i == 0) {
                insert += apiDataDao.insert(apiData);
            }
        }
        return insert;
    }

    @Override
    public Object mvt(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        Map<String, String[]> parameterMap = request.getParameterMap();
        final String[] param = {""};
        List<String> except = Arrays.asList(removeKeys);
        parameterMap.forEach((k, v) -> {
            if (!except.contains(k)) {
                param[0] += k + "=" + v[0] + "&";
            }
        });
        String substring = "";
        if (param[0].length() > 0) {
            substring = "?" + param[0].substring(0, param[0].length() - 1);
        }
        String requestURI = request.getRequestURI();
        param[0] = requestURI.replaceAll("/xsksh/mvt", "") + substring;
        param[0] = EncodeUtils.urlDecode(param[0]);
        System.out.println(param[0]);
        ApiData apiData = apiDataDao.queryLikeUrl(param[0]);
        return apiData != null ? apiData.getData() : "";
    }

    /**
     * 新增数据
     *
     * @param apiData 实例对象
     * @return 实例对象
     */
    @Override
    public Object insert(ApiData apiData) throws Exception {
        apiData.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        apiData.setIsDeleted(false);
        Date now = new Date();
        apiData.setCreateTime(now);
        apiData.setUpdateTime(now);
        if (apiDataDao.insert(apiData) > 0) {
            return ResultVo.sucessResultVo("添加成功");
        }
        return ResultVo.errorResultVo("添加失败");
    }

    @Override
    public Object insertBatchs(List<ApiData> apiData) throws Exception {
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Object deleteById(String id) throws Exception {
        if (apiDataDao.deleteById(id) > 0) {
            return ResultVo.sucessResultVo("删除成功");
        }
        return ResultVo.errorResultVo("删除失败");
    }

    /**
     * 通过主键List删除数据
     *
     * @param idList 主键列表
     * @return 是否成功
     */
    @Override
    public Object delete(List<String> idList) throws Exception {
        if (idList.size() > 0 && apiDataDao.delete(idList) > 0) {
            return ResultVo.sucessResultVo("删除成功");
        }
        return ResultVo.errorResultVo("删除失败");
    }


    /**
     * 修改数据
     *
     * @param apiData 实例对象
     * @return 实例对象
     */
    @Override
    public Object update(ApiData apiData) throws Exception {
        if (apiDataDao.update(apiData) > 0) {
            return ResultVo.sucessResultVo("修改成功");
        }
        return ResultVo.errorResultVo("未修改");
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Object queryById(String id) throws Exception {
        ApiData apiData = apiDataDao.queryById(id);
        if (apiData != null) {
            return ResultVo.sucessResultVo(apiData);
        } else {
            return ResultVo.sucessResultVo("ID为{}的数据不存在", id);
        }
    }

    /**
     * 查询多条数据
     *
     * @param pageNum  查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public Object queryAllByPaging(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<ApiData> apiDataList = apiDataDao.queryAll();
        PageInfo<ApiData> pageInfo = new PageInfo<>(apiDataList);
        return ResultVo.sucessResultVo(pageInfo);
    }

}