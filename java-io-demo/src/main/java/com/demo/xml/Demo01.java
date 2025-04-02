package com.demo.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo01 {
    public static void main(String[] args) throws DocumentException {
        // 1. 创建一个SAXReader解析器对象
        SAXReader saxReader = new SAXReader();
        // 2. 解析XML文件，得到Document对象
        Document document = saxReader.read("java-io-demo/src/main/resources/users.xml");
        // 3. 获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        // 4. 获取一级子元素列表
        // List<Element> elements = rootElement.elements();
        List<Element> elements = rootElement.elements("user");
        for (Element element : elements) {
            System.out.println(element.getName());
        }
        // 5. 获取当前元素下的某个子元素
        Element otherElement = rootElement.element("other");
        System.out.println(otherElement.getText());
        // 6. 获取当前元素下的某个子元素，若存在多个同名子元素，默认获取第一个
        Element userElement = rootElement.element("user");
        System.out.println(userElement.elementText("name"));
        System.out.println("---------------------------------------------------");
        // 7. 获取元素的属性信息
        System.out.println(otherElement.attributeValue("desc"));
        Attribute id = otherElement.attribute("id");
        System.out.println(id.getName());
        System.out.println(id.getValue());
        // 8. 获取元素的属性列表
        List<Attribute> attributes = otherElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName());
            System.out.println(attribute.getValue());
        }
        System.out.println("---------------------------------------------------");
        // 9. 获取元素的文本内容
        System.out.println(userElement.elementText("name"));
        System.out.println(userElement.elementText("age"));
        System.out.println(userElement.elementText("sex"));
        Element address = userElement.element("address");
        System.out.println(address.getText());
    }
}
