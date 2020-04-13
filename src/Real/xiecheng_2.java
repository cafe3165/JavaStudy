package Real;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-01
 */
public class xiecheng_2 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calcMinStaff(int n, call[] cls) {
        int count = n, people = 0, peopleuse = 0;
        while (count > 0) {
            for (int i = 1; i <= n; i++) {
                if ((cls[i].big >= peopleuse) && (!cls[i].f)) {
                    peopleuse = cls[i].end;
                    cls[i].f = true;
                    count--;
                }
            }
            peopleuse = 0;
            people++;
        }
        return people;
    }

    /******************************结束写代码******************************/
    public static class call {
        int big;
        int end;
        boolean f;

        public call(int big, int end, boolean f) {
            this.big = big;
            this.end = end;
            this.f = f;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int n = in.nextInt();
        call[] cls = new call[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] tmp = in.next().split(",");
            int b = Integer.parseInt(tmp[0]), e = Integer.parseInt(tmp[1]);

            cls[i] = new call(b, e, false);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (cls[i].end > cls[j].end) {
                    call tmpcall = cls[i];
                    cls[i] = cls[j];
                    cls[j] = tmpcall;
                }
            }
        }
  /*    6
        0,30
        0,50
        10,20
        15,30
        20,50
        20,65
        */
        res = calcMinStaff(n, cls);
        System.out.println(res);
    }
}
