package com.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.entity.Person;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FastJson1的序列化
 */
public class FastjsonDemo01 {
    /**
     * 测试序列化
     */
    @Test
    public void testSerialize() {
        Person person = new Person();
        person.setId(1L);
//        person.setName("张三");
        person.setPwd("123");
        person.setAddr("深圳");
        person.setWebsiteUrl("www.baidu.com");
        person.setRegistryDate(new Date());
        person.setBirthday(LocalDateTime.now());
        /* 序列化：为NULL的值不会进行序列化
         * SerializerFeature.WriteMapNullValue 指定序列化时包含NULL值
         */
        String jsonString = JSON.toJSONString(person, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonString);
    }

    /**
     * 测试引用探测
     * $ref：对象中多次引用了同一个其他对象时，就会触发引用探测，替换为 $ref
     * DisableCircularReferenceDetect 禁止引用探测
     */
    @Test
    public void test$Ref() {
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        list.add(person);
        list.add(person);
        list.add(person);
        // DisableCircularReferenceDetect 禁止引用探测
        String jsonString = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(jsonString);
    }

    /**
     * 测试SerializeFilter定制化
     * 可以将要返回的JSON字符串进行定制化处理，如：
     * key大写、驼峰命名转下划线命名……等等
     */
    @Test
    public void testSerializeFilter(){
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setPwd("123");
        person.setAddr("深圳");
        person.setWebsiteUrl("www.baidu.com");
        person.setRegistryDate(new Date());
        person.setBirthday(LocalDateTime.now());
        /*
         * object：对象
         * name：key
         * value：value
         */
        NameFilter nameFilter = (object, name, value) -> name.toUpperCase();
        String jsonString = JSON.toJSONString(person, nameFilter);
        System.out.println(jsonString);
    }
}
