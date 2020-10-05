package NewReal;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-23
 */
public class qunar_3 {
    static boolean isHuangjia = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] cards = new String[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.next();
        }
        if (isShunzi(cards) && isTonghua(cards)) {
            if (isHuangjia) {
                System.out.println("HuangJiaTongHuaShun");
            } else {
                System.out.println("TongHuaShun");
            }
        } else if (isSitiao(cards)) {
            System.out.println("SiTiao");
        } else if (isHulu(cards)) {
            System.out.println("HuLu");
        } else if (isTonghua(cards)) {
            System.out.println("TongHua");
        } else if (isShunzi(cards)) {
            System.out.println("ShunZi");
        } else if (isSantiao(cards)) {
            System.out.println("SanTiao");
        } else if (isYidui(cards)) {
            System.out.println("YiDui");
        } else {
            System.out.println("GaoPai");
        }

    }

    private static boolean isTonghua(String[] cards) {
        int len = cards.length;
        if (len < 5) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            if (cards[i].charAt(0) != cards[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isShunzi(String[] Cards) {
        int len = Cards.length;
        if (len < 5) {
            return false;
        }
        String[] cards = getNum(Cards, len);
        Arrays.sort(cards);
        if (cards[0].equals("1")) {
            for (int i = 1; i < 4; i++) {
                if (Integer.parseInt(cards[i + 1]) - Integer.parseInt(cards[i]) != 1) {
                    return false;
                }
            }
            isHuangjia = true;
        } else {
            for (int i = 0; i < 4; i++) {
                if (Integer.parseInt(cards[i + 1]) - Integer.parseInt(cards[i]) != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static String[] getNum(String[] Cards, int n) {
        String[] cards = new String[n];
        for (int i = 0; i < n; i++) {
            String card = Cards[i];
            if (card.substring(1).equals("A")) {
                cards[i] = "1";
            } else if (card.substring(1).equals("K")) {
                cards[i] = "13";
            } else if (card.substring(1).equals("Q")) {
                cards[i] = "12";
            } else if (card.substring(1).equals("J")) {
                cards[i] = "11";
            } else {
                cards[i] = Cards[i].substring(1);
            }
        }
        return cards;
    }

    private static boolean isSitiao(String[] Cards) {
        int len = Cards.length;
        if (len < 4) {
            return false;
        }
        String[] cards = getNum(Cards, len);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHulu(String[] Cards) {
        int len = Cards.length;
        if (len != 5) {
            return false;
        }
        String[] cards = getNum(Cards, len);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) < 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSantiao(String[] Cards) {
        int len = Cards.length;
        if (len != 5) {
            return false;
        }
        String[] cards = getNum(Cards, len);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isYidui(String[] Cards) {
        int len = Cards.length;
        if (len < 2) {
            return false;
        }
        String[] cards = getNum(Cards, len);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                return true;
            }
        }
        return false;
    }

}
