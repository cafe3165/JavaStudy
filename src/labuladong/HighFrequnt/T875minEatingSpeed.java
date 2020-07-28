package labuladong.HighFrequnt;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T875minEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {

        int len = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }

        }

        for (int i = 1; i <= max; i++) {
            if (canEat(i, piles, H)) {
                return i;
            }
        }

        return 0;
    }

    private boolean canEat(int minEat, int[] Piles, int H) {
        int index = 0;

        int[] piles = new int[Piles.length];
        System.arraycopy(Piles, 0, piles, 0, Piles.length);
        while (index < piles.length && H > 0) {
            if (piles[index] > 0) {
                piles[index] -= minEat;
                H--;
            } else if(index<piles.length-1){
                index++;
            }
        }

        if (index < piles.length - 1 || piles[index] > 0) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        T875minEatingSpeed t = new T875minEatingSpeed();
        int[] piles = {312884470};


        int H = 312884469;
        t.minEatingSpeed(piles, H);
    }
}
