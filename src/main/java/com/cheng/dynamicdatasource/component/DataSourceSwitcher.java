package com.cheng.dynamicdatasource.component;

import com.cheng.dynamicdatasource.domain.SysDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源选择
 * Created by niecheng on 2019/3/14.
 */
public class DataSourceSwitcher extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger("INTERACTIVE_LOGGER");

    /** 数据源集合*/
    private static Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();

    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();

    /** 默认数据源 */
    private DataSource defaultTargetDataSource;

    /**
     *  清除当前数据源
     */
    public static void clearDataSourceType() {
        LOGGER.debug("thread:{},remove,dataSource:{}",Thread.currentThread().getName());
        dataSourceKey.remove();
    }

    /**
     * 决定当前数据源
     * @return
     */
    @Nullable
    @Override
    protected String determineCurrentLookupKey() {
        String s = dataSourceKey.get();
        LOGGER.debug("thread:{},determine,dataSource:{}",Thread.currentThread().getName(),s);
        return s;
    }

    public static void setDataSourceKey(String dataSource) {
        LOGGER.debug("thread:{},set,dataSource:{}",Thread.currentThread().getName(),dataSource);
        dataSourceKey.set(dataSource);
    }

    /**
     * 重写该方法是为了动态创建数据源
     * @return
     */
    @Override
    protected DataSource determineTargetDataSource() {
        System.out.println("tttt");
        String dsKey = determineCurrentLookupKey();
        if(StringUtils.isEmpty(dsKey)){
            return defaultTargetDataSource;
        }else {
            return dataSourceMap.get(dsKey);
        }
    }

    /**
     *  创建新的数据源并添加到集合中
     *  添加同步锁,防止多线程同时创建多个数据源
     * @param sysDataSource
     * @return
     */
    public synchronized boolean putDataSource(SysDataSource sysDataSource){
        boolean flag = true;
        try{
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(sysDataSource.getDriver());
            basicDataSource.setUrl(sysDataSource.getUrl());
            basicDataSource.setUsername(sysDataSource.getUsername());
            basicDataSource.setPassword(sysDataSource.getPassword());
            basicDataSource.setValidationQuery("SELECT 1 FROM DUAL");

            dataSourceMap.put(sysDataSource.getId(), basicDataSource);
        }catch (Exception e){
            LOGGER.error("设置新的数据源出错");
            flag = false;
        }
        return flag;
    }

    public static void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
        DataSourceSwitcher.dataSourceMap = dataSourceMap;
    }

    public void setDefaultTargetDataSource(DataSource defaultTargetDataSource) {
        this.defaultTargetDataSource = defaultTargetDataSource;
    }
}
