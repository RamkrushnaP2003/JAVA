import java.util.Arrays;

public class anagram {
    public static boolean isanagram(String str1, String str2) {
        char str1CharArr[] = str1.toCharArray();
        char str2CharArr[] = str2.toCharArray();
        Arrays.sort(str1CharArr);
        Arrays.sort(str2CharArr);
        return Arrays.equals(str1CharArr, str2CharArr);
    }

    public static void main(String[] args) {
        String str1 = "aacc", str2 = "ccac";
        System.out.println(isanagram(str1, str2));
    }
}
