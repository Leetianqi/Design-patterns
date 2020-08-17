package cn.ltq.designpatterns.observer_pattern_built_in;

import cn.ltq.designpatterns.observer_pattern.display.DisplayElement;
import cn.ltq.designpatterns.observer_pattern.subject.Subject;

import java.util.Observable;
import java.util.Observer;

/**
 * @Classname CurrentConditionsDisplay
 * @Date 2020/8/17 21:04
 * @Created by litianqi
 * @Description TODO
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {

    //为神马你要自己定义一个温度???那是因为你并没有可以继承的类(白说!!!)
    private float temperature;

    private float humidity;
//    //观察者拥有被观察者实例,以便注册,删除使用;
//    private Subject weatherData;

    //现在是Observable
    Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){

//            //case 1 自己从WeatherData中拉取数据
////            WeatherData weatherData  = (WeatherData)o;
//            this.temperature = ((WeatherData) o).getTemp();
//            this.humidity = ((WeatherData) o).getHumidity();

            //case 2
            if (arg!=null&&arg instanceof Data){
                this.temperature = ((Data) arg).getTemp();
                this.humidity = ((Data) arg).getHumidity();
            }
            display();
        }
    }

    //通过getter setter方法获取observable对象
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

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
