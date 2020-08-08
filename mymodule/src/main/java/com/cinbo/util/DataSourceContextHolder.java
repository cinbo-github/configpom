package com.cinbo.util;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/8/6 10:00
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder =
            new ThreadLocal(); // 线程本地环境
    // 设置数据源类型
    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }
    // 获取数据源类型
    public static String getDataSourceType() {
        return (String) contextHolder.get();
    }
    // 清除数据源类型
    public static void clearDataSourceType () {
        contextHolder.remove();
    }
}
