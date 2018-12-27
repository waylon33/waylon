package com.sunny.waylon.utils;

public class StringUtils {

    public StringUtils(){}

    public static String trim(Object o){
        if (o == null ){
            return null;
        } else {
            Assert.isTrue(o instanceof String, "传入非String类型值");
            String str = ((String)o).trim();
            return str.length() == 0 ? null : str;
        }

    }

    /**
     * 判断字符串是否为空
     * @param strs
     * @return
     */
    public static boolean hasText(String... strs){
        String[] str1 = strs;
        int len = str1.length;
        for ( int i = 0; i < len; i++){
            String str = trim(str1[0]);
            if (str == null || str.length() == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    public static String formatString(String template, String... str){
        return String.format(template, str);
    }
}
