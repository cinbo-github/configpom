package com.cinbo.testbean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/31 12:00
 */
public class MyTestClass {

    public Map<String,Integer> testMap = new HashMap<>();

    public void setTestMap(Map<String, Integer> testMap) {
        this.testMap = testMap;
    }

    public static Log log1 = LogFactory.getLog("aa.bb");

    public static void main(String[] args) {
        MyTestClass myTestClass = new MyTestClass();
        System.out.println("OK");
    }

}
