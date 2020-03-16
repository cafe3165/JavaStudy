package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-03-16
 */
public class M0106compressString {

    public String compressString(String S) {
        int sl = S.length();
        char[] chars = S.toCharArray();
        StringBuilder res = new StringBuilder();
        int index = 0;
        int end = 0;
        while (end < sl) {
            res.append(chars[index]);
            int count = 1;
            for (int i = index; i < sl; i++) {

                if (i + 1 < sl && chars[i] != chars[i + 1]) {
                    index = i + 1;
                    end++;
                    break;
                } else if (i + 1 == sl) {
                    end++;
//                    count++;
                    break;
                } else {
                    end++;
                    count++;
                }

            }
//            if(end+count>sl){
//                break;
//            }
            res.append(String.valueOf(count));

        }
        return res.length() >= sl ? S : res.toString();


    }

    public static void main(String[] args) {
        M0106compressString m = new M0106compressString();
        String s = "bb";
        m.compressString(s);
    }
}
