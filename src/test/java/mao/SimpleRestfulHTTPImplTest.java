package mao;

import mao.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Class(测试类名): SimpleRestfulHTTPImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 15:01
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SimpleRestfulHTTPImplTest
{
    private static RestfulHTTP http;

    @BeforeAll
    static void beforeAll()
    {
        http = new SimpleRestfulHTTPImpl();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("a1", "b1");
//        map.put("Content-Type", "application/json;charsetset=UTF-8");
//        map.put("Accept", "application/json");
        http.setDefaultRequestHeader(map);
    }


    @Test
    void request()
    {
        Student student = http.request(Student.class, "http://localhost:8080/test", "GET", null, null);
        System.out.println(student);
    }

    @Test
    void request2()
    {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value2");
        map.put("b", "c");
        Student student = http.request(Student.class, "http://localhost:8080/test", "GET", map, null);
        System.out.println(student);
    }

    @Test
    void request3()
    {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value2");
        map.put("b", "c");
        Student student = http.request(Student.class, "http://localhost:8080/test",
                "POST", map, new Student().setAge(17).setId(100023L));
        System.out.println(student);
    }

    @Test
    void request4()
    {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value2");
        map.put("b", "c");
        Student student = http.request(Student.class, "http://localhost:8080/test",
                "POST", map, new Student().setAge(17).setId(100023L).setName("王五").setSex("男"));
        System.out.println(student);
    }

    @Test
    void GET()
    {
        Student student = http.GET(Student.class, "http://localhost:8080/test", null, null);
        System.out.println(student);
    }

    @Test
    void asyncRequest()
    {
    }

    @Test
    void asyncGETRequest()
    {
    }
}