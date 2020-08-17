package cn.ltq.designpatterns.observer_pattern;


import cn.ltq.designpatterns.observer_pattern.observer.CurrentConditionsDisplay;
import cn.ltq.designpatterns.observer_pattern.observer.StatiticsDisplay;
import cn.ltq.designpatterns.observer_pattern.subject.WeatherData;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //建立一个对象,以便观察者发现要注册的主题
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatiticsDisplay statiticsDisplay = new StatiticsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        //当前状态的公告板不需要了,动态删除它
        currentConditionsDisplay.delMyself(weatherData);
        weatherData.setMeasurements(82,70,29.2f);

    }
}
