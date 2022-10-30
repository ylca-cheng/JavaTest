package com.spring;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;


/**
 * @author
 * @Description 类描述
 * @date 2021/3/25 14:04
 */
public class ResourceTest {

    @Test
    public void test1() throws IOException {
        Resource resource = new ClassPathResource("config.properties");
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        System.out.println(properties.getProperty("user.name"));
    }

}
