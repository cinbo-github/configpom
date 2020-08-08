package com.cinbo.iface;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/9 21:56
 */
public interface WebProcess {


    Object process(String data);
}
