package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-07
 */
public class Beike_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String nml = sc.next();
            String nmr = sc.next();
            String nnl = sc.next();
            String nnr = sc.next();
            String res= solve(nml,nmr,nnl,nnr);
            System.out.println(res);
        }

    }

    public static String solve(String nml, String nmr, String nnl, String nnr) {
        int[] resL = new int[2];
        int[] resR = new int[2];
        int[] rl1 = comTwo(nml, nnl);
        int[] rl2 = comTwo(nml, nnr);
        int[] rr1 = comTwo(nmr, nnl);
        int[] rr2 = comTwo(nmr, nnr);
        for (int i = 0; i < 2; i++) {
            resL[i] = rl1[i] + rl2[i];
            resR[i] = rr1[i] + rr2[i];
        }
        if (resL[0] > resR[0]) { return "left";
        } else if (resL[0] < resR[0]) { return "right";
        } else { return "same"; }
    }

    public static int[] comTwo(String nm, String nn) {
        int win = 0, los = 0;
        if (nm.equals("J")) {
            if (nn.equals("B")) { win++; } else { los++; }
        } else if (nm.equals("S")) {
            if (nn.equals("J")) { win++; } else { los++; }
        } else {
            if (nn.equals("S")) { win++; } else { los++; }
        }
        return new int[]{win, los};
    }
}
