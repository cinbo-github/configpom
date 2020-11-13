package com.cinbo.iface;

import com.alibaba.fastjson.JSON;
import com.cinbo.mapper.MyTestDBDao;
import com.cinbo.testbean.MyTestClass;
import com.cinbo.util.LocalPropertiesUtil;
import com.cinbo.util.LocalPropertiesUtils1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/9 21:57
 */
@Component("myWebProcess")
public class MyWebProcess implements WebProcess {

    @Autowired
    MyTestDBDao myTestDBDao;

    @Autowired
    IMyDBOperator myDBOperator;

    @Autowired
    MyClassInterface  class2;

    @Autowired
    MyTestClass myTestClass;


    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = Throwable.class,readOnly = false)
    public Object process(String data) {

        //方法切面定义，通过注解定义切面。定义类 aopConfig
        //执行这个方法时，会执行切面前后的方法
        class2.aopfuc("OK");

        System.out.println(JSON.toJSONString(myTestClass.testMap));

        System.out.println("cim.url.ip3:"+LocalPropertiesUtils1.getContextProperty("cim.url.ip3"));
        System.out.println("cim.url.ip3:"+ LocalPropertiesUtil.getProperties("application/appcim.properties","cim.url.ip3"));



        //根据process传入的参数坐不同的处理
        if(data.equalsIgnoreCase("insert")){
//            UsersDTO usersDTO = new UsersDTO();
//            usersDTO.setUsername("testname");
//            usersDTO.setPassword("123");
//            usersDTO.setLogindate(new Date());
//            usersDTO.setMyvalue("我的值");
//            myDBOperator.insert(usersDTO);
//            throw new RuntimeException("测试异常");
            //return "insert ok";
        }else {
//            Integer id = Integer.parseInt(data);
//
//            UsersDTO usersDTO = myTestDBDao.selectById(id);
//
//            return "ok,i am ok!" + usersDTO.toString();
        }

        return "ok";
    }


}
