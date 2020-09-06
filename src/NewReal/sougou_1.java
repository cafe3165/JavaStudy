package NewReal;

/**
 * Author:cafe3165
 * Date:2020-09-05
 */
public class sougou_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     *
     * @param a int整型
     * @param b int整型
     * @param c int整型
     * @return int整型
     */
    public int numberofprize(int a, int b, int c) {
        // write code here
        int res = 0;
        int[] nums = {a, b, c};
        while(jude(nums)){
            rsort(nums);
            res += sum(nums);
            cal(nums);
        }


        return res;
    }
    private void cal(int[] nums){
        if(nums[0]>2){
            nums[2]++;
            nums[0]-=2;
            return ;
        }
        if(nums[0]>1&&nums[1]>1){
            nums[0]--;
            nums[1]--;
            nums[2]++;
            return ;
        }
    }

    private boolean jude(int[] nums){
        if(nums[0]==1&&nums[1]==1&&nums[2]==1){
            return true;
        }
        if(nums[0]+nums[1]+nums[2]<4){
            return false;
        }
        return true;
    }

    private int sum(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        return min;
    }

    private void rsort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }


    public static void main(String[] args) {
        sougou_1 s = new sougou_1();
        System.out.println(s.numberofprize(4, 4, 2));
    }
}
