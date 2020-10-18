package newReal2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-27
 */
public class WYHY_3 {
    static class Node {
        String name;
        Map<String, Integer> in;

        public Node(String name) {
            this.name = name;
            this.in = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(), D = sc.nextInt();
            int[][] Data = new int[N][D + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < D + 1; j++) {
                    Data[i][j] = sc.nextInt();
                }
            }
            int M = sc.nextInt(), K = sc.nextInt();
            Map<String, Node> map = new HashMap<>();
            map.put("output", new Node("output"));
            for (int i = 0; i < M; i++) {
                sc.nextInt();
            }
            sc.nextLine();
            String[][] lines = new String[K][3];
            for (int i = 0; i < K; i++) {
                lines[i] = sc.nextLine().split(" ");
                if (!map.containsKey(lines[i][0])) {
                    map.put(lines[i][0], new Node(lines[i][0]));
                }
                if (!map.containsKey(lines[i][1])) {
                    map.put(lines[i][1], new Node(lines[i][1]));
                }
                map.get(lines[i][1]).in.put(lines[i][0], Integer.valueOf(lines[i][2]));
            }
            int lossCur = 0;
            for (int i = 0; i < N; i++) {
                lossCur += Math.abs(Data[i][Data[i].length - 1] - dnn(map.get("output"), Data[i], null, map));
            }
            int max = -1;
            for (int i = 0; i < lines.length; i++) {
                int lossNew = 0;
                for (int j = 0; j < N; j++) {
                    lossNew += Math.abs(Data[j][Data[j].length - 1] - dnn(map.get("output"), Data[j], lines[i], map));
                }
                max = Math.max(max, lossCur - lossNew);
            }
            System.out.println(max < 0 ? -1 : max);
        }


    }

    private static int dnn(Node output, int[] data, String[] line, Map<String, Node> map) {
        if (output.name.contains("input")) {
            return data[Integer.valueOf(output.name.substring(6)) - 1];
        } else {
            final int[] sum = {0};
            output.in.forEach((s, integer) -> {
                if (line == null || (!line[0].equals(s)) || !line[1].equals(output.name)) {
                    sum[0] += dnn(map.get(s), data, line, map) * integer;
                }
            });
            return sum[0];

        }
    }
}
