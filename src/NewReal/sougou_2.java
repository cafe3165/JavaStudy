package NewReal;

/**
 * Author:cafe3165
 * Date:2020-09-05
 */
public class sougou_2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能创建的房屋数
     *
     * @param t  int整型 要建的房屋面宽
     * @param xa int整型一维数组 已有房屋的值，其中 x0 a0 x1 a1 x2 a2 ... xi ai 就是所有房屋的坐标和房屋面宽。 其中坐标是有序的（由小到大）
     * @return int整型
     */
    class House {
        double begin;
        double end;

        public House(int x, int a) {
            begin = x - (a / 2.0);
            end = x + (a / 2.0);
        }
    }


    public int getHouses(int t, int[] xa) {
        // write code here
        int len = xa.length;
        int res = 2;
        House[] hs = new House[len / 2];
        int index = 0;
        for (int i = 0; i < len; i += 2) {
            hs[index++] = new House(xa[i], xa[i + 1]);
        }
        for (int i = 0; i + 1 < hs.length; i++) {
            if (hs[i + 1].begin - hs[i].end == t) {
                res++;
            } else if (hs[i + 1].begin - hs[i].end > t) {
                res += 2;
            } else {
                continue;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        sougou_2 s = new sougou_2();
        int x = 2;
        int[] xa = {-1, 4, 5, 2};

        s.getHouses(x, xa);
    }
}
