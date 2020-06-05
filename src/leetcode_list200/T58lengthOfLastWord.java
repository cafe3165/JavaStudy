package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T58lengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        char[] chs=s.trim().toCharArray();
        if(chs.length==0){
            return 0;
        }
        int cnt=0;
        for(int i=chs.length-1;i>=0;i--){
            if(chs[i]!=' '){
                cnt++;
            }else{
                break;
            }
        }
        return cnt;


    }

    public static void main(String[] args) {
        lengthOfLastWord("Hello world ");
    }
}
