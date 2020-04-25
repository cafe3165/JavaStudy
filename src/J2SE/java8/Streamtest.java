package J2SE.java8;

import java.util.stream.Stream;

/**
 * Author:cafe3165
 * Date:2020-04-19
 */
public class Streamtest {
    public static void main(String[] args) {
        String str = "my name is 007";

        Stream.of(str.split(" ")).filter(s -> s.length() > 2)
                .map(s -> s.length()).forEach(System.out::println);
    }
}
