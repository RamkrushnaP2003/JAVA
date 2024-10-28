import java.util.HashSet;

public class FirstLetterAppearTwise {
    // space complexity-> O(n)
    public static char repeatedChar2(String str) {
        HashSet<Character>  set = new HashSet<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return '*';
    }

    // space complexity -> O(1)
        public static char repeatedChar3(String str) {
            int[] freq = new int[26];
            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                freq[ch-'a']++;
                if(freq[ch-'a']==2) {
                    return ch;
                }
            }
            return '*';
        }

    public static void main(String[] args) {
        String str = "adjfvksj";
        System.out.println(repeatedChar3(str));
        System.out.println(repeatedChar2(str));
    }
}
