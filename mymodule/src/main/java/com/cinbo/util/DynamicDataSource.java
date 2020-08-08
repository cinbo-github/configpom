package com.cinbo.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/8/6 9:59
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {

        return DataSourceContextHolder.getDataSourceType();
    }

}
