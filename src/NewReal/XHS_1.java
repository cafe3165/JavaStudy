package NewReal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class XHS_1 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMin(int[] tree) {
        int max = -1;
        int len = tree.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, tree[i]);
        }
        boolean[] nums = new boolean[max + 1];
        for (int i = 0; i < len; i++) {
            nums[tree[i]] = true;
        }
        int res = -1;
        for (int i = 1; i <= max; i++) {
            if (!nums[i]) {
                res = i;
                break;
            }
        }
        if (res == -1) {
            return max + 1;
        } else {
            return res;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _tree_size = 0;
        _tree_size = in.nextInt();

        int[] _tree = new int[_tree_size];
        int _tree_item;
        for (int _tree_i = 0; _tree_i < _tree_size; _tree_i++) {
            _tree_item = in.nextInt();
            _tree[_tree_i] = _tree_item;
        }

        res = findMin(_tree);
        System.out.println(res);

    }
}
