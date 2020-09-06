package NewReal;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-06
 */
public class Tencent_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> maxQ = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        PriorityQueue<String> minQ = new PriorityQueue<>(k, (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(a) - map.get(b));
        for (String s : map.keySet()) {
            maxQ.offer(s);
            minQ.offer(s);
        }
        for (int i = 0; i < k; i++) {
            String s = maxQ.poll();
            System.out.print(s);
            System.out.print(" ");
            System.out.print(map.get(s));
            System.out.println();
        }
        for (int i = 0; i < k; i++) {
            String s = minQ.poll();
            System.out.print(s);
            System.out.print(" ");
            System.out.print(map.get(s));
            System.out.println();
        }

    }
}
