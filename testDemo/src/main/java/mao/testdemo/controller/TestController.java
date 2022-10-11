package mao.testdemo.controller;

import mao.testdemo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao.testdemo.controller
 * Class(类名): TestController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 14:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@RestController
public class TestController
{
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public Student get(@RequestHeader(required = false) Map<String, String> header, @RequestBody(required = false) Student student)
    {
        log.info("收到了get请求");
        log.info("请求头：" + header);
        log.info("请求体：" + student);
        Student student1 = new Student()
                .setId(100001L)
                .setName("张三")
                .setSex("男")
                .setAge(18);

        log.info("响应数据：" + student1);
        return student1;
    }

    @PostMapping("/test")
    public Student post(@RequestHeader(required = false) Map<String, String> header, @RequestBody(required = false) Student student)
    {
        log.info("收到了post请求");
        log.info("请求头：" + header);
        log.info("请求体：" + student);
        Student student1 = new Student()
                .setId(100002L)
                .setName("李四")
                .setSex("女")
                .setAge(19);

        log.info("响应数据：" + student1);
        return student1;
    }
}
