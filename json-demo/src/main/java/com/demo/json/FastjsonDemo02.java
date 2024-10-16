package com.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.demo.entity.Person;
import com.demo.entity.Result;
import org.junit.Test;

/**
 * Fastjson1的反序列化
 */
public class FastjsonDemo02 {
    @Test
    public void testDeSerialize() {
        String jsonString = "{\"addr\":\"深圳\",\"birthday\":\"2024-09-14 15:02:28\",\"id\":1,\"name\":null,\"pwd\":\"123\",\"registryDate\":\"2024-09-14 15:02:27\",\"websiteUrl\":\"www.baidu.com\"}";
        // 一般的反序列化
        Person person = JSON.parseObject(jsonString, Person.class);
        System.out.println(person);
        // 带泛型的反序列化
        Result<Person> personResult = Result.buildSuccess(person);
        String personJsonString = JSON.toJSONString(personResult);
        Result<Person> result = JSON.parseObject(personJsonString, new TypeReference<Result<Person>>() {
        });
        Person data = result.getData();
        System.out.println("result: " + result);
        System.out.println("data: " + data);

    }
}
