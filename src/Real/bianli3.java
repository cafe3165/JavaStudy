package Real;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-10
 */
public class bianli3 {
    static class gao {
        String name;
        public gao s;
        public gao n;
        public gao e;
        public gao w;

        public gao(String name) {
            this.name = name;

        }

        public void set(gao s, gao n, gao e, gao w) {
            this.s = s;
            this.n = n;
            this.e = e;
            this.w = w;
        }
    }

    public static gao gen() {
        gao NONGSHE = new gao("NONGSHE");
        gao CUNKOU = new gao("CUNKOU");
        NONGSHE.w = CUNKOU;
        CUNKOU.e = NONGSHE;
        gao TULU = new gao("TULU");
        CUNKOU.n = TULU;
        TULU.s = CUNKOU;
        gao DAOTIAN = new gao("DAOTIAN");
        TULU.n = DAOTIAN;
        DAOTIAN.s = TULU;
        gao DAOTIAN1 = new gao("DAOTIAN1");
        gao TULU1 = new gao("TULU1");
        TULU1.n = DAOTIAN1;
        DAOTIAN.n = TULU1;
        DAOTIAN1.s = TULU1;
        TULU1.s = DAOTIAN;

        gao TULU2 = new gao("TULU2");
        TULU1.e = TULU2;
        TULU2.w = TULU1;
        gao JIEDAO = new gao("JIEDAO");
        TULU2.e = JIEDAO;
        JIEDAO.w = TULU2;
        gao LIUJIABUDIAN = new gao("LIUJIABUDIAN");
        gao TIEPU = new gao("TIEPU");
        JIEDAO.n = LIUJIABUDIAN;
        LIUJIABUDIAN.s = JIEDAO;
        JIEDAO.s = TIEPU;
        TIEPU.n = JIEDAO;
        gao JIEDAO1 = new gao("JIEDAO1");
        JIEDAO.e = JIEDAO1;
        JIEDAO1.w = JIEDAO;
        gao XIAOJIUGUAN = new gao("XIAOJIUGUAN");
        JIEDAO1.s = XIAOJIUGUAN;
        XIAOJIUGUAN.n = JIEDAO1;//
        gao GAOJIADAYUAN = new gao("GAOJIADAYUAN");
        JIEDAO1.e = GAOJIADAYUAN;
        GAOJIADAYUAN.w = JIEDAO1;
        gao JIEDAO2 = new gao("JIEDAO2");
        GAOJIADAYUAN.e = JIEDAO2;
        JIEDAO2.w = GAOJIADAYUAN;
        gao TULU3 = new gao("TULU3");
        JIEDAO2.e = TULU3;
        TULU3.w = JIEDAO2;
        gao QINGSHILU = new gao("QINGSHILU");
        TULU3.e = QINGSHILU;
        QINGSHILU.w = TULU3;


        gao ZHENGYUAN = new gao("ZHENGYUAN");
        GAOJIADAYUAN.n = ZHENGYUAN;
        ZHENGYUAN.s = GAOJIADAYUAN;
        gao ZHANGFANG = new gao("ZHANGFANG");
        gao PIANFANG = new gao("PIANFANG");
        ZHENGYUAN.w = ZHANGFANG;
        ZHENGYUAN.e = PIANFANG;
        PIANFANG.w = ZHENGYUAN;
        ZHANGFANG.e = ZHENGYUAN;

        gao ZHENGTING = new gao("ZHENGTING");
        ZHENGYUAN.n = ZHENGTING;
        ZHENGTING.s = ZHENGYUAN;
        gao PIANTING = new gao("PIANTING");
        gao FANTING = new gao("FANTING");
        ZHENGTING.e = FANTING;
        FANTING.w = ZHENGTING;
        ZHENGTING.w = PIANTING;
        PIANTING.e = ZHENGTING;

        gao HOUYUAN = new gao("HOUYUAN");
        ZHENGTING.n = HOUYUAN;
        HOUYUAN.s = ZHENGTING;
        gao GUIGE = new gao("GUIGE");
        gao XIYIFANG = new gao("XIYIFANG");
        gao HUAYUAN = new gao("HUAYUAN");
        HOUYUAN.n = HUAYUAN;
        HUAYUAN.s = HOUYUAN;
        HOUYUAN.e = XIYIFANG;
        XIYIFANG.w = HOUYUAN;
        HOUYUAN.w = GUIGE;
        GUIGE.e = HOUYUAN;


        gao YASHI = new gao("YASHI");
        GUIGE.n = YASHI;
        YASHI.s = GUIGE;

        return NONGSHE;
    }
//    public  static boolean vis1[][]
    public static void solve(gao root, String sun, String zhu) {
        Queue<gao> q = new LinkedList<>();
        q.offer(root);
        gao s = null;
        gao z = null;
        while (!q.isEmpty()) {
            gao tmp = q.poll();
            if (tmp.name.equals(sun)) {
                s = tmp;
            }
            if (tmp.name.equals(zhu)) {
                z = tmp;
            }
            if(tmp.e!=null)
            {q.add(tmp.e);}
            if(tmp.w!=null)
            {q.add(tmp.w);}
            if(tmp.n!=null)
            {q.add(tmp.n);}
            if(tmp.s!=null)
            {q.add(tmp.s);}
        }

        System.out.println(s.name+" "+z.name);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        CUNKOU,GUIGE
        String[] des = sc.next().split(",");
        gao root = gen();
        solve(root, des[0], des[1]);
//        System.out.println(root.name);
//        System.out.println("north","north","north","east","east"
//                ,"east","east","north","north","north","west");
    }
}
