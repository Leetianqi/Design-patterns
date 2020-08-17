package cn.ltq.designpatterns.observer_pattern.subject;


import cn.ltq.designpatterns.observer_pattern.observer.Observer;

import java.util.ArrayList;


/**
 * @Classname WeatherData
 * @Date 2020/8/17 15:03
 * @Created by litianqi
 * @Description 气象数据注册为主题
 */
public class WeatherData implements Subject {

    //定义一个观察者接口,用来存放注册该主题的观察者
    private ArrayList<Observer> observerList = new ArrayList<>();
    //气温
    private float temp;
    //湿度
    private float humidity;
    //气压
    private float pressure;

    //当数据发生改变时,唤醒观察者
    public void measurementChanged() {
        notifyObservers();
    }

    //当setMeasurements该方法被调用的时候,唤醒所有的观察者
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }


    //重写注册观察者接口
    @Override
    public void registerObserver(Observer o) {
        if (o != null && !observerList.contains(o)) {
            observerList.add(o);
        }
    }

    //重写删除观察者接口
    @Override
    public void removeObserver(Observer o) {
        if (o != null && observerList.contains(o)) {
            observerList.remove(0);
        }
    }

    //重写唤醒所有的观察者接口
    @Override
    public void notifyObservers() {
        for (Observer o :
                observerList) {
            o.update(temp, humidity, pressure);
        }
    }
}
