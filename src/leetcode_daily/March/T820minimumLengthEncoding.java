package leetcode_daily.March;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-28
 */
public class T820minimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        Tire t = new Tire();
        int len = 0;
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String s : words) {
            len += t.insert(s);
        }

        return len;
    }


    class Tire {
        TireNode root;

        public Tire() {
            root = new TireNode();
        }

        public int insert(String words) {
            TireNode cur = root;
            boolean isNew = false;
            for (int i = words.length() - 1; i >= 0; i--) {
                int c = words.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    isNew = true;
                    cur.children[c] = new TireNode();
                }
                cur = cur.children[c];

            }
            return isNew ? words.length() + 1 : 0;

        }

    }

    class TireNode {
//        char val;
        TireNode[] children = new TireNode[26];

        public TireNode() {
        }
//
//        public TireNode(char c) {
//            val = c;
//        }

    }


    public static void main(String[] args) {
        T820minimumLengthEncoding t = new T820minimumLengthEncoding();
        String[] words = {"time", "me", "bell"};
        t.minimumLengthEncoding(words);
    }

}
