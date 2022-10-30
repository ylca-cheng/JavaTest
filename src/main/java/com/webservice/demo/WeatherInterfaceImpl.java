package com.webservice.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author niecheng
 * @Description 类描述
 * @date 2021/6/11 14:03
 */
//@WebService(
//        targetNamespace="http://uddi.dareway.com",
//        portName="WeatherSOAPPort",
//        serviceName="SiService",
//        name="WeatherSOAP"
//)
@WebService
public class WeatherInterfaceImpl implements WeatherInterface{
    @Override
    public String queryWeather(String cityName,String proName) {
        System.out.println("获取城市名："+proName+cityName);
        String weather="暴雨";
        return weather;
    }

    @WebMethod(
            operationName="invokeService",
            exclude=false
    )
    @Override
    public String testShkk(String serviceName, String operationName, String xmlpara) {
        return "1";
    }

}
