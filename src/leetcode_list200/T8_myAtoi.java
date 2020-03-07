package leetcode_list200;

public class T8_myAtoi {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
//        删除空白符
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
//        判断符号
        int sign = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        }
        if (ch == '-') {
            sign = -1;
            i++;
        }
//        找数字部分
        int res=0;
        for(;i<str.length();i++){
            ch= str.charAt(i);
            if(ch<'0'||ch>'9'){
                break;
            }
            if(sign>0){
                if(res>Integer.MAX_VALUE/10){
                    return Integer.MAX_VALUE;
                }
                if(res==Integer.MAX_VALUE /10&&ch-'0'>Integer.MAX_VALUE %10){
                    return Integer.MAX_VALUE;
                }
            }else{
                if(-res<Integer.MIN_VALUE/10){
                    return Integer.MIN_VALUE;
                }
                if(-res== Integer.MIN_VALUE /10&&-(ch-'0')<Integer.MIN_VALUE%10){
                    return Integer.MIN_VALUE;
                }
            }
            res=res*10+ch-'0';


        }

        return res*sign;


    }

    public static void main(String[] args) {
        T8_myAtoi t = new T8_myAtoi();
        String str1 = "   -42", str2 = "4193 with words";
        String str3 = "words and 987", str4 = "-91283472332";
        t.myAtoi(str1);
    }
}
