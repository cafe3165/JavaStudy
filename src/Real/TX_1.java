package Real;

/**
 * Author:cafe3165
 * Date:2020-08-06
 */
public class TX_1 {

    static class Node{
        int data;
        Node next;
        public Node (int data){
            this.data=data;
        }
    }


    public static void main(String[] args) {
        Node root=new Node(-1);
        Node p=root;
        for(int i=0;i<5;i++){
            Node tmp=new Node(i);
            p.next=tmp;
            p=p.next;
        }

        Node q=ListReverse(root);

        while(q!=null){
            System.out.println(q.data);
            q=q.next;
        }

    }
    public static Node ListReverse(Node node){
        Node pre=null;
        Node cur=node;
        while(cur!=null){
            Node tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }
}
