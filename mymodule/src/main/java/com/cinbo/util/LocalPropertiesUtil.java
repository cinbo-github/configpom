package com.cinbo.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/7/31 13:36
 */
public class LocalPropertiesUtil {

    public static String getProperties(String locations,String key){
        if(StringUtils.isEmpty(key)||StringUtils.isEmpty(locations)){
            return "";
        }

        Properties pro = new Properties();
        InputStream is = null;
        String proVal = "";
        try{
            is = LocalPropertiesUtil.class.getClassLoader().getResourceAsStream(locations);
            pro.load(is);
        }catch (IOException e){
        }finally {
            try{
                is.close();
            }catch (IOException e){

            }
        }
        return proVal;
    }
}
