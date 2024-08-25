package cn.bugstack.domain.service.tree.node;

import cn.bugstack.domain.service.tree.AbstractStrategyRouter;
import cn.bugstack.domain.service.tree.StrategyHandler;
import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RootNode extends AbstractStrategyRouter {

    private final SwitchRoot switchRoot;

    public RootNode(SwitchRoot switchRoot) {
        this.switchRoot = switchRoot;
    }

    @Override
    public DefaultStrategyFactory.DecisionOutcomeVO apply(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("【入口节点】规则决策树 userId:{}", materialVO.getUserId());
        return router(materialVO, dynamicContext);
    }

    @Override
    public StrategyHandler get(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) {
        return switchRoot;
    }

}
