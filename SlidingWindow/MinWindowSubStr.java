public class MinWindowSubStr {
    public static String minWindowSubStr(String str, String target) {
        int minLen = str.length(), sIdx = -1;
        for(int i=0; i<str.length(); i++) {
            int map[] = new int[256];
            int count = 0;
            for(int j=0; j<target.length(); j++) {
                map[target.charAt(j)]++;
            }
            for(int j=i; j<str.length(); j++) {
                if(map[str.charAt(j)] > 0) {
                    count++;
                }
                map[str.charAt(j)]--;
                if(count == target.length()) {
                    if((j-i+1)<minLen) {
                        minLen = j-i+1;
                        sIdx = i;
                        break;
                    }
                }
            }
        }
        return str.substring(sIdx, sIdx+minLen);
    }

    public static String minWindowSubStr2(String str, String target) {
        if(str.length() < target.length()) return "";
        int map[] = new int[256];
        int l=0, r=0, count=0, minLen = Integer.MAX_VALUE, sIdx = -1;
        for(int i=0; i<target.length(); i++) {
            map[target.charAt(i)]++;
            System.out.print(map[target.charAt(i)]+" ");
        }
        System.out.println();
        while (r < str.length()) {
            char ch = str.charAt(r);
            if(map[ch] > 0) count++;
            map[ch]--;
            while (count == target.length()) {
                
                if(minLen >= (r-l+1)) {
                    minLen = (r-l+1);
                    sIdx = l;
                }
                if(map[str.charAt(l)] == 0) count--;
                map[str.charAt(l)]++;
                l++;
            }
            r++;
        }
        System.out.println(sIdx+" - "+minLen);
        return str.substring(sIdx, minLen+sIdx);
    }

    public static void main(String[] args) {
        String str = "a", target="aa";
        // System.out.println(minWindowSubStr(str, target));
        System.out.println(minWindowSubStr2(str, target));
    }
}
