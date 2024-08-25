package cn.bugstack.test;

import cn.bugstack.domain.service.tree.StrategyHandler;
import cn.bugstack.domain.service.tree.factory.DefaultStrategyFactory;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    private DefaultStrategyFactory defaultStrategyFactory;

    @Test
    public void test() throws Exception {
        DefaultStrategyFactory.MaterialVO materialVO = new DefaultStrategyFactory.MaterialVO();
        materialVO.setUserId("xiaofuge");
        materialVO.setSwitchState("open");

        StrategyHandler strategyHandler = defaultStrategyFactory.strategyHandler();
        DefaultStrategyFactory.DecisionOutcomeVO decisionOutcomeVO = strategyHandler.apply(materialVO, new DefaultStrategyFactory.DynamicContext());

        log.info("请求参数:{}", JSON.toJSONString(materialVO));
        log.info("测试结果:{}", JSON.toJSONString(decisionOutcomeVO));
    }

}
