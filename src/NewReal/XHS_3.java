package NewReal;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class XHS_3 {
    static class Box {
        int l;
        int w;
        int h;

        public Box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Box> boxList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            boxList.add(new Box(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int res = 0;
        res = Math.max(res, solve(boxList,false));

        System.out.println(res);
    }
    private static void swap(List<Box> boxList){
        for (int i = 0; i < boxList.size(); i++) {
            Box box = boxList.get(i);
            int tmp = box.h;
            box.h = box.l;
            box.l = box.w;
            box.w = tmp;
        }
    }
    private static boolean jude(List<Box> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i).l==list.get(i+1).l){
                Box box = list.get(i);
                int tmp = box.h;
                box.h = box.l;
                box.l = box.w;
                box.w = tmp;
                return false;
            }
            if(list.get(i).w==list.get(i+1).w){
                Box box = list.get(i);
                int tmp = box.h;
                box.h = box.l;
                box.l = box.w;
                box.w = tmp;
                return false;
            }
        }
        return true;
    }

    private static int solve(List<Box> list,boolean f) {
        while(!f){
            Collections.sort(list, (o1, o2) -> {
                if (o1.l < o2.l) {
                    return o1.l - o2.l;
                }
                else {
                    return o1.w - o2.w;
                }
            });
            f=jude(list);
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).h;
        }
        return res;
    }
}
