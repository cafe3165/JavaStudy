package leetcode_daily.June;

import leetcode_list200.T145postorderTraversal;

/**
 * Author:cafe3165
 * Date:2020-06-15
 */
public class T14longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        T14longestCommonPrefix t = new T14longestCommonPrefix();
        t.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }
}
