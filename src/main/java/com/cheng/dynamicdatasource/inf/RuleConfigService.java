package com.cheng.dynamicdatasource.inf;

import com.cheng.dynamicdatasource.domain.SysDataSource;

import java.util.List;
import java.util.Map;

/**
 * 规则服务接口
 * Created by niecheng on 2019/3/21.
 */
public interface RuleConfigService {

    /**
     *  查询所有规则
     * @return
     */
    List<Map<String,Object>> selectRules();

    /**
     * 查询所有数据源
     * @return
     */
    List<SysDataSource> selectDataSources();
}
