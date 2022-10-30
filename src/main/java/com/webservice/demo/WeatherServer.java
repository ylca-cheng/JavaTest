package com.webservice.demo;

import javax.xml.ws.Endpoint;

/**
 * @author niecheng
 * @Description 类描述
 * @date 2021/6/11 14:04
 */
public class WeatherServer {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:12345/weather", new WeatherInterfaceImpl());
    }
}
