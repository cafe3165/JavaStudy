package newcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseSentenceSolution {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String Res = "";
        String[] res = str.split(" ");

        List<String > sl=new ArrayList<>();
        for (String s :
                res) {
            sl.add(s);
        }
        Collections.reverse(sl);
        for (String s :
                sl) {
            Res += s;
            Res+=" ";
        }

        return Res.trim();
    }

    public static void main(String[] args) {
        ReverseSentenceSolution r = new ReverseSentenceSolution();
        String str = " ";

        System.out.println(r.ReverseSentence(str));
    }
}
