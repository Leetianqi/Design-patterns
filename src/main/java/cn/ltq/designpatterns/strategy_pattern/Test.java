package cn.ltq.designpatterns.strategy_pattern;

import cn.ltq.designpatterns.strategy_pattern.flybehavior.FlyWithRocketPower;
import cn.ltq.designpatterns.strategy_pattern.flybehavior.FlyWithWings;
import cn.ltq.designpatterns.strategy_pattern.quackbehavior.Squack;
import cn.ltq.designpatterns.strategy_pattern.subclass.ModelDuck;
import cn.ltq.designpatterns.strategy_pattern.superclass.Duck;
import javafx.scene.input.MouseDragEvent;

/**
 * @author litianqi
 * @date 2020/8/15 22:37
 * description:
 */
public class Test {
    public static void main(String[] args) {
        Duck modelDuck = new ModelDuck();
        //ModelDuck的构造方法中已经给FlyBehavior,QuackBehavior设置了值,所以可以正常使用
        modelDuck.performQuack();
        modelDuck.performFly();
        //通过setter方法,来动态的改变模式;子类中没有setter方法,集成了父类中的方法
        modelDuck.setFlyBehavior(new FlyWithWings());
        modelDuck.setQuackBehavior(new Squack());
        modelDuck.performFly();
        modelDuck.performQuack();

        //我是个模型鸭啊,我怎么能很普通的飞呢?我要用火箭推进器来飞;但我还是要吱吱叫
        modelDuck.setFlyBehavior(new FlyWithRocketPower());
        modelDuck.performFly();
        modelDuck.performQuack();
    }
}
