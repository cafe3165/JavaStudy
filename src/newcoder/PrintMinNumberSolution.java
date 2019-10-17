package newcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumberSolution {
    public String PrintMinNumber(int[] numbers) {
        String minNum = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                System.out.println(s1);
                System.out.println(s2);
                System.out.println(s1.compareTo(s2));
                return s1.compareTo(s2);
            }
        });
        for(int j:list){
            minNum+=j;
        }

        return minNum;

    }


    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        PrintMinNumberSolution p = new PrintMinNumberSolution();
        ;
        System.out.println(p.PrintMinNumber(numbers));
    }
}
