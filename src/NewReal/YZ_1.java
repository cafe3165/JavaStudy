package NewReal;

/**
 * Author:cafe3165
 * Date:2020-09-11
 */
public class YZ_1 {
    /**
     * @param num     int整型 相加的数字
     * @param itemNum int整型 相加项数
     * @return long长整型
     */
    public long sum(int num, int itemNum) {
        // write code here
        long tmp = num;
        long res = 0;
        for (int i = 0; i < itemNum; i++) {
            res += tmp;
            tmp = (tmp * 10) + num;
        }
        return res;
    }

    public static void main(String[] args) {
        YZ_1 yz = new YZ_1();
        yz.sum(3, 5);
    }
}
