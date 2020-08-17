package cn.ltq.designpatterns.strategy_pattern.flybehavior;

/**
 *
 * 新增一个通过火箭推进器来飞行的一种飞行行为
 */
public class FlyWithRocketPower implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i fly with RocketPower");
    }
}
