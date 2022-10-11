package mao;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Class(类名): SimpleRestfulHTTPImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 14:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class SimpleRestfulHTTPImpl extends SimpleHTTPImpl implements RestfulHTTP
{

    /**
     * 转换成json
     *
     * @param object 对象
     * @return {@link String}
     */
    protected String toJson(Object object)
    {
        return JSON.toJSONString(object);
    }

    /**
     * 解析Json
     *
     * @param json  json
     * @param clazz clazz
     * @return {@link T}
     */
    protected <T> T parse(String json, Class<T> clazz)
    {
        return JSON.parseObject(json, clazz);
    }


    @Override
    public <T> T request(Class<T> responseClazz, String urlString, String method, Map<String, String> requestHeader, Object requestBody)
    {
        String json = this.request(urlString, method, requestHeader, requestBody == null ? null : toJson(requestBody));
        return this.parse(json, responseClazz);
    }

    /**
     * GET请求
     *
     * @param responseClazz 响应体的类型字节码
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @return {@link T}
     */
    @Override
    public <T> T GET(Class<T> responseClazz, String urlString, Map<String, String> requestHeader, Object requestBody)
    {
        return request(responseClazz, urlString, "GET", requestHeader, requestBody);
    }

    /**
     * 异步请求
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param method        方法
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    @Override
    public <T> void asyncRequest(Class<T> responseClazz, String urlString, String method, Map<String, String> requestHeader, Object requestBody, RestfulHTTPHandlerListener listener)
    {
        this.asyncRequest(urlString, method, requestHeader, requestBody == null ? null : toJson(requestBody), new HTTPHandlerListener()
        {
            @Override
            public void OKHandler(String responseString, int responseCode)
            {
                T t = parse(responseString, responseClazz);
                listener.OKHandler(t, responseCode);
            }

            @Override
            public void ExceptionHandler(IOException e, int responseCode)
            {
                listener.ExceptionHandler(e, responseCode);
            }
        });
    }

    /**
     * 异步GET请求
     *
     * @param responseClazz 响应clazz
     * @param urlString     url字符串
     * @param requestHeader 请求头
     * @param requestBody   请求体
     * @param listener      侦听器
     */
    @Override
    public <T> void asyncGETRequest(Class<T> responseClazz, String urlString,
                                    Map<String, String> requestHeader, Object requestBody, RestfulHTTPHandlerListener listener)
    {
        this.asyncRequest(responseClazz, urlString, "GET", requestHeader, requestBody, listener);
    }

}
