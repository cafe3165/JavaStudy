import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermutationSolution {
    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    private void cal(char[] chars, int i, ArrayList<String> p) {
        if (i == chars.length - 1) {
            p.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    cal(chars,i+1,p);
                    swap(chars,j,i);
                }
            }
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> p = new ArrayList<>();

        if (str != null && str.length() > 0) {
            cal(str.toCharArray(), 0, p);
            Collections.sort(p);
        }


        return p;
    }


    public static void main(String[] args) {
        String str = "abc";
        PermutationSolution p = new PermutationSolution();
        ArrayList<String> per=p.Permutation(str);
        System.out.println(per);
    }
}
