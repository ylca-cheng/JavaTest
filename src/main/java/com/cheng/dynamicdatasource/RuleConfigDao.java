package com.cheng.dynamicdatasource;

import java.util.List;
import java.util.Map;

/**
 * Created by niecheng on 2019/3/15.
 */
public interface RuleConfigDao {

    List<Map<String,Object>> selectRules();

    List<SysDataSource> selectDataSources();
}
