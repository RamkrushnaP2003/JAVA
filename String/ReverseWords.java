public class ReverseWords {
    public static void main(String[] args) {
        String str = "ram   is god";
        String str1[] = str.split(" ");
        for(int i=0; i<str1.length; i++) {
            if(str1[i] != "")
                System.out.println(str1[i]);
        }
    }
}