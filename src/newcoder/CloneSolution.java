package newcoder;

public class CloneSolution {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return pHead;
        }
        RandomListNode Head = pHead;

//        1.复制
        while (pHead != null) {
            RandomListNode tmp = new RandomListNode(pHead.label);
            tmp.next = pHead.next;
            pHead.next = tmp;
            pHead = pHead.next.next;
        }

//        2.random复制
        pHead = Head;
        RandomListNode newHead = pHead.next;
        RandomListNode pHead2 = newHead;
        while (pHead != null) {
            if (pHead.random != null) {
                pHead2.random = pHead.random.next;
            }

            pHead = pHead.next.next;
            if (pHead != null) {
                pHead2 = pHead.next;
            }
        }

//        3.拆分
        pHead = Head;
        pHead2 = newHead;
        while (pHead != null) {
            pHead.next=pHead.next.next;
            pHead=pHead.next;
            if(pHead != null){
                pHead2.next = pHead2.next.next;
                pHead2=pHead2.next;
            }

        }

//        System.out.println();
        return newHead;

    }

    public RandomListNode Gen() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n3;
        n2.random = n5;
        n4.random = n2;

        return n1;
    }


    public static void main(String[] args) {

        CloneSolution c = new CloneSolution();
        RandomListNode node = c.Gen();
        c.Clone(node);

    }
}
