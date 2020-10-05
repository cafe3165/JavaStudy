package NewReal;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:cafe3165
 * Date:2020-09-17
 */
public class WYSS_1 {
    public static void main(String[] args) throws IOException {
        File file = new File("README.md");
//        InputStream inputStream = new FileInputStream(file);
//        Pattern pattern=new Pattern()
//        String Text = "sfsfsfasfasfs\n"
//                + "eeeeeeeeeeee\n"
//                + "55555555\n"
//                + "ldlfldfslkd5555\n";
        String Text="2019.....2017...20162015...2020";
        String regx="\\b\\d+\\b";
        Pattern pattern=Pattern.compile(regx);
        Matcher matcher=pattern.matcher(Text);
        int i=0;
        while(matcher.find()){
            System.out.println(matcher.group(i++));
        }


    }
}
