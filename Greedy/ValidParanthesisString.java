public class ValidParanthesisString {
    public static boolean isValid(String str) {
        int left = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '*') {
                left++;
            } else {
                left--;
            }
            if(left < 0) {
                return false;
            } 
        }
        if(left == 0) return true;
        int right = 0;
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(ch != '(') {
                right++;
            } else {
                left++;
            }
            if(right < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        System.out.println(isValid(str));
    }
}
