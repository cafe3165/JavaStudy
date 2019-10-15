import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNotRepeatingCharSolution {
    public int FirstNotRepeatingChar(String str) {
        int index = -1;
        char[] chars = str.toCharArray();
        Map<Character, Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (m.containsKey(chars[i]))
                m.replace(chars[i], -1);
            else
                m.put(chars[i], i);
        }
        m.forEach((k, v) ->
                System.out.println(k + " " + String.valueOf(v)));
        for (Integer v : m.values())
            if (v >= 0)
                return v;

        return index;
    }

    public static void main(String[] args) {
//        String str = "abbdaacccdd";
//        要第一次出现的
//        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        String str="zuDClOWjkPNhb";
        FirstNotRepeatingCharSolution f = new FirstNotRepeatingCharSolution();
        System.out.println(f.FirstNotRepeatingChar(str));

    }
}
