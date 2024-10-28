import java.util.*;

public class LongestCommonSubseq {
    static class Pair implements Comparable<Pair>{
        String s;
        int len;

        public Pair(String s, int len) {
            this.s = s;
            this.len = len;
        }

        public int compareTo(Pair p2) {
            return p2.len - this.len;
        }
    }
    
    // time complexity -> O(((2^n)+(2^m)) + (n+m) + (nlogn + mlogm))
    // space complexity -> O((2n+m) + (n+m[recursion stack]))
    public static int lcs(String str1, String str2) {    
        PriorityQueue<Pair> pq1 = new PriorityQueue<>();
        PriorityQueue<Pair> pq2 = new PriorityQueue<>();
        helper(str1, pq1, 0, "");
        helper(str2, pq2, 0, "");
        HashSet<String> set = new HashSet<>();
        while (!pq1.isEmpty()) {
            Pair str = pq1.poll();
            set.add(str.s);
        }
        while (!pq2.isEmpty()) {
            Pair str = pq2.poll();
            if(set.contains(str.s)) {
                return str.s.length();
            }
        }
        return "*".length();
    }

    public static void helper(String str, PriorityQueue<Pair> ans, int i, String s) {
        if(str.length() == i) {
            ans.offer(new Pair(s, s.length()));
            return;
        }
        helper(str, ans, i+1, s+str.charAt(i));
        helper(str, ans, i+1, s);
    }

    public static void main(String[] args) {
        String str1 = "abcdge", str2 = "ace";
        System.out.println(lcs(str1, str2));
    }
}
