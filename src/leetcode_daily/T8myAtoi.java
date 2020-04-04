package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class T8myAtoi {
    //如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
    //假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
    //该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。


//    public int myAtoi(String str) {
//        char[] chs = str.toCharArray();
//        int len = chs.length;
//        if (len == 0) {
//            return 0;
//        }
//        long num = 0L;
//        List<Integer> numlist = new ArrayList<>();
//        boolean neg = false;
////        初始检查
//        int i;
//        int sig=0;
//        for (i = 0; i < len; i++) {
//            if(chs[i] > '0'&& chs[i] < '9'){
//                break;
//            }
//            if (chs[i] == ' ') {
//                continue;
//            }
//
//            if ((chs[i] < '0' || chs[i] > '9')&&(chs[i]!='-'&&chs[i]!='+')) {
////
//                return 0;
//            }
//            if(chs[i]=='+'||chs[i]=='-'){
//                sig++;
//            }
//            if (chs[i] == '-') {
//                neg = true;
//                break;
//            }
//        }
////        为空
//        if (i == len||sig>1) {
//            return 0;
//        }
////找数字
//
//        for (int j = i; j < len; j++) {
//            if((!neg)&&(chs[j]=='+'||chs[j]=='-')){
//                return 0;
//            }
//            if(chs[j] >= '0'&& chs[j] <= '9'){
//                numlist.add(chs[j] - '0');
//                continue;
//            }
//            if((!neg)&&(chs[j]=='+'||chs[j]=='-')){
//                return 0;
//            }
//            if(chs[j]==' '||chs[j]=='.'){
//                break;
//            }
//
//
//        }
//        long w = 1;
//        for (int j = numlist.size() - 1; j >= 0; j--) {
//            num += numlist.get(j) * w;
//            w *= 10;
//        }
//
//
//        if(neg) {
//            num=-num;
//        }
//        if(num>Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//        if(num<Integer.MIN_VALUE){
//            return Integer.MIN_VALUE;
//        }
//
//        return (int) num;
//    }

    public int myAtoi(String str) {
        if(str==null){
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
        T8myAtoi t = new T8myAtoi();
//        String str = "4193 with words";
        String str = " -+1";
        t.myAtoi(str);
    }
}
