public class RotateString {
    public static boolean rotateString(String str, String goal) {
        if(str.length() != goal.length()) return false;
        return (str+str).contains(goal);
    }

    public static void main(String[] args) {
        String str = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(str, goal));
    }
}