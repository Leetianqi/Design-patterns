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
//        super.setFlyBehavior(new FlyNoWay());
//        super.setQuackBehavior(new Quack());

        //需要父类中的flyBehavior和quackBehavior变量是public的
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();

    }

    //重写父类的抽象方法display()
    @Override
    public void dispaly() {
        System.out.println("my body is made of parts");
    }

}
