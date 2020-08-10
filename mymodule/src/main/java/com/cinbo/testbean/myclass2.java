package com.cinbo.testbean;

import com.cinbo.iface.MyClassInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/6/17 17:47
 */
@Component("myclass2")
@Lazy(false)
public class myclass2 implements MyClassInterface {
    private static final Logger logger = LoggerFactory.getLogger(myclass2.class);
    private static final Logger log1 = LoggerFactory.getLogger("aa.bb");

    @Autowired
    private myclass myclass1;

    public void init(){
        System.out.println(this.getClass().getName()+"系统初始化");
        logger.debug(this.getClass().getName()+"系统初始化logger打印");
        aopfuc("ok");
    }

    public void mytestaop(String args){
        System.out.println("this is mytestaop");
    }

    @Override
    public void aopfuc(String args){
        System.out.println("this is aopfuc.");
    }



    public myclass2(){


        System.out.println(this.getClass().getName()+" 初始化");
        init();
        log1.info("测试的代码必须打印出来");
    }
}
