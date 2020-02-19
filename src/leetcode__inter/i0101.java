package leetcode__inter;

/**
 * Author:cafe3165
 * Date:2020-02-19
 */
public class i0101 {
    public boolean isUnique(String astr) {
        boolean[] uni=new boolean[26];
        for (int i = 0; i < astr.length(); i++) {
            int index=astr.charAt(i)-'a';
            if(!uni[index]){
                uni[index]=true;
            }
            else{
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        i0101 I= new i0101();
        String astr="letcod";

        System.out.println(I.isUnique(astr));
    }

}
