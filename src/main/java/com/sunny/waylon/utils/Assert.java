package com.sunny.waylon.utils;

public class Assert {

    public static void isTrue(boolean expression, String message){
        if (!expression){
            throw new IllegalArgumentException(message);
        }
    }
}
