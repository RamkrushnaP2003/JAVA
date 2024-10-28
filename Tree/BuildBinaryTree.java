import java.util.*;

public class BuildBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public Node buildTree2(int arr[]) {
            Node root = new Node(arr[0]);
            int i = 1;
            while(i < arr.length) {
                root.left = new Node(arr[i++]);
                root.right = new Node(arr[i++]);
            }
            return root;
        }
        
        public void preorder(Node root) {
            if(root == null) {
                // System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public void inorder(Node root) {
            if(root == null) {
                // System.out.print(-1 +" ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public void postorder(Node root) {
            if(root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public void levelorder(Node root) {
            if(root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int heightOfTree(Node root) {
            if(root == null) return 0;
            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            return Math.max(lh, rh)+1;
        }

        public int countNodes(Node root) {
            if(root == null) return 0;
            int left= countNodes(root.left);
            int right= countNodes(root.right);
            return left + right + 1;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("PreOrder");
        tree.preorder(root);
        System.out.println();
        System.out.println("InOrder");
        tree.inorder(root);
        System.out.println();
        System.out.println("PostOrder");
        tree.postorder(root);
        System.out.println();
        System.out.println("Level Order");
        tree.levelorder(root);
        System.out.println("Height of tree : "+tree.heightOfTree(root));
        System.out.println("Height of tree : "+tree.countNodes(root));
    }
}