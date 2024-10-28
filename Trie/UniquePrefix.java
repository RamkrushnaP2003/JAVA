import java.util.*;

public class UniquePrefix {
    static class Node {
        Node childerns[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            Arrays.fill(childerns, null);
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.childerns[idx] == null) {
                curr.childerns[idx] = new Node();
            } else {
                curr.childerns[idx].freq++;
            }
            curr = curr.childerns[idx];
        }
        curr.eow = true;
    }

    public static String findPrefix(Node root, String str) {
        StringBuilder sb = new StringBuilder();
        Node curr = root;
        for(int i=0; i<str.length(); i++) {
            int idx = str.charAt(i)-'a';
            if(curr.childerns[idx] != null) {
                sb.append((char)(idx+'a'));
                if(curr.childerns[idx].freq == 1) {
                    break;
                }
            }
            curr = curr.childerns[idx];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String words[] = {"zzmn", "vib", "tcady", "jjfl", "ire", "taf", "hknha", "hmwm", "sasae", "stx"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        root.freq = -1;
        List<String> ans = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            ans.add(findPrefix(root, words[i]));
        }
        System.out.println(ans);
    }
}