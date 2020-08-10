package com.cinbo.testbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/6/17 17:47
 */
@Component("myclassname")
public class myclass {
    private static final Logger logger = LoggerFactory.getLogger(myclass.class);

    public void init(){
        System.out.println(this.getClass().getName()+"系统初始化");
        logger.debug(this.getClass().getName()+"系统初始化logger打印");
    }

    public myclass(){
        System.out.println(this.getClass().getName()+"com.cinbo.testbean.myclass 初始化");
    }

    public static void main(String[] args) {
        String my=null;
        System.out.println("test string"+my+" is test.");
    }


}
