package com.sunny.waylon.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

    public JSONUtils(){}

    /**
     * 判断是否是有效的字符串
     * @param jsonStr
     * @return
     */
    public static boolean isValidateJson(String jsonStr){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(jsonStr, Object.class);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 将目标对象转换成JSON对象
     * @param o
     * @return
     */
    public String objectToJson(Object o){
        try{
            return (new ObjectMapper()).writeValueAsString(o);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 将json对象转换为目标对象
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String jsonStr, Class<T> clazz){
        if (StringUtils.trim(jsonStr) == null){
            return null;
        }
        try {
            return (new ObjectMapper()).readValue(jsonStr, clazz);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
