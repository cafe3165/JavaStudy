package Real;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;


/**
 * Author:cafe3165
 * Date:2020-03-18
 */
public class netETest {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        System.out.println(solution(n, k));


    }

    public static long solution(int n, int k) {


        return 0;

    }
}
