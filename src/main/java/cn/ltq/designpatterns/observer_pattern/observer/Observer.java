package cn.ltq.designpatterns.observer_pattern.observer;

/**
 * @Classname Observer
 * @Date 2020/8/17 15:06
 * @Created by litianqi
 * @Description 观察者接口
 */
public interface Observer {
    //观察者有个update方法
    void update(float temp, float humidity, float pressure);
}
