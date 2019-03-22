package com.cheng.dynamicdatasource.mapper;

import com.cheng.dynamicdatasource.domain.SysDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by niecheng on 2019/3/15.
 */

@Repository
public interface RuleConfigDao {

    List<Map<String,Object>> selectRules();

    List<SysDataSource> selectDataSources();
}
