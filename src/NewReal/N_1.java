package NewReal;

import J2SE.codeblock.D;

import java.util.HashMap;
import java.util.Map;

public class N_1 {
    public static void main(String[] args) {
        map.put("零", 0);
        map.put("壹", 1);
        map.put("贰", 2);
        map.put("叁", 3);
        map.put("肆", 4);
        map.put("伍", 5);
        map.put("陆", 6);
        map.put("柒", 7);
        map.put("捌", 8);
        map.put("玖", 9);
        map.put("拾", 10);
        map.put("佰", 100);
        map.put("仟", 1000);
        map.put("万", 10000);
        map.put("亿", 100000000);
        map.put("分", 0.01);
        map.put("角", 0.1);
        map.put("元", 1);
        solve("壹万伍仟零壹拾元柒角捌分");
//        柒角捌分 壹万伍仟零壹拾壹元柒角捌分
    }

    private static Map<String, Number> map = new HashMap<>();

    public static double solve(String money) {
        double res = 0.0;
        for (int i = 0; i < money.length(); i += 2) {
            if (money.charAt(i) == '零' || money.charAt(i) == '元') {
                i -= 1;
                continue;
            }
            Number a = map.get(String.valueOf(money.charAt(i))), b = 1;
            if (i + 1 < money.length()) {
                b = map.get(String.valueOf(money.charAt(i + 1)));
            }
            res += a.doubleValue() * b.doubleValue();
        }
        return res;
    }
}
