package leetcode;

public class T6_convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len=s.length();
        int cycle=2*numRows-2;
        for (int i = 0; i < numRows; i++) {
            for(int j=0;i+j<len;j+=cycle){
                sb.append(s.charAt(i+j));
                if(i>0&&i<numRows-1&&j+cycle-i<len){
                    sb.append(s.charAt(j+cycle - i));
                }
            }
        }
        return sb.toString();


    }

    public static void main(String[] args) {
        T6_convert t = new T6_convert();
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(t.convert(s, numRows));
//        LCIRETOESIIGEDHN
//        LCIRETOESIIGEDHN
//        LCIRETOESIIGEEDDHHNN
    }

}
