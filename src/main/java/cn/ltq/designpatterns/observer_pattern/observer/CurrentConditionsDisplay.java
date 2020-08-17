package cn.ltq.designpatterns.observer_pattern.observer;

import cn.ltq.designpatterns.observer_pattern.display.DisplayElement;
import cn.ltq.designpatterns.observer_pattern.subject.Subject;

/**
 * @Classname CurrentConditionsDisplay
 * @Date 2020/8/17 15:36
 * @Created by litianqi
 * @Description 当前的展示板:它是气象数据的观察者,同时在获取到气象数据的时候需要展示公告板;
 * 当前展示板只关系温度和湿度,所有只有temperature,humidity两个参数
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    //为神马你要自己定义一个温度???那是因为你并没有可以继承的类(白说!!!)
    private float temperature;

    private float humidity;
    //观察者拥有被观察者实例,以便注册,删除使用;
    private Subject weatherData;

    //通过构造方法来注册主题,也可以通过setter发放动态设置主题(开放setter接口)
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    //不在观察weatherData主题
    public void delMyself(Subject weatherData) {
        weatherData.removeObserver(this);
    }

    //当update方法被调用时,调用display方法来展示数据
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public Subject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Subject weatherData) {
        this.weatherData = weatherData;
    }
}
