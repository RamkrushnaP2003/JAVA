import java.util.Stack;

public class PrefixToInfix {
    public static String prefixToInfix(String str) {
        Stack<String> s = new Stack<>();
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                s.push(ch+"");
            } else {
                String t1=s.pop();
                String t2 = s.pop();
                s.push("("+t1+ch+t2+")");
            }
        }
        return s.peek();
    }

    public static void main(String args[]) {
        String str = "*+PQ-MN";
        System.out.println(prefixToInfix(str));
    }
}
