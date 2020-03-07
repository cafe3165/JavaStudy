package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-03-05
 */
public class M1103distributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
//        p是 完整获得礼物的次数 就是等差数列的项数
        int[] dis = new int[num_people];
//        0≤C−p(p+1)/2​<p+1 剩余糖果数量大于等于 000，小于下一份礼物数量 p+1p + 1p+1。
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p * 0.5);
        int rows = p / num_people;
//        看不完整的分配发生在哪一行
        int cols = p % num_people;
        for (int i = 0; i < num_people; i++) {
//            dis[i]=i+(i+N)+...+i+(rows-1)*num_people;
            dis[i] = (int) ((rows * (i + 1)) + rows * (rows - 1) * num_people * 0.5);
//           最后一行前cols个还能完整分配
            if (i < cols) {
                dis[i]+=(i+1)+rows*num_people;
            }
        }
        dis[cols]+=remaining;

        System.out.println(p);
        return dis;
    }

    public static void main(String[] args) {
        int candies = 29, num_people = 3;
        M1103distributeCandies m = new M1103distributeCandies();
        m.distributeCandies(candies, num_people);
    }

}
