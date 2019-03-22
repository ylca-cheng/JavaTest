package com.cheng.dynamicdatasource.impl;

import com.cheng.dynamicdatasource.domain.SysDataSource;
import com.cheng.dynamicdatasource.inf.RuleConfigService;
import com.cheng.dynamicdatasource.mapper.RuleConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 规则服务实现类
 * @author niecheng
 * Created by niecheng on 2019/3/21.
 */
@Service("RuleConfigService")
public class RuleConfigServiceImpl implements RuleConfigService {
    @Autowired
    private RuleConfigDao ruleConfigDao;

    @Override
    public List<Map<String, Object>> selectRules() {
        return ruleConfigDao.selectRules();
    }

    @Override
    public List<SysDataSource> selectDataSources() {
        return ruleConfigDao.selectDataSources();
    }
}
