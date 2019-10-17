package com.gzkj.xsksh.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

/**
 * (ApiData)实体类
 *
 * @author cjj
 * @since 2019-10-15 14:05:17
 */
@NoArgsConstructor
@ApiModel("")
public class ApiData implements Serializable {
    private static final long serialVersionUID = 851608928892399999L;
        
    @ApiModelProperty(hidden=true, value="")
    private String id;
    
        
    @ApiModelProperty(hidden=true, value="")
    private String url;
    
        
    @ApiModelProperty(hidden=true, value="")
    private byte[] data;
    
        
    @ApiModelProperty(hidden=true, value="")
    private String path;
    
        
    @ApiModelProperty(hidden=true, value="")
    private Boolean isDeleted;
    
        
    @ApiModelProperty(hidden=true, value="")
    private Date createTime;
    
        
    @ApiModelProperty(hidden=true, value="")
    private Date updateTime;

    public ApiData(String randomUUID, String s, byte[] bytes) {
        this.id=randomUUID;
        this.url=s;
        this.data=bytes;
        this.createTime=new Date();
        this.updateTime=new Date();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}