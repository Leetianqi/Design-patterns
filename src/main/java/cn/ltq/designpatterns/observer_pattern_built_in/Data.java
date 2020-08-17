package cn.ltq.designpatterns.observer_pattern_built_in;

/**
 * @Classname Data
 * @Date 2020/8/17 21:27
 * @Created by litianqi
 * @Description TODO
 */
public class Data {

    //气温
    private float temp;
    //湿度
    private float humidity;
    //气压
    private float pressure;

    private float oldTemp;

    public Data(float temp, float humidity, float pressure, float oldTemp) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.oldTemp = oldTemp;
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

