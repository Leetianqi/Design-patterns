package cn.ltq.designpatterns.strategy_pattern;

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
        modelDuck.performQuack();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyWithWings());
        modelDuck.setQuackBehavior(new Squack());
        modelDuck.performFly();
        modelDuck.performQuack();
    }
}
