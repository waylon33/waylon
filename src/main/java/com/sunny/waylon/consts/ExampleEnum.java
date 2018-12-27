package com.sunny.waylon.consts;

public enum ExampleEnum {
    SUCCESS("SUCCESS"),
    ERROE("ERROR");

    private String value;

    public String ExampleEnum(){
        return this.value;
    }

    ExampleEnum(String value){
        this.value = value;
    }
}
