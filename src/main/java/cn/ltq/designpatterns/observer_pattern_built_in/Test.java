package cn.ltq.designpatterns.observer_pattern_built_in;

/**
 * @Classname Test
 * @Date 2020/8/17 21:09
 * @Created by litianqi
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {

        //建立一个对象,以便观察者发现要注册的主题
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatiticsDisplay statiticsDisplay = new StatiticsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(83, 70, 29.2f);
    }
}
