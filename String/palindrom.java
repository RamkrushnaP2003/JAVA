public class palindrom {
    // time complexity -> O(n)
    public static boolean isPalindrom(String str) {
        str.trim();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrom2(String str) {
        str.replaceAll("[^A-Za-z0-9]", "");
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrom2(str));
    }
}
