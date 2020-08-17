package cn.ltq.designpatterns.observer_pattern_built_in;

import cn.hutool.core.util.NumberUtil;

import java.util.Observable;

/**
 * @Classname WeatherData
 * @Date 2020/8/17 20:47
 * @Created by litianqi
 * @Description
 *
 * 观察者集合,注册为观察者,取消观察者,唤醒观察者这个方法都在Observable中实现了,可以进行重写
 */
public class WeatherData extends Observable {

    //气温
    private float temp;
    //湿度
    private float humidity;
    //气压
    private float pressure;

    //维护一个之前的温度,用来判断是否setChanged()
    private float oldTemp;

    //当数据发生改变时,唤醒观察者
    public void measurementChanged() {
        //可以在这个setChanged()时,做条件限制;
        // 举个例子,根据温度变化的差异做限制;如果两次温度相差大于1.0,那么就是推送数据
        if (Math.abs(NumberUtil.sub(temp,oldTemp))>1.0d){
            //因为是继承关系,所以setChanged()是调用父类的方法;
            setChanged();

//            //case 1
//            //注意notifyObservers()和notifyObservers(Object arg)
//            //notifyObservers()表示没有推送数据,需要观察者调用主题的getter方法自己拉取数据
//            notifyObservers();

            //case 2  表示推送数据给观察者
            notifyObservers(new Data(temp,humidity,pressure,oldTemp));
        }
    }

    //当setMeasurements该方法被调用的时候,唤醒所有的观察者
    public void setMeasurements(float temp, float humidity, float pressure) {
        //保存上一次温度
        this.oldTemp = this.temp;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getOldTemp() {
        return oldTemp;
    }

    public void setOldTemp(float oldTemp) {
        this.oldTemp = oldTemp;
    }
}
