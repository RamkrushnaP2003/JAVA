import java.util.*;

public class BinarySearchTree {
    static class Node {
        Node left, right;
        int data;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node BuildBST(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) { // left subtree
            root.left = BuildBST(root.left, val);
        } else {
            root.right = BuildBST(root.right, val);
        }
        return root;
    }

    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left); 
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int target) { // time complexity -> O(h) where h = height of tree
        if(root == null) return false;
        if (root.data == target) {
            return true;
        }
        if(root.data > target) {
            return  search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static Node deleteNode(Node root, int val) {
        if(root.data < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else {
            // case 1 -> leaf node
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // case 2 -> single child
            else if(root.left == null) {
                root = root.right;
                return  root;
            } else if (root.right == null) {
                root = root.left;
                return root;
            } 
            // case 3 -> both children
            else {
                Node IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteNode(root.right, IS.data);
                return root;
            }
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if(k1 <= root.data && k2 >= root.data) {
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        } else if(root.data > k1) {
            printRange(root.left, k1, k2);
        } else {
            printRange(root.right, k1, k2);
        }
    }

    public static void rootToLeaf(Node root, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
        if (root == null)  {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }
        rootToLeaf(root.left, paths, path);
        rootToLeaf(root.right, paths, path);
        path.remove(path.size()-1);
    }

    // Approach 1 -> time complexity -> O(2n) = O(n)
    public static boolean isValidBST(Node root) {
        ArrayList<Integer> tree = new ArrayList<>();
        inorder(root, tree);
        for(int i=1; i<tree.size(); i++) {
            if(tree.get(i-1) > tree.get(i)) {
                return false;
            } 
        }
        return true;
    }

    public static ArrayList<Integer> inorder(Node root, ArrayList<Integer> tree) {
        if(root == null) return null;
        inorder(root.left, tree);
        tree.add(root.data);
        inorder(root.right, tree);
        return tree;
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        } 
        
        else if (max != null && root.data >= max.data) {
            return false;
        }

        boolean left = isValidBST(root.left, min, root);
        boolean right = isValidBST(root.right, root, max);

        return left && right;
    }

    public static Node mirror(Node root) {
        if(root == null) return null;
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static boolean isSymmetric(Node leftSubTreeNode, Node rightSubTReeNode) {
        if(leftSubTreeNode == null && rightSubTReeNode == null) return true;
        else if(leftSubTreeNode == null) return false;
        else if (rightSubTReeNode == null) return false; 
        if(leftSubTreeNode.data != rightSubTReeNode.data) return false;
        boolean left = isSymmetric(leftSubTreeNode.left, rightSubTReeNode.right);
        boolean right = isSymmetric(leftSubTreeNode.right, rightSubTReeNode.left);
        return left && right;
    }

    public static Node BalancedBST(int arr[], int start, int end) {
        if(start > end) return null;
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = BalancedBST(arr, start, mid-1);
        root.right = BalancedBST(arr, mid+1, end);
        return root;
    }

    public static Node BalancedBST(ArrayList<Integer> ans, int start, int end) {
        if(start > end) return null;
        int mid = ( start+end ) / 2;
        Node root = new Node(ans.get(mid));
        root.left = BalancedBST(ans, start, mid-1);
        root.right = BalancedBST(ans, mid+1, end);
        return root;
    }

    public static Node ConvertBalancedBST(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return BalancedBST(nodes, 0, nodes.size()-1);
    } 

    public static Node mergeBST(Node root1, Node root2) {
        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root1 != null) inorder(root1, ans1);
        if(root2 != null) inorder(root2, ans2);
        int i=0, j=0;
        while(i<ans1.size() && j<ans2.size()) {
            if(ans1.get(i) < ans2.get(j)) {
                ans.add(ans1.get(i++));
            } else {
                ans.add(ans2.get(j++));
            }
        }
        while(i<ans1.size()) {
            ans.add(ans1.get(i++));
        }
        while(j<ans2.size()) {
            ans.add(ans2.get(j++));
        }
        return BalancedBST(ans, 0, ans.size()-1);
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }        
    }
    public static int maxBST = 0;
    public static Node largestNode = null;
    public static Info LargestBST(Node root) {
        if(root == null) return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Info leftInfo = LargestBST(root.left);
        Info rightInfo = LargestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(size, maxBST);
            largestNode = root;
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static boolean hasPathSum(Node root, int target) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return target==root.data;
        boolean left = hasPathSum(root.left, target-root.data);
        boolean right = hasPathSum(root.right, target-root.data);
        return left || right;
    }

    static int sum = 0;
    public static int rangeSum(Node root, int k1, int k2) {
        if (root == null) {
            return 0; 
        }
        if(k1 <= root.data && k2 >= root.data) {
            rangeSum(root.left, k1, k2);
            rangeSum(root.right, k1, k2);
            sum += root.data;

        } else if(root.data > k1) {
            rangeSum(root.left, k1, k2);
        } else {
            rangeSum(root.right, k1, k2);
        }
        return sum;
    }

    public static int rangeSum2(Node root, int low, int high) {
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
                if(low <= currNode.data && currNode.data <= high) {
                    sum += currNode.data;
                }
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

    // time complexity -> O(h)
    static int minDiff = Integer.MAX_VALUE;
    static int minDiffKey = -1;
    public static void nearestNode(Node root, int k) {
        if(root == null) return;
        if(root.data == k) {
            minDiffKey = root.data;
            minDiff = 0;
            return;
        }
        if(minDiff > Math.abs(root.data - k)) {
            minDiff = Math.abs(root.data - k);
            minDiffKey = root.data;
        }
        if(k < root.data) {
            nearestNode(root.left, k);
        } else {
            nearestNode(root.right, k);
        }
    }

    // min diff of k nearest node
    public static void minDiff(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int minDiff = Integer.MAX_VALUE;
        int minDiffKey = -1;
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(minDiff > Math.abs(currNode.data - k)) {
                    minDiff = Math.abs(currNode.data - k);
                    minDiffKey = currNode.data;
                }
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        System.out.println("Minimum Differance is : "+minDiff+" ans nearest node is : "+minDiffKey);
    }

    // time complexity -> O(n * h) .'. h = height of tree
    public static boolean twoSum(Node root, int target) {
        if(root == null) return false;
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
                if(isFound(root, currNode, target)) {
                    return true;
                }
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return false;
    }

    public static boolean isFound(Node root, Node node, int target) {
        if(root == null) return false;
        if(root.data + node.data == target) {
            return true;
        }
        if(root.data + node.data < target) {
            return isFound(root.left, node, target);
        } else {
            return isFound(root.right, node, target);
        }
    }

    // time complexity -> O(n)
    public static boolean TwoSum(Node root, int target) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        int left = 0, right = nodes.size()-1;
        while (left != right) {
            int low = nodes.get(left);
            int high = nodes.get(right);
            int sum = high + low;
            if(sum == target) {
                return true;
            }
            if(sum < target) {
                left++;
            } else {
                right++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int values[] = {5, 3, 4, 2, 6, 7};
        // Node root = null;
        // for(int i=0; i<values.length; i++) {
        //     root = BuildBST(root, values[i]);
        // // }
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        if(TwoSum(root, 9)) {
            System.out.println("Found ");
        } else {
            System.out.println("Not Found");
        }
    } 
}