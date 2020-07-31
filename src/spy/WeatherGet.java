package spy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WeatherGet {
    public static void main(String[] args) throws IOException {
        String url="https://beijing.tianqi.com/";

        Document doc = Jsoup.parseBodyFragment(Jsoup.connect(url).get().toString());
        Element body = doc.body();
        Elements weather=doc.getElementsByClass("weather");
        String w=weather.text();
        String []ws=w.split(" ");
        System.out.println("当前温度"+ws[0]);
        StringBuilder sb=new StringBuilder();
        for(String wi:ws){
            sb.append(wi);
            sb.append(" ");
        }
        System.out.println(sb.toString());
//        System.out.println();
        Elements moisture =doc.getElementsByClass("shidu");
        String m=moisture.text();
        System.out.println(m);
        Elements airquality=doc.getElementsByClass("kongqi");
        String a=airquality.text();
        System.out.println(a);
    }
}
