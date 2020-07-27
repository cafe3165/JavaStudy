package leetcode_list400;

public class T392isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si=0,ti=0;
        int slen=s.length(),tlen=t.length();
        while(si<slen&&ti<tlen){
            if(s.charAt(si)==t.charAt(ti)){
                si++;
                ti++;
            }else{
                ti++;
            }
        }
        return si==slen?true:false;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        T392isSubsequence R = new T392isSubsequence();
        R.isSubsequence(s, t);
    }
}
