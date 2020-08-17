package cn.ltq.designpatterns.observer_pattern.subject;

import cn.ltq.designpatterns.observer_pattern.observer.Observer;

/**
 * @Classname Subject
 * @Date 2020/8/17 14:58
 * @Created by litianqi
 * @Description 定义一个主题接口, 所有观察者模式中的主题都要实现此接口
 * <p>
 * 注:java自带了Observable抽象类,实现了此功能
 */
public interface Subject {
    //注册为观察者
    void registerObserver(Observer o);

    //删除观察者
    void removeObserver(Observer o);

    //唤醒所有的观察者
    void notifyObservers();
}
