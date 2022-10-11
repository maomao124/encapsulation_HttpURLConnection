package mao;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Class(测试类名): SimpleHTTPImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 13:08
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SimpleHTTPImplTest
{
    private static HTTP http;

    @BeforeAll
    static void beforeAll()
    {
        http = new SimpleHTTPImpl();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("a1", "b1");
        http.setDefaultRequestHeader(map);
    }

    @AfterAll
    static void afterAll()
    {

    }

    @Test
    void request()
    {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("a", "b");
        String s = http.request("https://www.bilibili.com/", "GET", map, null);
        System.out.println(s);
    }

    @Test
    void GET()
    {
        String s = http.GET("https://www.bilibili.com/");
        System.out.println(s);
    }
}