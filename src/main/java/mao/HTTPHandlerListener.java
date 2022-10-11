package mao;

import java.io.IOException;

/**
 * Project name(项目名称)：封装HttpURLConnection
 * Package(包名): mao
 * Interface(接口名): HTTPHandlerListener
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/11
 * Time(创建时间)： 12:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface HTTPHandlerListener
{
    void OKHandler(String responseString);

    void ExceptionHandler(IOException e);
}
