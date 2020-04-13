package Real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-11
 */
public class duInterview_1 {


    static class IP {
        public Long start;
        public Long end;
        public String city;

        public IP(Long start, Long end, String city) {
            this.start = start;
            this.end = end;
            this.city = city;
        }
    }

    public static String binarySearch(List<IP> iplist, Long ip) {
        int R = iplist.size() - 1,L = 0;
        while (L < R) {
            int mid = (R + L) / 2;
            if (ip > iplist.get(mid).end) {
                L = mid + 1;
                continue;
            }
            if (ip < iplist.get(mid).start) {
                R = mid - 1;
                continue;
            }
            if (ip >= iplist.get(mid).start && ip <= iplist.get(mid).end) {
                return iplist.get(mid).city;
            }
        }
        return "no";
    }


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        // System.out.println("Hello World!");
        List<IP> iplist = new ArrayList<>();
        iplist.add(new IP(new Long("25525400000001"), new Long("25525400000123"), "beijing"));
        iplist.add(new IP(new Long("25525400000200"), new Long("25525400000220"), "shanghai"));
        iplist.add(new IP(new Long("25525400010001"), new Long("25525400010123"), "chengdu"));
        iplist.add(new IP(new Long("25525401010001"), new Long("25525402010123"), "chongqing"));

        Scanner sc=new Scanner(System.in);

        Long ip = new Long("25525500010012");
        binarySearch(iplist, ip);
        //  Scanner sc=new Scanner(System.in);
        // for(){
        //      String ip=sc.next();
        //long Sip=sip.replace()
        //}


    }

}
