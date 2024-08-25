package cn.bugstack.domain.service.tree;

import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;

public interface StrategyHandler {

    /**
     * 处理最终返回结果
     */
    StrategyHandler DEFAULT = (materialVO, dynamicContext) -> {
        DefaultStrategyFactory.DecisionOutcomeVO decisionOutcomeVO = new DefaultStrategyFactory.DecisionOutcomeVO();
        decisionOutcomeVO.setLevel(dynamicContext.getLevel());
        return decisionOutcomeVO;
    };

    /**
     * 受理策略处理
     */
    DefaultStrategyFactory.DecisionOutcomeVO apply(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception;

}
