package com.gzkj.xsksh.common.util;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户获取配置文件中属性值 不依赖于spring
 *
 * @author cjj
 * @date 2019/8/4
 */
public class YmlUtils {
    private static String yml;

    //静态代码块,自动获取用户配置的配置文件
    static {
        yml = Optional.ofNullable(getYml("spring.profiles.active", "application.yml")).map(s -> "-" + s).orElse("");
    }


    /**
     * 根据传入的yml获取yml中key的属性值
     *
     * @param key
     * @param yml
     * @return
     */
    public static String getYml(String key, String yml) {
        Resource resource = new ClassPathResource(yml);
        Properties properties;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
        } catch (Exception e) {
            System.out.println(yml + " not found!");
            return null;
        }
        return properties.getProperty(key, null);
    }

    /**
     * 自动根据 application中激活的配置文件,选择对应的yml读取属性
     *
     * @param key
     * @return
     */
    public static String getYml(String key) {
        String value = getYml(key, "application.yml");
        if (value != null) {
            return value;
        }
        if (!yml.contains("application")) {
            yml = "application" + yml + ".yml";
        }
        return getYml(key, yml);
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Integer i=null;
        Optional<Integer> i1 = Optional.ofNullable(i);
        Integer maxId = i1.orElse(1);
        System.out.println(maxId);
    }

}


