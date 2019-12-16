package newcoder;

import java.util.Map;
import java.util.Iterator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstAppearingOnceSolution {
    Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (m.containsKey(ch)) {
            m.put(ch, m.get(ch) + 1);
        } else {
            m.put(ch, 1);
        }

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        Set<Map.Entry<Character, Integer>> entrySet = m.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            Character k = (Character) entry.getKey();
            Integer v = (Integer) entry.getValue();
            if (v ==1) {
                return k;

            } else {
                continue;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnceSolution f = new FirstAppearingOnceSolution();
        char[] chars = {'g', 'o', 'o', 'g', 'l', 'e'};
        for (int i = 0; i < chars.length; i++) {
            f.Insert(chars[i]);
        }

        System.out.println(f.FirstAppearingOnce());

    }
}
