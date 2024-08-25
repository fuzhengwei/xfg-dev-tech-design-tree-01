package cn.bugstack.domain.service.tree;

import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;

public interface StrategyMapper {

    /**
     * 获取策略处理器
     */
    StrategyHandler get(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext);

}
