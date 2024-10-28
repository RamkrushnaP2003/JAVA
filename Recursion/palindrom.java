public class palindrom {
    public static boolean palindromStr(String str, int left, int right) {
        if(left>=right) return true;
        if(str.charAt(left) != str.charAt(right)) return false;
        return palindromStr(str, left+1, right-1);
    }

    public static boolean palindromStr2(String str, int i) {
        if(i>=str.length()/2) return true;
        if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        return palindromStr2(str, i+1);
    }

    public static void main(String[] args) {
        String str = "nayan";
        System.out.println(palindromStr(str, 0, str.length()-1));
        // System.out.println(palindromStr2(str, 0));
    }
}
