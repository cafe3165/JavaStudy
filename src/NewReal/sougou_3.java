package NewReal;

/**
 * Author:cafe3165
 * Date:2020-09-05
 */
public class sougou_3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回生成的新密码个数
     *
     * @param password string字符串 密码的数组字符串（长度小于50），例如 12345
     * @return long长整型
     */
    private long res = 0;

    public long getPasswordCount(String password) {
        // write code here
        int[] pwds = toNums(password);
        for (int i = 0; i <= 9; i++) {
            genPwd(pwds, 1, i);
        }
        return res-1;
    }

    private void genPwd(int[] pwds, int cur, int oriNum) {
        if (cur == pwds.length) {
            res++;
            return;
        }
        int curNum = pwds[cur];
        int newNum = (curNum + oriNum) / 2;

        if (((curNum + oriNum) & 1) == 0) {
            genPwd(pwds, cur + 1,newNum );
        } else {
            genPwd(pwds, cur + 1, newNum + 1);
            genPwd(pwds, cur + 1, newNum );
        }

    }


    private int[] toNums(String pwd) {
        char[] chs = pwd.toCharArray();
        int[] nums = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            nums[i] = chs.length - '0';
        }
        return nums;
    }


    public static void main(String[] args) {
        sougou_3 s = new sougou_3();
        s.getPasswordCount("3");
    }
}
