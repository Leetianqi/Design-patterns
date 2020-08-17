package cn.ltq.designpatterns.strategy_pattern.superclass;

import cn.ltq.designpatterns.strategy_pattern.flybehavior.FlyBehavior;
import cn.ltq.designpatterns.strategy_pattern.quackbehavior.QuackBehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:38
 * description: 抽象类Duck
 * 抽象类有接口和类的特性
 *
 * 此种思想:Has-A而不是is-A,表明有这种能力,具体能力由根据不同的具体个体来展现
 *
 * 就比如Duck类中的display:每一个鸭子都有外观,所以此方法可以由不同的个体去实现
 *
 * 但是swim,并不是所有的鸭子都会游泳的,指不定就有个"旱鸭子"呢
 *
 *
 * 哪些是变的?哪些是不变的?这个是根据需求来判断的!!!
 *
 * 在此需求处fly和quack是常变的需求.在别的需求中可能swim是常变的需求
 *
 */
public abstract class Duck {

    //注:抽象类中的实例属性需要是public才能够被子类所继承使用;
    //如果是protected或者其它,那么子类便不能正常使用此变量
    public FlyBehavior flyBehavior;

    public QuackBehavior quackBehavior;

    //抽象方法:子类需要重写此抽象方法(不然也是抽象类)
    public abstract void dispaly();

    //父类方法:考虑到所有的鸭子都有游泳的特性,游泳的实现由父类来实现;
    //当然了,如果考虑的角度在刁钻一下(比如:旱鸭子),那么游泳也应该设计为一个算法族
    public void swim() {
        System.out.println("All ducks float,even decoys");
    }

    //performQuack:好像是模板方法
    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 此处通过setter getter方法,支持动态切换相关行为
     *
     * @return
     */
    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
