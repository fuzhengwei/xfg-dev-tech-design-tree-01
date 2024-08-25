package cn.bugstack.domain.service.tree.node;

import cn.bugstack.domain.service.tree.AbstractStrategyRouter;
import cn.bugstack.domain.service.tree.StrategyHandler;
import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberLevel2Node extends AbstractStrategyRouter {

    @Override
    public DefaultStrategyFactory.DecisionOutcomeVO apply(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("【级别节点-2】规则决策树 userId:{}", materialVO.getUserId());
        // 可以做一些列动作
        dynamicContext.setLevel(2);
        return router(materialVO, dynamicContext);
    }

    @Override
    public StrategyHandler get(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) {
        return defaultStrategyHandler;
    }

}
