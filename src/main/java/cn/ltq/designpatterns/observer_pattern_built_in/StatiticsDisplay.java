package cn.ltq.designpatterns.observer_pattern_built_in;

import cn.ltq.designpatterns.observer_pattern.display.DisplayElement;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname StatiticsDisplay
 * @Date 2020/8/17 21:35
 * @Created by litianqi
 * @Description TODO
 */
public class StatiticsDisplay implements Observer, DisplayElement {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //tempMap用来存放今天的气温数据(如果是昨天的那么就去掉吧),以此来计算出最高,最低,平均温度(平均值再想想怎么做吧)
    private Map<Date, Float> tempMap = new HashMap<>();

    private float maxTemp;
    private float minTemp;
//    private float avgTemp;

    private Observable observable;

    public StatiticsDisplay(Observable obs) {
        this.observable = obs;
        observable.addObserver(this);
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
        System.out.println("static display max temp:" + maxTemp + " min temp: " + minTemp);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (!tempMap.isEmpty() && tempMap.keySet().iterator().next() != null
                && !(sdf.format(new Date()).equals(sdf.format(tempMap.keySet().iterator().next())))) {
            tempMap.clear();
        }
        if (arg != null && arg instanceof Data) {
            float temp = ((Data) arg).getTemp();
            tempMap.put(new Date(), temp);
        }
        calculateTemp();
        display();
    }
}
