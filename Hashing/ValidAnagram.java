import java.util.HashMap;

public class ValidAnagram {
    public static boolean isValid(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(Character ch : str2.toCharArray()) {
            if(map.containsKey(ch)) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch)-1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static boolean isValid2(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        int freq[] = new int[26];
        for(Character ch : str1.toCharArray()) {
            freq[ch-'a']++;
        }
        for(Character ch : str2.toCharArray()) {
            freq[ch-'a']--;
        }
        for(int i : freq) {
            if(i!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "care";
        String str2 = "race";
        System.out.println(isValid(str1, str2));
    }
}
