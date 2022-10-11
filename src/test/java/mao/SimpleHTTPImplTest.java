package mao;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @Test
    void asyncRequest()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        http.setThreadPool(executorService);

        http.asyncRequest("https://www.bilibili.com/", "GET", new HTTPHandlerListener()
        {
            @Override
            public void OKHandler(String responseString, int responseCode)
            {
                System.out.println(responseCode);
                System.out.println(responseString);
            }

            @Override
            public void ExceptionHandler(IOException e, int responseCode)
            {
                e.printStackTrace();
            }
        });

        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}