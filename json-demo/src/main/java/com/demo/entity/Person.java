package com.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Person {
    private Long id;

    private String name;

    // 序列化/反序列化时忽略成员属性
    @JSONField(serialize = false)
    private String pwd;

    // JSON的key与成员属性名映射
    @JSONField(name = "address")
    private String addr;

    private String websiteUrl;

    // 日期格式化
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registryDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;
}
