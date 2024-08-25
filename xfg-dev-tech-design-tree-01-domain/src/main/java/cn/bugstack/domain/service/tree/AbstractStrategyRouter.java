package cn.bugstack.domain.service.tree;

import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractStrategyRouter implements StrategyMapper, StrategyHandler {

    @Getter
    @Setter
    protected StrategyHandler defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 行为路由
     */
    public DefaultStrategyFactory.DecisionOutcomeVO router(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        StrategyHandler strategyHandler = get(materialVO, dynamicContext);
        if (null != strategyHandler) return strategyHandler.apply(materialVO, dynamicContext);
        return defaultStrategyHandler.apply(materialVO, dynamicContext);
    }

}
