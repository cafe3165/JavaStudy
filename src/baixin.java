/**
 * Author:cafe3165
 * Date:2020-05-20
 */
public class baixin {
    public static void main(String[] args) {
        for (int i = 0, k = 0; i < 14; i++) {
            if (i < 3) {
                for (int j = 0; j < 5 - 2 * i; j++) {
                    System.out.print(" ");
                }
                if (i == 2) {
                    for (int j = 0; j < 6 + 4 * i - 1; j++) {
                        System.out.print("*");
                    }
                    for (int j = 0; j < 7 - 4 * i + 2; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 6 + 4 * i - 1; j++) {
                        System.out.print("*");
                    }
                } else {
                    for (int j = 0; j < 6 + 4 * i; j++) {
                        System.out.print("*");
                    }
                    for (int j = 0; j < 7 - 4 * i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < 6 + 4 * i; j++) {
                        System.out.print("*");
                    }
                }
            } else if (i < 6) {
                for (int j = 0; j < 29; j++) {
                    System.out.print("*");
                }
            } else {
                if (i == 13) {
                    for (int j = 0; j < 2 * (i - 6); j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                } else {
                    for (int j = 0; j < 2 * (i - 6) + 1; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j < 28 - 4 * k; j++) {
                        System.out.print("*");
                    }
                    k++;
                }
            }
            System.out.println();
        }
    }
}

