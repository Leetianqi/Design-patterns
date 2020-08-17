package cn.ltq.designpatterns.strategy_pattern.flybehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:43
 * description:
 *
 * 一种Fly行为的算法
 *
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("it can't fly");
    }
}
