package leetcode_daily.July;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/gas-station/
public class T134canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] delGas = new int[len];
        List<Integer> start = new ArrayList<>();
        for (int i = 0, j = len - 1; i < len; i++, j++) {
            delGas[i] = gas[i] - cost[j % len];
            if (gas[i] >= cost[i]) {
                start.add(i);
            }
        }
        for (Integer s : start) {
            boolean res = Go(s, len, delGas, gas,cost);
            if (res) {
                return s;
            }
        }
        return -1;

    }

    //        -1 -1 -1 -1 4
    public boolean Go(int start, int len, int[] delGas, int [] gas,int[] cost) {
        int curGas=gas[start];
        for (int i = (start + 1) % len, count = 0; count < len; count++, i = (i + 1) % len) {
            curGas += delGas[i];
            if (curGas < 0||curGas<cost[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
//        int[] gas = {2};
//        int[] cost = {2};
        T134canCompleteCircuit t = new T134canCompleteCircuit();
        t.canCompleteCircuit(gas, cost);
    }
}
