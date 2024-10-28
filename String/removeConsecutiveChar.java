public class removeConsecutiveChar {
    public static String removeConsecString(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i)!=str.charAt(i-1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aababababbbbaa";
        System.out.println(removeConsecString(str));
    }
}
