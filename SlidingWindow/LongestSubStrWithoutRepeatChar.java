import java.util.*;

public class LongestSubStrWithoutRepeatChar {
    public static int longestSubstr(String str) {
        int map[] = new int[256];
        Arrays.fill(map, -1);
        int maxLen = 0, l=0, r=0, n=str.length();
        while(r < n) {
            char ch = str.charAt(r);
            if(map[ch] != -1) {
                if(map[ch] >= l) {
                    l = map[ch]+1;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            map[ch] = r;
            r++;
        }
        return maxLen;
    }

    public static int longestSubstr2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, l=0, r=0, n=str.length();
        while (r < n) {
            char ch = str.charAt(r);
            if(map.containsKey(ch)) {
                if(map.get(ch) >= l) {
                    l = map.get(ch) + 1;
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            map.put(ch, r);
            r++;   
        } 
        return maxLen;  
    }

    public static void main(String[] args) {
        String str = "cadabzabacd";
        System.out.println(longestSubstr(str));
        System.out.println(longestSubstr2(str));
    }
}
