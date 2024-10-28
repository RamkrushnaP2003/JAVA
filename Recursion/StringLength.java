public class StringLength {
    public static int length(String str, int i) {
        if(i == str.length()) return i;
        if(str.length() == 0) return 0;
        return length(str, i+1);
    } 

    public static void main(String[] args) {
        System.out.println(length("ram", 0));
    }
}
