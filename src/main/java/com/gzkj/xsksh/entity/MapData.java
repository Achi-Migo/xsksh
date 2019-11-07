package com.gzkj.xsksh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/11/04 13:21
 * @see com.gzkj.xsksh.entity
 */
@Data
@NoArgsConstructor
public class MapData implements Serializable {

    private String urlPath;
    private String keywords = "";
    private String type = "";
    private String t="";

    public MapData(String urlPath, String keywords, String type,String t) {
        this.urlPath = urlPath;
        this.keywords = keywords;
        this.type = type;
        this.t=t;
    }

    public String toString() {
        return Optional.ofNullable(urlPath).orElse("") + Optional.ofNullable(keywords).orElse("") + Optional.ofNullable(type).orElse("")+Optional.ofNullable(t).orElse("");
    }

    public boolean equals(MapData mapData) {

        if (this != null && mapData != null) {
            if (this.toString().equals(mapData.toString())) {
                return true;
            }
        }
        return false;
    }

}
