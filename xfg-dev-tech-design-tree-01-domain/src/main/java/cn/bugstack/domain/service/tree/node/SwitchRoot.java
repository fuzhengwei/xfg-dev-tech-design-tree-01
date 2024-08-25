package cn.bugstack.domain.service.tree.node;

import cn.bugstack.domain.service.tree.AbstractStrategyRouter;
import cn.bugstack.domain.service.tree.StrategyHandler;
import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SwitchRoot extends AbstractStrategyRouter {

    private final AccountNode accountNode;

    public SwitchRoot(AccountNode accountNode) {
        this.accountNode = accountNode;
    }

    @Override
    public DefaultStrategyFactory.DecisionOutcomeVO apply(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("【开关节点】规则决策树 userId:{}", materialVO.getUserId());
        // 可以动态处理一系列开关行为
        return router(materialVO, dynamicContext);
    }

    @Override
    public StrategyHandler get(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) {
        if ("open".equals(materialVO.getSwitchState())) {
            return accountNode;
        } else {
            return defaultStrategyHandler;
        }
    }

}
