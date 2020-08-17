package cn.ltq.designpatterns.strategy_pattern.flybehavior;

/**
 * @author litianqi
 * @date 2020/8/15 22:39
 * description:飞行行为接口
 *
 * 将变化的部分抽离出来,不要和不变的部分混合在一起
 *
 *
 */
public interface FlyBehavior {
    void fly();
}
