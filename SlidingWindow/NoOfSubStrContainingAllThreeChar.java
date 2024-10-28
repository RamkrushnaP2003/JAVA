import java.util.*;

public class NoOfSubStrContainingAllThreeChar {
    public static int noOfSubstr(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j=i; j<str.length(); j++) {
                char ch = str.charAt(j);
                set.add(ch);
                if(set.size() >= 3) {
                    count += str.length()-j; break;
                }
            }
        }
        return count;
    }

    public static int noOfSubstr2(String str) {
        int n= str.length();
        int l=0, r=0, count=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            char ch1 = str.charAt(r), ch2=str.charAt(l);
            map.put(ch1, map.getOrDefault(ch1, 0)+1);
            while (map.size() == 3) {
                if(map.get(ch2)==1) {
                    map.remove(ch2);
                } else {
                    map.put(ch2, map.getOrDefault(ch2, 0)-1);
                }
                count += (n-r);
                l++;
            }
            r++;
        }
        return count;
    }

    public static int noOfSubstr3(String str) {
        int n=str.length(), r=0, count=0, a=-1, b=-1, c=-1;
        while (r < n) {
            char ch = str.charAt(r);
            if(ch=='a') a=r;
            if(ch=='b') b=r;
            if(ch=='c') c=r;
            count += (Math.min(a, Math.min(b, c)) + 1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "bbacba";
        System.out.println(noOfSubstr(str));
        System.out.println(noOfSubstr2(str));
        System.out.println(noOfSubstr3(str));
    }
}
