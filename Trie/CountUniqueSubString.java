import java.util.Arrays;

public class CountUniqueSubString {
    static class Node {
        Node childerns[] = new Node[26];
        boolean eow = false;

        public Node() {
            Arrays.fill(childerns, null);
        }
    }

    public static Node root = new Node();

    public static void insert(String str) {
        Node curr = root;
        for(int i=0; i<str.length(); i++) {
            int idx = str.charAt(i)-'a';
            if(curr.childerns[idx] == null) {
                curr.childerns[idx] = new Node();
            }
            curr = curr.childerns[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String str) {
        Node curr = root;
        for(int i=0; i<str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.childerns[idx] == null) {
                return false;
            }
            curr = curr.childerns[idx];
        }
        return curr.eow == true;
    }

    public static int countNode(Node root) {
        if(root == null) return 0;
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.childerns[i] != null) {
                count += countNode(root.childerns[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String str = "aba";
        // step-1 : Suffix and insert into trie
        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println("Unique subtring : "+countNode(root));
    }
}
