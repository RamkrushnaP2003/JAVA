import java.util.HashMap;

public class LoongestSubStrAtMostKDIstChar {
    public static int longestSubStrKDistCHar(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<str.length(); i++) {
            map.clear();
            for(int j=i; j<str.length(); j++) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
                if(map.size() <= k) {
                    max = Math.max(max, j-i+1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static int longestSubStrKDistCHar2(String str, int k) {
        int max=0, l=0, r=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < str.length()) {
            char ch = str.charAt(r), ch2 = str.charAt(l);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size() > k) {
                if(map.get(ch2) == 1) {
                    map.remove(ch2);
                } else {
                    map.put(ch2, map.getOrDefault(ch2, 0)-1);
                }
                l++;
            }
            if(map.size() <= k) {
                max = Math.max(max, r-l+1);
            }
            r++;
        }
        return max;
    }

    public static int longestSubStrKDistCHar3(String str, int k) {
        int l=0, r=0, max=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < str.length()) {
            char ch1 = str.charAt(r), ch2 = str.charAt(l);
            map.put(ch1, map.getOrDefault(ch1, 0)+1);
            if(map.size() > k) {
                if(map.get(ch2) == 1) {
                    map.remove(ch2); 
                } else {
                    map.put(ch2, map.getOrDefault(ch2, 0)-1);
                }
                l++;
            }
            if(map.size() <= k) {
                max = Math.max(max, r-l+1);
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abbbccccddd";
        System.out.println(longestSubStrKDistCHar(str, 3));
        System.out.println(longestSubStrKDistCHar2(str, 3));
        System.out.println(longestSubStrKDistCHar3(str, 3));
    }
}