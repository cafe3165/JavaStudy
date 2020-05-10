package J2SE.java8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author:cafe3165
 * Date:2020-04-19
 */
public class Streamtest {
    public static void main(String[] args) {
//        String str = "my name is 007";
//
//        Stream.of(str.split(" ")).filter(s -> s.length() > 2)
//                .map(s -> s.length()).forEach(System.out::println);
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ls.add(i);
        }
        ls.stream().sorted((a,b)->(b-a)).filter((s) -> s > 5).forEach(System.out::println);
    }
}
