public class LongestRepeatingCharacterReplacement {
    public static int maxReplacement(String str, int k) {
        int max=0;
        for(int i=0; i<str.length(); i++) {
            int count=0;
            for(int j=i; j<str.length(); j++) {
                if(str.charAt(i)!=str.charAt(j)) {
                    count++;
                }
                if(count <= k) {
                    max =Math.max(max, j-i+1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static int maxReplacement2(String str, int k) {
        int n=str.length(), l=0, r=0, max=0, maxF=0;
        int map[] = new int[26];
        while (r<n) {
            char ch1=str.charAt(r);
            map[ch1-'A']++;
            maxF = Math.max(maxF, map[ch1-'A']);
            while ((r-l+1)-maxF > k) {
                map[str.charAt(l)-'A']--;
                maxF=0;
                for(int i=0; i<26; i++) {
                    maxF = Math.max(maxF, map[i]);
                }
                l++;
            }
            if((r-l+1)-maxF <= k) {
                max = Math.max(max, r-l+1);
            }
            r++;
        }
        return max;
    }

    public static int maxReplacement3(String str, int k) {
        int n=str.length(), l=0, r=0, maxF=0, max=0;
        int map[] = new int[26];
        while (r<n) {
            map[str.charAt(r)-'A']++;
            maxF = Math.max(maxF, map[str.charAt(r)-'A']);
            if((r-l+1)-maxF > k) {
                map[str.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxF <= k) {
                max = Math.max(max, (r-l+1));
            }    
            r++;   
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "BAAAB";
        System.out.println(maxReplacement(str, 2));
        System.out.println(maxReplacement2(str, 2));
        System.out.println(maxReplacement3(str, 2));
    }
}