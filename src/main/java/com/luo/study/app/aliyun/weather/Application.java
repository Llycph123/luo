package com.luo.study.app.aliyun.weather;

import com.imooc.weather.HourWeather;
import com.imooc.weather.WeatherUtils;
import com.imooc.weather.impl.WeatherUtilsImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author luolingyan
 * @create 2025-02-19 22:07
 * 查询天气预报
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("查询最近天气预报：");
        System.out.println("输入1：查询未来24小时天气预报");
        System.out.println("输入2：查询未来3天天气预报");
        System.out.println("输入3：查询未来7天天气预报");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("用户输入数字：" +  i);
        switch (i){
            case 1:
                System.out.println("请输入城市名称查询未来24小时天气预报");
                String city = scanner.next();
                WeatherUtils weatherUtils = new WeatherUtilsImpl();
                List<HourWeather> weatherList = weatherUtils.w24h("79da35b1a1b04d20a99cb2b3e3cb086f", city);
                System.out.println(weatherList);
                if(weatherList.size() == 0){
                    System.out.println("抱歉，未收录您查询的城市天气数据。");
                }else{
                    for (HourWeather hourWeather:weatherList){
                        String template = "%s月%s日%s时|%-3s|%20s|%8s|%4sC";
                        String row = String.format(template, new String[]{
                                hourWeather.getMonth(),
                                hourWeather.getDay(),
                                hourWeather.getHour(),
                                hourWeather.getWindDirection(),
                                hourWeather.getWindPower(),
                                hourWeather.getWeather(),
                                hourWeather.getTemperature()
                        });
                        System.out.println(row);
                    }
                }
                break;
            default:
                break;
        }
    }
}
