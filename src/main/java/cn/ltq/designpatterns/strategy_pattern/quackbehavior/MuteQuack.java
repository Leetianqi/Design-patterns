package cn.ltq.designpatterns.strategy_pattern.quackbehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:45
 * description:
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
