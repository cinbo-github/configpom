package com.cinbo.iface;

import com.cinbo.dto.UsersDTO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/24 12:06
 */
public interface IMyDBOperator {

    @Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor = Throwable.class)
    public void insert(UsersDTO po);

    UsersDTO selectByPK(int id);
}
