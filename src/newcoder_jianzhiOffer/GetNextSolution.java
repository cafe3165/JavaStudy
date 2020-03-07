package newcoder_jianzhiOffer;

public class GetNextSolution {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

//        1.右子树的最左结点
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
//

//        无右子树，
        if (pNode.right == null && pNode.next != null) {
//            2.无右子树,且为左
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
//            3.无右子树,且为右
            if (pNode.next.right == pNode) {
                TreeLinkNode pFather = pNode.next;
                while (pFather.next != null && pFather.next.right == pFather) {
                    pFather = pFather.next;
                }
                return pFather.next;
            }

        }


        return null;
    }

    public TreeLinkNode GenTree() {

//        {5,4,#,3,#,2},5
        TreeLinkNode r = new TreeLinkNode(5);
        TreeLinkNode n1 = new TreeLinkNode(4);
//        TreeLinkNode n2 = new TreeLinkNode(6);
        TreeLinkNode n3 = new TreeLinkNode(3);
//        TreeLinkNode n4 = new TreeLinkNode(3);
        TreeLinkNode n5 = new TreeLinkNode(2);
        r.left = n1;
        n1.next = r;
        n1.left = n3;
        n3.next = n1;
        n3.left = n5;
        n5.next = n3;

        return r;

    }

    public static void main(String[] args) {
        GetNextSolution g = new GetNextSolution();

        TreeLinkNode root = g.GenTree();

        System.out.println(g.GetNext(root).val);


    }
}
