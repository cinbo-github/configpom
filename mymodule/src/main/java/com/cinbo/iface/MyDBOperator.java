package com.cinbo.iface;

import com.cinbo.dto.UsersDTO;
import com.cinbo.mapper.MyTestDBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/24 12:08
 */
@Component("myDBOperator")
public class MyDBOperator implements IMyDBOperator {

    @Autowired
    MyTestDBDao myTestDBDao;

    @Override
    //@Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor = Throwable.class,readOnly = true)
    public void insert(UsersDTO po) {
        myTestDBDao.insert(po);

    }

    @Override
    public UsersDTO selectByPK(int id) {
        return null;
    }
}
