package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-03-18
 */
public class T836isRectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean x_over = !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2]);
        boolean y_over = !(rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);


        return x_over && y_over;
    }

    public static void main(String[] args) {
        int[] rec1 = {0, 0, 1, 1}, rec2 = {1, 0, 2, 1};
        T836isRectangleOverlap t = new T836isRectangleOverlap();
        t.isRectangleOverlap(rec1, rec2);
    }

}
