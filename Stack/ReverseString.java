import java.util.Stack;

public class ReverseString {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            res.append(curr);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(reverse(str));
    }
}
