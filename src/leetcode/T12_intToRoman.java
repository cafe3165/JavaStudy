package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class T12_intToRoman {
    public String intToRoman2(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        String[] str = new String[100];
        int[] nums = new int[100];
        int index = 0;
//        1994 MCMXCIX
        while (num > 0) {
            nums[index] = num % 10;
            num /= 10;
            index++;
        }
        for (int i = index - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                nums[i] *= 10;
            }
            sb.append(map.get(nums[i]));

        }


        return sb.toString();
    }

    public String intToRoman(int num) {
        int[] moneys = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] moneyToStr = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num>0){
            if(num>=moneys[index]){
                sb.append(moneyToStr[index]);
                num-=moneys[index];
//                index++;
            }else{
                index++;
            }


//            System.out.println(sb.toString());

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 3;
        T12_intToRoman t = new T12_intToRoman();
        t.intToRoman(num);

    }
}
