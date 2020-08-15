package cn.ltq.designpatterns.strategy_pattern.subclass;

import cn.ltq.designpatterns.strategy_pattern.flybehavior.FlyNoWay;
import cn.ltq.designpatterns.strategy_pattern.quackbehavior.Quack;
import cn.ltq.designpatterns.strategy_pattern.superclass.Duck;

/**
 * @author litianqi
 * @date 2020/8/15 22:41
 * description:
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        super.setFlyBehavior(new FlyNoWay());
        super.setQuackBehavior(new Quack());
    }

    @Override
    public void dispaly() {
        System.out.println("my body is made of parts");
    }

}
