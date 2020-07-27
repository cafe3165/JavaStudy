package spy;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class apitest {
    Logger logger = Logger.getLogger(String.valueOf(TokenTest.class));

    public static void main(String[] args) throws IOException, URISyntaxException {
        String uri = "http://squirrel.vip.sankuai.com/api/cluster/statsinfo";
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS).build();
        URIBuilder uriBuilder = new URIBuilder(uri);
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("clusterName", "redis-bike-internal_product");
        BasicNameValuePair param2 = new BasicNameValuePair("env", "prod");
        list.add(param1);
        list.add(param2);
        uriBuilder.setParameters(list);
        // 根据带参数的URI对象构建GET请求对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accpet", "application/json, text/plain, */*");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Date", getServerTime());
        String client_id = "com.sankuai.bikeuser.api";
        String signature = "4a2b05b7-8ae8-4afc-8cb9-7f41a86e";
        httpGet.addHeader("Authorization", "MWS" + " " + client_id + ":" + signature);

        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("success");
            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.displayName()));
            //        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8.displayName());
        } else {
//            return String.valueOf(response.getStatusLine().getStatusCode());
            System.out.println("wrong");
        }

    }

    public static String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }
}
