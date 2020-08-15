package cn.ltq.designpatterns.strategy_pattern.quackbehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:46
 * description:
 */
public class Squack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
