package Real;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-05-19
 */
public class yuewen1 {
    public static void main(String[] args) throws ParseException {
//        2020-02-01 12:00:00
//        2020-02-01 12:01:00
        Scanner sc=new Scanner(System.in);
        String d1=sc.nextLine(),d2=sc.nextLine();


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse(d1);
        Date date2 = format.parse(d2);
        long t1=date1.getTime();
        long t2=date2.getTime();
        int minute=(int)((t2-t1)/(1000*60));
        System.out.println(minute);

    }
}
