package leetcode_daily;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-03-21
 */
public class T365canMeasureWater {


    static class state {
        public int x;
        public int y;

        public state(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {

            return x * 17 + y * 19;
        }

        @Override
        public boolean equals(Object obj) {
            //		内存地址  引用传递是否相等
            if (this == obj) {
                return true;
            }
//		空判断
            if (obj == null) {
                return false;
            }
//		判断是否同属于一个类
            if (getClass() != obj.getClass()) {
                return false;
            }

            state s = (state) obj;

            if (s.x != this.x || s.y != this.y) {
                return false;
            }
            return true;

        }


    }

    /*  初始时，队列和set均为空。将起始点放入队列及set。
      如果队列为空则 bfs 结束。
      弹出队首元素并访问其周围元素，设为 p。
      如果p为目标状态则 bfs 结束。
      访问 p 周围的元素，将不在set中的元素放入队列及set。跳转第 2 步。*/
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return x == z || y == z;
        }
        Queue<state> q = new LinkedList<>();
        Set<state> s = new HashSet<>();
        state init = new state(0, 0);
        q.offer(init);
        s.add(init);
        while (q.size() != 0) {
            state tmp = q.poll();
//            结束状态
            if (tmp.x == z || tmp.y == z || tmp.x + tmp.y == z) {
                return true;
            }
//            给X加水
            state st1 = new state(x, tmp.y);
            if (!s.contains(st1)) {
                s.add(st1);
                q.offer(st1);
            }
//            给y加水
            state st2 = new state(tmp.x, y);
            if (!s.contains(st2)) {
                s.add(st2);
                q.offer(st2);
            }
//            清空x
            state st3 = new state(0, tmp.y);
            if (!s.contains(st3)) {
                s.add(st3);
                q.offer(st3);
            }
//            清空y
            state st4 = new state(tmp.x, 0);
            if (!s.contains(st4)) {
                s.add(st4);
                q.offer(st4);
            }

//            将x->y
            ;
            state st5 = null;
            if (tmp.x + tmp.y >= y) {
                st5 = new state(tmp.x + tmp.y - y, y);
            } else {
                st5 = new state(0, tmp.x + tmp.y);
            }
            if (!s.contains(st5)) {
                s.add(st5);
                q.offer(st5);
            }


//            将y->x
            state st6 = null;
            if (tmp.x + tmp.y >= x) {
                st6 = new state(x, tmp.x + tmp.y - x);
            } else {
                st6 = new state(tmp.x + tmp.y, 0);
            }
            if (!s.contains(st6)) {
                s.add(st6);
                q.offer(st6);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        T365canMeasureWater t = new T365canMeasureWater();
//        int x = 3, y = 5, z = 4;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();

        System.out.println(t.canMeasureWater(x, y, z));

    }
}
