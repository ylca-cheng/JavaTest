package com.cheng.dynamicdatasource;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * Created by niecheng on 2019/3/18.
 */
public class SysDataSource {
    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    private String driver;

    @Setter
    @Getter
    private String url;

    @Setter
    @Getter
    private String username;

    @Setter
    @Getter
    private String password;

    @Override
    public String toString(){
        return "[id="+id+",driver="+driver+",url="+url+",username="+username+",password="+password+"]";
    }
}
