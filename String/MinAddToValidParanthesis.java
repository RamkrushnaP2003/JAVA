import java.util.*;

public class MinAddToValidParanthesis {
    // time complexity -> O(n)
    public static int minAddToMakeValid(String str) {
        Stack<Character> s = new Stack<>();
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                s.push(ch);
                count++;
            } else {
                if(s.size() == 0) {
                    count++;
                } else {
                    s.pop();
                    count--;
                }
            }
        }
        return count;
    }

    public static int minAddToMakeValid2(String str) {
        int countLeft = 0;
        int countRight = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                countLeft++;
            } else {
                if(countLeft == 0) {
                    countRight++;
                } else {
                    countLeft--;
                }
            }
        }
        return countLeft+countRight;
    }

    public static void main(String[] args) {
        String str = "()))((";
        System.out.println(minAddToMakeValid2(str));
    }
}
