import java.util.Scanner;

public class countVowels {
    public static int countVowel(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter string : ");
            String str = sc.next();
            System.out.println(str+" vowel length : "+countVowel(str));
        }
    }
}
