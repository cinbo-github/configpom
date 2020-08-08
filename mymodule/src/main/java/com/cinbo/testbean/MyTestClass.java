package com.cinbo.testbean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/31 12:00
 */
public class MyTestClass {

    public static Log log1 = LogFactory.getLog("aa.bb");

    public static void main(String[] args) {
        MyTestClass myTestClass = new MyTestClass();
        System.out.println("OK");
    }

}
