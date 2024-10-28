public class AToI {
    public static int atoi(String str) {
        str = str.trim();
        if(str.isEmpty()) {
            return 0;
        }
        int ans = 0, i = 0;
        boolean neg = str.charAt(0) == '-';
        boolean pos = str.charAt(0) == '+';
        if(neg || pos) i++;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }
        return neg ? -ans : ans;
    }

    public static void main(String[] args) {
        String str = "   -10";
        System.out.println(atoi(str));
    }
}
