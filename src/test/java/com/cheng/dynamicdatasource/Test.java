package com.cheng.dynamicdatasource;

import com.cheng.dynamicdatasource.component.DataSourceSwitcher;
import com.cheng.dynamicdatasource.domain.SysDataSource;
import com.cheng.dynamicdatasource.inf.RuleConfigService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 动态数据源切换测试
 * 采用注解的方式,则可以自动注入
 * 不采用注解,则需要手动在setUp中手动获取
 *
 * Created by niecheng on 2019/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class Test {
    public static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    @Resource(name = "RuleConfigService")
    private  RuleConfigService ruleConfigService;
    @Resource(name = "dataSourceSwitcher")
    private DataSourceSwitcher dataSourceSwitcher;

    @Before
    public void setUp(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ruleConfigService = (RuleConfigService) context.getBean("RuleConfigService");
//        dataSourceSwitcher = (DataSourceSwitcher) context.getBean("dataSourceSwitcher");
    }

    @org.junit.Test
    public void test() {
        // 默认数据源
        List<Map<String, Object>> rules = ruleConfigService.selectRules();
        if(!CollectionUtils.isEmpty(rules)){
            for (Map<String, Object> rule : rules){
                System.out.println("规则ID："+rule.get("ID")+",规则名称："+rule.get("NAME"));
            }
        }
        //查询数据源
        List<SysDataSource> sysDataSources = ruleConfigService.selectDataSources();
        if(!CollectionUtils.isEmpty(sysDataSources)){
            for (SysDataSource dataSource : sysDataSources){
                System.out.println(dataSource);
                // 加入新的数据源
                dataSourceSwitcher.putDataSource(dataSource);
                // 切换数据源
                LOGGER.info("切换数据源！！！！！！！！！");
                DataSourceSwitcher.setDataSourceKey(dataSource.getId());
                List<Map<String, Object>>  rules2 = ruleConfigService.selectRules();
                if(!CollectionUtils.isEmpty(rules2)){
                    for (Map<String, Object> rule : rules2){
                        System.out.println("规则ID："+rule.get("ID")+",规则名称："+rule.get("NAME"));
                    }
                }
            }
        }
    }
}
