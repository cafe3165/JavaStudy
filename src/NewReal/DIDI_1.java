package NewReal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-21
 */
public class DIDI_1 {

    static class num {
        int num1;
        int num2;

        public num(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public void print() {
            System.out.println(num1 + " " + num2);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] n1 = new boolean[10];

        List<num> numList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            n1[i] = true;
            for (int j = 0; j <= 9; j++) {
                if (n1[j]) {
                    continue;
                }
                n1[j] = true;
                for (int k = 0; k <= 9; k++) {
                    if (n1[k]) {
                        continue;
                    }
                    int num1 = i * 100 + j * 10 + k;
                    int num2 = i * 100 + k * 10 + k;
                    if (sum(n, num1, num2)) {
                        numList.add(new num(num1, num2));
                    }
                }
                n1[j] = false;
            }
            n1[i] = false;
        }
        numList.sort(Comparator.comparingInt(o -> o.num1));
        if (numList.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(numList.size());
            for (int i = 0; i < numList.size(); i++) {
                numList.get(i).print();
            }
        }

    }


    public static boolean sum(int n, int num1, int num2) {
        if (num1 + num2 == n) {
            return true;
        }
        return false;
    }
}
