package spy;

import lombok.extern.log4j.Log4j;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.checkerframework.checker.units.qual.K;
import org.json.JSONObject;


import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TokenTest {
    Logger logger = Logger.getLogger(String.valueOf(TokenTest.class));

    public static void main(String[] args) throws IOException {
        HttpClientContext context = HttpClientContext.create();


//        String uri = "http://squirrel.mws-test.sankuai.com/cluster/detail/cluster-monitor?name=redis-bike-internal_qa&env=qa&project_id=6973";
//            String uri="http://mws-test.sankuai.com/portal";
            String uri="http://squirrel.mws-test.sankuai.com/cluster/detail/cluster-monitor?name=redis-bike-userstatus_qa&env=qa&project_id=6973";
//        CloseableHttpClient httpClient = HttpClients.custom().setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS).build();
//        HttpPost httpPost = new HttpPost(url.trim());
//        httpPost.setHeader(new BasicHeader("Content-type", "application/x-www-form-urlencoded"));
//        List<NameValuePair> list = new ArrayList<NameValuePair>();
//        list.add(new BasicNameValuePair("email", "123456789@163.com"));
//        list.add(new BasicNameValuePair("password", "123456"));
//        httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
//        HttpResponse response = httpClient.execute(httpPost);

//        Header[] headers = response.getHeaders("Set-Cookie");
        HashMap<String, String> cookies = new HashMap<String, String>(2);
        String _lxsdk_cuid = "172f8d95c74c8-0baf0337be4f96-31607402-1ea000-172f8d95c74c8";
        String _lxsdk = "172f8d95c74c8-0baf0337be4f96-31607402-1ea000-172f8d95c74c8";
        String u = "1828726737";
        String _ga = "GA1.2.977751502.1595212814";
        String _gid = "GA1 .2.1864065149.1595212814";
        String logan_session_token = "97wzmfny4vig8ul7jsgj";
        String logan_custom_report = "";
        String webNewUuid = "2ec45d48b08333d0b4d5e087e576b8ac_1595232991698";
        String webDeviceUuid = "172f8d95c74c8-0baf0337be4f96-31607402-1ea000-172f8d95c74c8";
        String _lxsdk_s = "1736b43396e-5f9-0e4-60c%7C%7C81";
        cookies.put("_lxsdk_cuid", _lxsdk_cuid);
        cookies.put("_lxsdk", _lxsdk);
        cookies.put("u", u);
        cookies.put("_ga", _ga);
        cookies.put("_gid", _gid);
        cookies.put("logan_session_token", logan_session_token);
        cookies.put("logan_custom_report", logan_custom_report);
        cookies.put("webNewUuid", webNewUuid);
        cookies.put("webDeviceUuid", webDeviceUuid);
        cookies.put("_lxsdk_s", _lxsdk_s);

        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS).build();

        //httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BEST_MATCH);

        for (String Key : cookies.keySet()) {
            BasicClientCookie cookie = new BasicClientCookie(Key, cookies.get(Key));
            cookie.setPath("/");
            cookie.setExpiryDate(new Date(System.currentTimeMillis() + 60 * 60 * 1000));
            cookieStore.addCookie(cookie);
        }

        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("Cookie", cookieStore.toString());
        httpPost.addHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpPost.addHeader("Connection", "keep-alive");
        //httpPost.addHeader("Content-Length", "114");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.addHeader("Host", " ssosv.sankuai.com");
        httpPost.addHeader("Origin", "https://ssosv.sankuai.com");
//        httpPost.addHeader("Referer", "https://ssosv.sankuai.com/sson/login?t=1595232990307&redirect_uri=http%3A%2F%2Fmws-test.sankuai.com%2Fsso%2Fcallback%3Foriginal-url%3Dhttp%253A%252F%252Fmws-test.sankuai.com&client_id=60921859");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
        httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
        httpPost.addHeader("Sec-Fetch-Dest", "empty");
        httpPost.addHeader("Sec-Fetch-Mode", "cors");
        httpPost.addHeader("Sec-Fetch-Site", "same-origin");

        //System.out.println(getGid());

        List<BasicNameValuePair> pair = new ArrayList<>();
        pair.add(new BasicNameValuePair("uuid", "e13d3d4b26614683b59d58d28802f089"));
        pair.add(new BasicNameValuePair("service", ""));
        pair.add(new BasicNameValuePair("appkey", "60921859"));
        pair.add(new BasicNameValuePair("It", "LT-84358-Tj0VuXPyyYFGrDyH5XIOs1Yciqy4ra-ssosv.it"));

        //httppost 中放入我们的经过url编码的表单参数

        httpPost.setEntity(new UrlEncodedFormEntity(pair));


        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("success");
            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.displayName()));
            //        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.displayName());
        } else {
//            return String.valueOf(response.getStatusLine().getStatusCode());
            System.out.println("wrong");
        }

    }

    private static String getGid() {
        //js function：getRouteInfo，入参为province
        String routeScript = "function getRouteInfo(province){ \n" + // 参数不要带var。。不然后面执行方法的时候会报错。。
                "      if (province=='henan') " +
                "         return 'http://127.0.0.1/resweb';\n" +
                "      else  " +
                "         return '未找到对应的省份信息，province='+province;\n" +
                "}";

        String scriptResult = "";//脚本的执行结果

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");//1.得到脚本引擎
        try {
            //2.引擎读取 脚本字符串
            engine.eval(new StringReader(routeScript));
            //如果js存在文件里，举例
            // Resource aesJs = new ClassPathResource("js/aes.js");
            // this.engine.eval(new FileReader(aesJs.getFile()));

            //3.将引擎转换为Invocable，这样才可以掉用js的方法
            Invocable invocable = (Invocable) engine;

            //4.使用 invocable.invokeFunction掉用js脚本里的方法，第一個参数为方法名，后面的参数为被调用的js方法的入参
            scriptResult = (String) invocable.invokeFunction("getRouteInfo", "henan");

        } catch (ScriptException e) {
            e.printStackTrace();
            System.out.println("Error executing script: " + e.getMessage() + " script:[" + routeScript + "]");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("Error executing script,为找到需要的方法: " + e.getMessage() + " script:[" + routeScript + "]");
        }
        System.out.println(scriptResult);

        return scriptResult;
    }


}
