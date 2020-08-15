package cn.ltq.designpatterns.strategy_pattern.superclass;

import cn.ltq.designpatterns.strategy_pattern.flybehavior.FlyBehavior;
import cn.ltq.designpatterns.strategy_pattern.quackbehavior.QuackBehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:38
 * description:
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public abstract void dispaly();

    public  void swim(){
        System.out.println("All ducks float,even decoys");
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    /**
     *此处通过setter getter方法,支持动态切换相关行为
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
