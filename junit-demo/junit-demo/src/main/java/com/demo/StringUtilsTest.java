package com.demo;

import org.junit.*;

public class StringUtilsTest {
    @Before
    public void setUp() {
        System.out.println("---> before test");
    }
    @BeforeClass
    public static void setUpClass() {
        System.out.println("---> before class");
    }
    @After
    public void tearDown() {
        System.out.println("---> after test");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("---> after class");
    }

    @Test
    public void testLength() {
        String str = "hello world";
        long length = StringUtils.length(str);
        Assert.assertEquals("字符串长度不匹配", 11, length);
    }

    @Test
    public void testGetMaxIndex() {
        String str = "hello world";
        long maxIndex = StringUtils.getMaxIndex(str);
        Assert.assertEquals("字符串最大索引不匹配", 10, maxIndex);
    }
}
