package Real;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-04-26
 */
public class tencent4 {
    public static class queue{
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        public void add(int x){
            s1.push(x);
        }
        public void poll(){
            if(s2.size()==0){
                while(s1.size()>0){
                    s2.push(s1.pop());
                }
            }
            s2.pop();
        }
        public int peek(){
            if(s2.size()==0){
                while(s1.size()>0){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }


    }




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        queue q=new queue();
        for (int i = 0; i < n; i++) {
            String op=sc.next();
            if(op.equals("add")){
                q.add(sc.nextInt());
            }else if(op.equals("poll")){
                q.poll();
            }else{
                System.out.println(q.peek());
            }
        }
    }
}
