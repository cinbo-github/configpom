package com.cinbo.iface;

import com.cinbo.dto.UsersDTO;
import com.cinbo.mapper.MyTestDBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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


    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = Throwable.class,readOnly = false)
    public Object process(String data) {


        if(data.equalsIgnoreCase("insert")){
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setUsername("testname");
            usersDTO.setPassword("123");
            usersDTO.setLogindate(new Date());
            usersDTO.setMyvalue("我的值");
            myDBOperator.insert(usersDTO);
            throw new RuntimeException("测试异常");
            //return "insert ok";
        }else {
            Integer id = Integer.parseInt(data);

            UsersDTO usersDTO = myTestDBDao.selectById(81);

            return "ok,i am ok!" + usersDTO.toString();
        }
    }


}
