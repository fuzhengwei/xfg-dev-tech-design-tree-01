package cn.bugstack.domain.service.tree.node;


import cn.bugstack.domain.service.tree.AbstractStrategyRouter;
import cn.bugstack.domain.service.tree.StrategyHandler;
import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class AccountNode extends AbstractStrategyRouter {

    private final MemberLevel0Node memberLevel0Node;
    private final MemberLevel1Node memberLevel1Node;
    private final MemberLevel2Node memberLevel2Node;

    public AccountNode(MemberLevel0Node memberLevel0Node, MemberLevel1Node memberLevel1Node, MemberLevel2Node memberLevel2Node) {
        this.memberLevel0Node = memberLevel0Node;
        this.memberLevel1Node = memberLevel1Node;
        this.memberLevel2Node = memberLevel2Node;
    }

    @Override
    public DefaultStrategyFactory.DecisionOutcomeVO apply(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("【账户节点】规则决策树 userId:{}", materialVO.getUserId());

        // 1. 模拟查询用户级别
        int level = new Random().nextInt(3);
        log.info("模拟查询用户级别 level:{}",level);

        dynamicContext.setLevel(level);

        return router(materialVO, dynamicContext);
    }

    @Override
    public StrategyHandler get(DefaultStrategyFactory.MaterialVO materialVO, DefaultStrategyFactory.DynamicContext dynamicContext) {
        switch (dynamicContext.getLevel()){
            case 0:
                return memberLevel0Node;
            case 1:
                return memberLevel1Node;
            case 2:
                return memberLevel2Node;
            default:
                return defaultStrategyHandler;
        }
    }

}
