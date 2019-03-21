package com.cheng.dynamicdatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 动态数据源切换测试
 * Created by niecheng on 2019/3/15.
 */
public class Test {
    public static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RuleConfigDao ruleConfigDao = (RuleConfigDao) context.getBean("ruleConfigDao");
        DataSourceSwitcher dataSourceSwitcher = (DataSourceSwitcher) context.getBean("dataSourceSwitcher");

//        DataSourceSwitcher.setDataSourceKey("ds1");
        List<Map<String, Object>>  rules = ruleConfigDao.selectRules();
        if(!CollectionUtils.isEmpty(rules)){
            for (Map<String, Object> rule : rules){
                System.out.println("规则ID："+rule.get("ID")+",规则名称："+rule.get("NAME"));
            }
        }
        //查询数据源
        List<SysDataSource> sysDataSources = ruleConfigDao.selectDataSources();
        if(!CollectionUtils.isEmpty(sysDataSources)){
            for (SysDataSource dataSource : sysDataSources){
                System.out.println(dataSource);
                // 加入新的数据源
                dataSourceSwitcher.putDataSource(dataSource);
                // 切换数据源
                LOGGER.info("切换数据源！！！！！！！！！");
                DataSourceSwitcher.setDataSourceKey(dataSource.getId());
                List<Map<String, Object>>  rules2 = ruleConfigDao.selectRules();
                if(!CollectionUtils.isEmpty(rules2)){
                    for (Map<String, Object> rule : rules2){
                        System.out.println("规则ID："+rule.get("ID")+",规则名称："+rule.get("NAME"));
                    }
                }
            }

        }

        // 切换数据源
//        LOGGER.info("切换数据源！！！！！！！！！");
//        DataSourceSwitcher.setDataSourceKey("ds2");
//        List<Map<String, Object>>  rules2 = ruleConfigDao.selectRules();
//        if(!CollectionUtils.isEmpty(rules2)){
//            for (Map<String, Object> rule : rules2){
//                System.out.println("规则ID："+rule.get("ID")+",规则名称："+rule.get("NAME"));
//            }
//        }
    }
}
