package Real;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * Author:cafe3165
 * Date:2020-03-23
 */
public class ali_test {
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt(),L=sc.nextInt();

        List<List<Integer>> res=new ArrayList<>();
        int l=N;
        for(int i=1;i<N/2+1;i++){
            for(int j=i+L-1;j<N/2+1;j++){
                int tmp=(i+j)*(j-i+1)/2;
                if(tmp>N){
                    break;
                }else if(tmp==N&&(j-i+1<l)){
                    l=j-i+1;
                    List<Integer>TMP= new ArrayList<>();
                    for(int k=i;k<=j;k++){
                        TMP.add(k);
                    }
                    res.add(TMP);

                }else{
                    continue;
                }
            }
        }
        List<Integer>last=new ArrayList<>();
        int min=N;
        for (List<Integer> list:res){
            if(min>list.size()){
                min=list.size();
                last=list;
            }
        }

        Iterator<Integer> it=last.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
            if(it.hasNext()){
                System.out.print(" ");
            }
        }



    }
}
