package BST;

public class BinarySearchTree {
        class Node {
            int key;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }
        Node root;
        BinarySearchTree() {
            root = null;
        }
        void insert(int key) {
            root = insertHelper(root, key);
        }
        Node insertHelper(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }
            if (key < root.key)
                root.left = insertHelper(root.left, key);
            else if (key > root.key)
                root.right = insertHelper(root.right, key);
            return root;
        }
        void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.key+" ");
                inorder(root.right);
            }
        }
        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree();
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);
            tree.inorder(tree.root);
        }
    }
