package cn.ltq.designpatterns.observer_pattern.observer;

import cn.ltq.designpatterns.observer_pattern.display.DisplayElement;
import cn.ltq.designpatterns.observer_pattern.subject.Subject;
import cn.ltq.designpatterns.observer_pattern.subject.WeatherData;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname StatiticsDisplay
 * @Date 2020/8/17 15:53
 * @Created by litianqi
 * @Description 天气统计板, 用来展示最高, 最低, 平均温度(TODO)
 */
public class StatiticsDisplay implements Observer, DisplayElement {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //tempMap用来存放今天的气温数据(如果是昨天的那么就去掉吧),以此来计算出最高,最低,平均温度(平均值再想想怎么做吧)
    private Map<Date, Float> tempMap = new HashMap<>();

    private float maxTemp;
    private float minTemp;
//    private float avgTemp;

    private WeatherData weatherData;

    public StatiticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    //不在观察weatherData主题
    public void delMyself(Subject weatherData) {
        weatherData.removeObserver(this);
    }


    //计算最高,最低,平均温度
    //注:map.values()的用法--容易有个误区:向下转型的时候出现了类型转换错误
    //参考:https://www.cnblogs.com/chengpeng15/p/5804376.html
    public void calculateTemp() {
        List<Float> list = new ArrayList<>(tempMap.values());
        this.maxTemp = Collections.max(list);
        this.minTemp = Collections.min(list);
    }


    @Override
    public void display() {
        System.out.println("static display max temp:" + maxTemp + "min temp: " + minTemp);
    }

    //判断Map中是否有元素,不能通过map!=null来判断;要用tempMap.isEmpty()
    //这个地方的设计,最好加上日期
    @Override
    public void update(float temp, float humidity, float pressure) {
        if (!tempMap.isEmpty() && tempMap.keySet().iterator().next() != null
                && !(sdf.format(new Date()).equals(sdf.format(tempMap.keySet().iterator().next())))) {
            tempMap.clear();
        }
        tempMap.put(new Date(), temp);
        //更新之后先计算最大温度和最小温度
        calculateTemp();
        //调用展示板
        display();
    }


}
