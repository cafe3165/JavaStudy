package other;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class guavacacheTest {





    public static void main(String[] args) {
//        Cache<String,String> cache = CacheBuilder.newBuilder().build();
//        Map<String,String> map = new HashMap<>();
//        cache.put("word","Hello Guava Cache");
//        cache.putAll(map);
//        System.out.println(cache.getIfPresent("word"));

//        CopyOnWriteArrayList
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls){
            System.out.println(url.toExternalForm());
        }
        while(true);




    }
}
