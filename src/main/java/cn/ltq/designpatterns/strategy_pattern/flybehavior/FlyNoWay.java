package cn.ltq.designpatterns.strategy_pattern.flybehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:43
 * description:
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("it can't fly");
    }
}
