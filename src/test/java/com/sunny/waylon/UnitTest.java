package com.sunny.waylon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.waylon.persist.bean.Fruit;
import org.junit.Test;

import java.util.Map;

public class UnitTest {

    @Test
    public void generate() throws Exception{
//        String str = "招商银行";
//        byte[] bArr = str.getBytes("gbk");
//        StringBuilder sb = new StringBuilder(bArr.length);
//        String sTemp;
//        for (int i = 0; i < bArr.length; i++) {
//            sTemp = Integer.toHexString(0xFF & bArr[i]);
//            if (sTemp.length() < 2){
//                sb.append(0);
//            }
//            sb.append(sTemp);
//        }
//        System.out.print(sb);
//        System.out.print(System.getenv("apple"));
//        String i = " ";
//        String oo = StringUtils.trim(i);
//        System.out.print(oo);
//
//        System.out.print(ExampleEnum.SUCCESS.ExampleEnum());

        Fruit fruit = new Fruit();
        fruit.setApple("an apple");
        fruit.setOrange("two orange");
        fruit.setGrape("so many grapes");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String str = objectMapper.writeValueAsString(fruit);
//        System.out.println(str);
        String str2 = "{\"apple\":\"an apple\",\"orange\":\"two orange\",\"grape\":\"so many grapes\"}";
//        Fruit fruit1 = (new ObjectMapper()).readValue(str2, Fruit.class);
        Map<String, String> fruitMap =  (new ObjectMapper()).readValue(str2, Map.class);
        System.out.println(fruitMap.get("apple"));
    }
}
