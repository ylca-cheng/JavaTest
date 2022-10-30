package com.webservice.demo;

/**
 * @author niecheng
 * @Description 类描述
 * @date 2021/6/11 14:03
 */
public interface WeatherInterface {
    public String queryWeather(String cityName,String proName);

    public String testShkk(String serviceName,String operationName, String xmlpara);
}
