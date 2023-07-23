package com.example.m;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2023-03-25
 */
public class Hw_1 {
    public static Map<String, Integer> validUnitMap = new HashMap<String, Integer>(){{
        put("HKD", 0);
        put("CNY", 1);
        put("USD", 2);
        put("GBP", 3);
    }};
    public static Set<String> validOperateSet = new HashSet<String>(){{
        add("MAX");
        add("MIN");
    }};

    public static int[] change = new int[4];
    public static int[] res = new int[4];

    public static final String ERROR = "ERROR";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cnyStr = sc.next();
        if (!validNum(cnyStr)) {
            System.out.println(ERROR);
        }
        String usdStr = sc.next();
        if (!validNum(usdStr)) {
            System.out.println(ERROR);
        }
        String gbpStr = sc.next();
        if (!validNum(gbpStr)) {
            System.out.println(ERROR);
        }
        String currStr = sc.next();
        if (!validNum(currStr)) {
            System.out.println(ERROR);
        }

        String sUnitStr = sc.next();
        if (!validUnit(sUnitStr)) {
            System.out.println(ERROR);
        }
        String opStr = sc.next();
        if (!validOperate(opStr)) {
            System.out.println(ERROR);
        }

        int cny = Integer.parseInt(cnyStr);
        int usd = Integer.parseInt(usdStr);
        int gbp = Integer.parseInt(gbpStr);
        change[0] = 1;
        change[1] = cny;
        change[2] = usd * cny;
        change[3] = gbp * usd * cny;

        int curr = Integer.parseInt(currStr);
        if (sUnitStr.equals("CNY")) {
            curr = curr * change[1];
        }
        if (sUnitStr.equals("USD")) {
            curr = curr * change[2];
        }
        if (sUnitStr.equals("GBP")) {
            curr = curr * change[3];
        }

        if ("MAX".equals(opStr)) {
            calMax(curr);
        } else {
            calMin(curr);
        }
    }

    private static void calMax(int curr) {

        int cur = curr;
        for (int i = 3; i >= 0; i--) {
            int c = cur / change[i];
            int d = cur % change[i];
            res[i] = c;
            if (d == 0) {
                break;
            }
            cur = d;
        }
        printRes();
    }

    private static void calMin(int curr) {

        int cur = curr;
        for (int i = 0; i < change.length; i++) {
            int c = cur / change[i];
            int d = cur % change[i];
            res[i] = c;
            if (d == 0) {
                break;
            }
            cur = d;
        }
        printRes();
    }

    private static void printRes() {
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[]{
                "HKD","CNY","USD","GBP"
        };
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] == 0) {
                continue;
            }
            sb.append(res[i]).append(" ").append(strings[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }



    private static boolean validNum(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        char[] chs = num.toCharArray();
        for (char ch : chs) {
            if (ch == '-' || ch == '.') {
                return false;
            }
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean validUnit(String unit) {
        if (unit == null || unit.length() == 0) {
            return false;
        }
        return validUnitMap.containsKey(unit);
    }
    private static boolean validOperate(String operate) {
        if (operate == null || operate.length() == 0) {
            return false;
        }
        return validOperateSet.contains(operate);
    }
}
