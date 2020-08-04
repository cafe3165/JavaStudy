package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-08-01
 */
public class yuanfudao_2 {
    public static int max=Integer.MIN_VALUE;
    static class Node {
        public int value;
        public int no;
        public int parent;
        public Node next;
        public Node(int value,int parent){
            this.value=value;
            this.parent=parent;
        }
    }
    Queue<Node> queue=new ArrayDeque<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            Node node=new Node(sc.nextInt(),sc.nextInt());
            nodes[i]=node;
            node.no=i;
        }
        for (int i = 0; i < N; i++) {
            Node curNode=nodes[i];
            if(curNode.parent!=0){
                nodes[curNode.parent-2].next=curNode;
            }
        }

        for (int i = 0; i < N; i++) {
            max=Math.max(max,solve(nodes[i],0));
        }
    }

    public static int solve(Node node,int cur){
        cur+=node.value;
//        for ()



            return 0;


    }

}
