import java.util.Arrays;

public class LongestWordWithAllPrefix {
    static class Node {
        Node childerns[] = new Node[26];
        boolean eow = false;

        public Node() {
            Arrays.fill(childerns, null);
        }
    }

    static Node root = new Node();

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

    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i)-'a';
            if(curr.childerns[idx] == null) {
                return false;
            }
            curr = curr.childerns[idx];
        }
        return curr.eow == true;
    }

    static StringBuilder ans = new StringBuilder();
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) return;
        if(ans.length() < temp.length()) {
            ans = new StringBuilder(temp);
        }
        for(int i=0; i<26; i++) {
            if(root.childerns[i] != null && root.childerns[i].eow) {
                longestWord(root.childerns[i], temp.append((char)(i+'a')));
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder());
        System.out.println(ans);
    }
}
