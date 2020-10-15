package Tree;

import java.util.*;
import java.lang.*;
class Node{
    int value;
    Node left;
    int hd;
    Node right;
    Node(int d){
        value = d;
        left = null;
        hd=Integer.MAX_VALUE;
        right = null;
    }
}

class LevelOrder{
    Node root;
    public LevelOrder(Node node){
        root=node;
    }

    static void lOrder(Node root){
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            System.out.print(temp.value+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }

        }
    }

    static int height(Node root){
        if(root==null)
            return 0;
        int ldepth=height(root.left);
        int rdepth=height(root.right);
        return Math.max(ldepth,rdepth)+1;
    }
    static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.value+" ");
        inorder(root.right);

    }
    static int sumOfNodes(Node root){
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        int sum=0;
        while (!q.isEmpty()) {
            int n=q.size();

            for (int i=1;i<=n ;i++ ) {
                Node temp=q.poll();
                sum+=temp.value;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if (temp.right!=null) {
                    q.add(temp.right);
                }
            }

        }
        return sum;

    }
    public static void main(String[] args) {
        Node root=new Node(20);
        root.left=new Node(8);
        root.left.left=new Node(5);
        root.left.right=new Node(3);
        root.left.right.left=new Node(10);
        root.left.right.right=new Node(14);
        root.right=new Node(22);
        root.right.left=new Node(4);
        root.right.right=new Node(25);


        lOrder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        System.out.println(sumOfNodes(root));
    }
}