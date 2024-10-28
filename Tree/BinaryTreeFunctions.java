import java.util.*;

public class BinaryTreeFunctions {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int heightOfTree(Node root) {
        if(root == null) return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh, rh) + 1;
    }

    // time complexity -> O(n^2)
    public static int diameter(Node root) {
        if(root == null) return 0;
        int leftDiam = diameter(root.left);
        int leftHt = heightOfTree(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = heightOfTree(root.right);
        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
    }

    // Using recursion
    public static int countNodes(Node root) {
        if(root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    // Without recution
    public static int countNode(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int count = 0;
        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                count++;
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return count;
    }

    // Using recursion
    public static int sumOfNodes(Node root) {
        if(root == null) return 0;
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.data;
    }

    // Without recursion
    public static int sumOfNode(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum = 0;
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                sum += currNode.data;
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return sum;
    }

    static class Info {
        int height;
        int diameter;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // time complexity - O(n)
    public static Info Diameter(Node root) {
        if(root == null) return new Info(0, 0);
        Info leftInfo = Diameter(root.left);
        Info rightInfo = Diameter(root.right);
        int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height+rightInfo.height+1);
        int ht = Math.max(leftInfo.height, rightInfo.height)+1;
        return new Info(diam, ht);
    }
    static int diam;
    public static int Diameter2(Node root) {
        if(root == null) return 0;
        int left = Diameter2(root.left);
        int right = Diameter2(root.right);
        diam = Math.max(diam, left+right);
        return Math.max(left, right)+1;
    }

    static int max = Integer.MIN_VALUE;
    public static int maxSum(Node root) {
        if(root == null) return 0;
        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right) ,0);
        max = Math.max(max, left+right+root.data);
        return Math.max(left, right)+root.data;
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if(root == null) return false;
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null) return true;
        else if(node == null || subRoot == null || node.data != subRoot.data) return false;
        if(!isIdentical(node.left, subRoot.left)) return false;
        if(!isIdentical(node.right, subRoot.right)) return false;
        return true;
    }

    public static int maxi = Integer.MIN_VALUE;
    public static int maxPathSum(Node root) {
        if(root == null) return 0;
        int leftSum = Math.max(0, maxPathSum(root.left));
        int rightSum = Math.max(0, maxPathSum(root.right));
        maxi = Math.max(maxi, leftSum + rightSum + root.data);
        return root.data + Math.max(leftSum, rightSum);
    }
    static class Info2 {
        Node node;
        int hd;
        
        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topViewOfTree(Node root) {
        if(root == null) return;
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Info2(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            Info2 currInfo2 = q.remove();
            if(currInfo2 == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(currInfo2.hd)) {
                    map.put(currInfo2.hd, currInfo2.node);
                }
                if(currInfo2.node.left != null) {
                    q.add(new Info2(currInfo2.node.left, currInfo2.hd-1));
                    min = Math.min(min, currInfo2.hd-1);
                }
                if(currInfo2.node.right != null) {
                    q.add(new Info2(currInfo2.node.right, currInfo2.hd+1));
                    max = Math.max(max, currInfo2.hd+1);
                }
            }
        }
        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    } 

    public static ArrayList<Integer> KthLevelTree2(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curNode = q.remove();
            if(curNode == null) {
                k--;
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(k==1) {
                    ans.add(curNode.data);
                }
                if(curNode.left != null) {
                    q.add(curNode.left);
                }
                if(curNode.right != null) {
                    q.add(curNode.right);
                }
            }
        }
        return ans;
    }

    static List<Integer> ans = new ArrayList<>();
    public static List<Integer> KthLevelTree(Node root, int level, int k) {
        if(root == null) return null;
        if(level == k) {
            ans.add(root.data);
            return ans;
        }
        KthLevelTree(root.left, level+1, k);
        KthLevelTree(root.right, level+1, k);
        return ans;
    }

    public static int leftLeaveSum(Node root, boolean isLeft) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return isLeft ? root.data : 0;
        }
        int left = leftLeaveSum(root.left, true);
        int right = leftLeaveSum(root.right, false);
        return left+right;
    }

    public static int leftLeaveSum2(Node root) {
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(currNode.left != null) {
                    q.add(currNode.left);
                    if(currNode.left.left == null && currNode.left.right == null) {
                        sum += currNode.left.data;
                    }
                } 
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return sum;
    }

    public static int sumNumber(Node root, int ans) {
        if(root == null) {
            return 0;
        }
        ans = ans * 10 + root.data;
        if(root.left == null && root.right == null) {
            return ans;
        }
        int left = sumNumber(root.left, ans);
        int right = sumNumber(root.right, ans);
        return left+right;
    }

    public static Node LCA(Node root, Node p, Node q) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        int i=0;
        for(; i<(path1.size() < path2.size() ? path1.size() : path2.size()); i++) {
            if(path1.get(i) != path2.get(i)) break;

        }
        Node lca = path1.get(i-1);
        return lca;
    }

    public static boolean getPath(Node root, Node p, ArrayList<Node> path) {
        if(root == null) return false;
        path.add(root);
        if(root == p) return true;
        boolean left = getPath(root.left, p, path);
        boolean right = getPath(root.right, p, path);
        if(left || right) return true;
        path.remove(path.size() - 1);
        return false;
    }

    public static Node LCA2(Node root, Node p, Node q) {
        
        if(root == null ||root == p || root == q) {
            return root;
        }
        Node left = LCA2(root.left, p, q);
        Node right = LCA2(root.right, p, q);
        if(right == null) {
            return left;
        }
        if(left == null) {
            return right;
        }
        return root;
    }

    public static int minDist(Node root, Node p, Node q) {
        Node lCA = LCA2(root, p, q);
        int dist1 = LCADist(lCA, p);
        int dist2 = LCADist(lCA, q);
        return dist1 + dist2;
    }

    public static int LCADist(Node root, Node node) {
        if(root == null) {
            return -1;
        }
        if(root == node) {
            return 0;
        }
        int left = LCADist(root.left, node);
        int right = LCADist(root.right, node);
        if(left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right+1;
        } else {
            return left+1;
        }
    }

    static int kthAnc = 0;
    public static int KthAncestor(Node root, int n, int k) {
        if(root == null) return -1;
        if(root.data == n) {
            return 0;
        }
        int left = KthAncestor(root.left, n, k);
        int right = KthAncestor(root.right, n, k);
        if(left == -1 && right == -1) {
            return -1;
        } 
        int max = Math.max(left, right);
        if(max+1 == k) {
            System.out.println(root.data);
            kthAnc = root.data;
        }
        return max+1;
    } 

    // transform to sum tree method 1
    public static int sumTree(Node root) {
        if(root == null) return 0;
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        int nodeVal = root.data;
        root.data = left+right;
        return left+right+nodeVal;
    }

    // transform to sum tree method 2
    public static int transform(Node root) {
        if(root == null) return 0;
        int left = transform(root.left);
        int right = transform(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data + left;
        int newRight = root.right == null ? 0 : root.right.data + right;
        root.data = newLeft + newRight;
        return data;
    }

    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node deleteLeafValEqualX(Node root, int x) {
        if(root == null) return null;
        root.left = deleteLeafValEqualX(root.left, x);
        root.right = deleteLeafValEqualX(root.right, x);
        if(root.data == x && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void rootToLeafPath(Node root, List<String> ans, String str) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans.add(str+root.data);
        }
        rootToLeafPath(root.left, ans, str+root.data+"->");
        rootToLeafPath(root.right, ans, str+root.data+"->");
    }

    public static void main(String args[]) {
        /*
                    1
                   / \                
                  2   3
                 / \ / \
                4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);   
        root.left.right = new Node(2);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        /* 
                    1
                   / \
                  2   3
        */
        // Node subRoot = new Node(1);      
        // System.out.println("Height of tree : "+heightOfTree(root));
        // System.out.println("Total nodes in tree : "+countNodes(root));
        // System.out.println("Total nodes in tree : "+countNode(root));
        // System.out.println("Sum of all nodes in tree : "+sumOfNodes(root));
        // System.out.println("Sum of all nodes in tree : "+sumOfNode(root));
        // System.out.println("Diameter of tree : "+diameter(root));
        // System.out.println("Diameter of tree : "+Diameter(root).diameter);
        // Diameter2(root);
        // System.out.println("Diameter of tree : "+diam);
        // System.out.println("Sum of all nodes in tree : "+isSubTree(root, subRoot));
        // maxPathSum(root);
        // System.out.println("Maximum path sum of tree : "+maxi);
        // System.out.print("Top view of binary tree : ");
        // topViewOfTree(root);
        // System.out.println(KthLevelTree2(root, 3));
        // KthLevelTree(root, 1, 2);
        // System.out.println(ans);
        // System.out.println("Sum of left leaves in binary tree : "+leftLeaveSum(root, false));
        // System.out.println("Sum of left leave node int Binary Tree : "+leftLeaveSum2(root));
        // System.out.println(sumNumber(subRoot, 0));
        // System.out.println("Lowest common Ancester : "+LCA(root, root.left.left, root.right.right).data);
        // System.out.println("Lowest common Ancester : "+minDist(root, root.left.left, root.left.right));
        // KthAncestor(root, 5, 1);
        // System.out.println("Kth Ancester of node "+5+" : "+kthAnc);
        // System.out.println("Transformed to sum tree : "+sumTree(root));
        // preorder(root);
        // System.out.println();
        // System.out.println("Transformed to sum tree : "+transform(root));
        // preorder(root);
        Node newRoot = deleteLeafValEqualX(root, 3);
        preorder(newRoot);
        System.out.println();
    }
}
