package cn.bugstack.domain.service.tree.factory;

import cn.bugstack.domain.service.tree.StrategyHandler;
import cn.bugstack.domain.service.tree.node.RootNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class DefaultStrategyFactory {

    private final RootNode rootNode;

    public DefaultStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {
        private Integer level;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MaterialVO {
        private String userId;
        private String switchState = "open";
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DecisionOutcomeVO {
        private Integer level;
    }

}
