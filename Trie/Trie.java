import java.util.Arrays;

public class Trie {
    static class Node {
        Node children[] = new Node[26];
        Boolean eow = false;
        
        public Node() {
            Arrays.fill(children, null);
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean worldBreak(String key) { // O(L)
        if(key.length() == 0) return true;
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && worldBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        String key = "ilikesamsungs";
        if(worldBreak(key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}