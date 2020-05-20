package J2SE.StringTest;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-05-17
 */
public class stringMain {
    public static void main(String[] args) {
        String[] array = new String[]{"test", "1234", "5678"};
        List<String> list=new ArrayList<>();
        list.add("test");
        list.add("1234");
        list.add("5678");
        StringUtils.join(array, ",");
        System.out.println(array.toString());

       // 逗号分隔符，跳过 null
        Joiner joiner=Joiner.on(",").skipNulls();
        joiner.join(array);
        joiner.join(list);
        System.out.println(array);


    }
}
