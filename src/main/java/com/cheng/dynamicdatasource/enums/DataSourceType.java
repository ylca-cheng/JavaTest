package com.cheng.dynamicdatasource.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据源类型
 * Created by niecheng on 2019/3/14.
 */
public enum DataSourceType {
    /**
     *
     */
    SOURCE_1("ds1", "数据源1-默认数据源"),
    /**
     *
     */
    SOURCE_2("ds2", "数据源2");

    DataSourceType(String source, String desc) {
        this.source = source;
        this.desc = desc;
    }

    @Getter
    @Setter
    String source;

    @Getter
    @Setter
    String desc;

    /** asdfasf
     * @param hashKey
     * @return
     */
    public static String getByKey(String hashKey){
        //根据hashkey来获取所需要的数据源
        int i = Math.abs(hashKey.hashCode()) % DataSourceType.values().length;
        return DataSourceType.values()[i].getSource();
    }

}


