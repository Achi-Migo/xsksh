package com.gzkj.xsksh.vo;

import lombok.Data;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/08/18 9:53
 * @see com.gzkj.xsksh.vo
 */
@Data
public class PagingVo {
    private int pageNum;
    private int pageSize;

    private String keyWord;
    private String startTime;
    private String endTime;
    private String orderBy;
    private String groupBy;
    private String sort;
}
