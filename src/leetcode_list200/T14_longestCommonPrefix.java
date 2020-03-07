package leetcode_list200;

public class T14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
            return "";
        }
        String prefix=strs[0];
        for (int i = 0; i < strs.length; i++) {
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length() -1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }

        return prefix;

    }

    public static void main(String[] args) {
//         ["flower","flow","flight"]
        T14_longestCommonPrefix t = new T14_longestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        t.longestCommonPrefix(strs);

    }
}
