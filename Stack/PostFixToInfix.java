import java.util.*;

public class PostFixToInfix {
    public static String postfixToInfix(String str) {
        Stack<String> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                s.push(ch+"");
            } else {
                String t1 = s.pop();
                String t2 = s.pop();
                s.push("(" + t2 + ch + t1 + ")");
            }
        }
        return s.peek();
    }

    public static void main(String args[]) {
        String str = "AB-DE+F*/";
        System.out.println(postfixToInfix(str));
    }
}
