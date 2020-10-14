package newReal2;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-10-13
 */
public class XieCheng_1 {
    static class SellMachine {
        int count = 0;
        int price;
        int cur = 0;

        public SellMachine(int price) {
            this.price = price;
        }

        public void in(int money) {
            cur += money;
            count++;
        }

        public boolean buy() {
            if (!isEnough()) {
                return false;
            }
            cur -=  price;
            return true;
        }

        public boolean isEnough() {
            return cur >= price;
        }

        public int[] returnMoney() {
            int b = cur / 50;
            int c = (cur - b * 50) / 10;
            cur = 0;
            return new int[]{0, b, c};

        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int c = sc.nextInt(), b = sc.nextInt(), a = sc.nextInt();

        int x = sc.nextInt();

        int[] change = {a, b, c};
        int[] money = {100, 50, 10};
        //int all = m * x;
        SellMachine sm = new SellMachine(x);
        int cola = 0;
        while (cola != m) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < change[i]; j++) {
                    sm.in(money[i]);
                    while (sm.buy()) {
                        cola++;
                        if (cola == m) {
                            break;
                        }
                    }
                    if (cola == m) {
                        break;
                    }
                }
                if (cola == m) {
                    break;
                }

                int[] newchange = sm.returnMoney();
                change[1] += newchange[1];
                change[2] += newchange[2];
            }
        }
        System.out.println(sm.count);
    }
}
