import java.util.*;

public class PrefixToPostFix {
    public static String prefixPostfix(String str) {
        Stack<String> s = new Stack<>();
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                s.push(ch+"");
            } else {
                String t1 = s.pop();
                String t2 = s.pop();
                s.push(t1+t2+ch);
            }
        }
        return s.peek();
    }

    public static void main(String args[]) {
        String str = "/-AB*+DEF";
        System.out.println(prefixPostfix(str));
    }
}