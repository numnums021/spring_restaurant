package ru.hj77.server.db;

import lombok.extern.java.Log;
import java.util.LinkedHashMap;
import java.util.Map;

@Log
public class DataBase {

    private static final Map<Integer, String> map = new LinkedHashMap<>();

    public static void insertData(int id, String name){
        map.put(id, name);
    }

    public static void print(){
        log.info(" " + map);
    }

}
