import java.util.*;

public class InfixToPrefix {
    public static int Prec(char ch) {
        switch(ch) {
            case '^': 
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    public static String infixToPrefix(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(ch == '(') {
                sb.append(')');
            } else if(ch == ')') {
                sb.append('(');
            } else {
                sb.append(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if(ch == '(') {
                s.push(ch);
            } else if(ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    ans.append(s.pop());
                }
                s.pop();
            } else {
                if(ch == '^') {
                    while (!s.isEmpty() && Prec(s.peek()) >= Prec(ch)) {
                        ans.append(s.pop());
                    }
                } else {
                    while (!s.isEmpty() && Prec(s.peek()) > Prec(ch)) {
                        ans.append(s.pop());
                    }
                }
                s.push(ch);
            }
        }
        while (!s.isEmpty()) {
            ans.append(s.peek());
            s.pop();
        }
        char[] ch = ans.toString().toCharArray();
        int n=ch.length;
        for(int i=0; i<n/2; i++) {
            char temp = ch[i];
            ch[i] = ch[n-i-1];
            ch[n-i-1] = temp;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String str = "A^B^C/D";
        System.out.println(infixToPrefix(str));
    }
}
