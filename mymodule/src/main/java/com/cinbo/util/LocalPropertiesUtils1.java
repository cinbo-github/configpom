package com.cinbo.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/31 12:42
 */
public class LocalPropertiesUtils1 extends PropertyPlaceholderConfigurer {
    private static Map ctxPropertiesMap;
    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }
    public static Object getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }
}
