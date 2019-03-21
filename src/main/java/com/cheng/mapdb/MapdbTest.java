package com.cheng.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by niecheng on 2019/1/22.
 */
public class MapdbTest {
    private DB db;
    public static void main(String[] args) {
        MapdbTest test = new MapdbTest();
        test.putData();
        test.getData();
    }

    public void putData(){
        db = DBMaker.newFileDB(new File("testdb")).closeOnJvmShutdown().make();
//        db = DBMaker.newMemoryDB().make();
        ConcurrentMap map = db.getHashMap("map");
        map.put("something1", "here1");
        db.commit();
    }

    public void getData(){
        ConcurrentMap map = db.getHashMap("map");
        System.out.println(map.get("something"));

    }


}
