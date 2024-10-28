import java.util.*;

public class InfixToPostfix {
    public static int Prec(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    public static String infixToPostfix(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if(ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    ans.append(s.pop());
                }
                s.pop();
            } else {
                while (!s.isEmpty() && Prec(ch) <= Prec(s.peek())){
                    ans.append(s.pop());
                }
                s.push(ch);
            }
        }
        while (!s.isEmpty()) {
            ans.append(s.peek());
            s.pop();
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "a+b-c+d-f";
        System.out.println(infixToPostfix(str));
    }
}