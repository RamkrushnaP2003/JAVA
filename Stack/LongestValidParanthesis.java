public class LongestValidParanthesis {
    // time complexity _> O(n)
    public static int longestvalid(String str) {
        if(str.length() <= 1) return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') left++;
            else right++;

            if(left == right) count = Math.max(count, left+right);
            else if(right > left) left = right = 0;
        }
        left = right = 0;
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(ch == '(') left++;
            else right++;
            if(left == right) count = Math.max(count, left+right);
            else if(left > right) left = right = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "()())(";
        int res = longestvalid(str);
        System.out.println(res);
    }
}
