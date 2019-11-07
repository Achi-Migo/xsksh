package com.gzkj.xsksh.common.util;

import com.fcibook.quick.http.QuickHttp;
import com.fcibook.quick.http.ResponseBody;
import com.gzkj.xsksh.entity.MapData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * <Description>
 *
 * @author CJJ
 * @version 1.0
 * @createDate 2019/10/15 11:58
 * @see com.gzkj.xsksh.common.util
 */
public class DownloadApiData {
    public static void main(String[] args) {
        DownloadApiData downloadApiData=new DownloadApiData();
//        try {
//            downloadApiData.testFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        testGet();
//        testDecode();
//        HashMap<MapData,String> map = (HashMap<MapData, String>) JFileUtils.readObjectFromFile();
//        System.out.println(map);
    }

    private static void testDecode() {
        String s = EncodeUtils.urlDecode("https://restapi.amap.com/v3/config/district?subdistrict=0&extensions=all&level=city&key=5536efb3bbadfd5b439a7f888327b8f6&s=rsv3&output=json&keywords=%E8%8A%9C%E6%B9%96%E5%B8%82&callback=jsonp_890822_&platform=JS&logversion=2.0&appname=http%3A%2F%2F192.168.2.36%3A5500%2F&csid=2DACA26D-D9B6-4AFD-BFB7-8462F93F62DF&sdkversion=1.4.15");
        System.out.println(s);
    }

    private void testFile() throws IOException {

        String path = this.getClass().getResource("/static").getPath();
        List<String> strings = JFileUtils.readLines(new File(path + "/url.txt"), "utf-8");
        strings.forEach(System.out::println);
    }

    private static void testGet() {
        String text = new QuickHttp()
                .url("https://mvt.amap.com/district/CHN3/7/108/51/4096?key=5536efb3bbadfd5b439a7f888327b8f6")
                .get()
                .text();
//                .addParame("c", "iphone")
//                .addHeader("uid","100")
//                .addCookie("sid","100")
//                .text();
        System.out.println(text);

    }

    private static void sava2Db() {

    }
}
