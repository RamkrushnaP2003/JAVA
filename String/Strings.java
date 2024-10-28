// import java.util.Scanner;

public class Strings {
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // String str = "abc";
        // String str1 = new String("XYZ");
        // System.out.println(str+" "+str1);

        // System.out.println("Enter string");
        // Scanner sc = new Scanner(System.in);
        // String str2 = sc.next();
        // System.out.println(str2);

        // System.out.println("Enter new string");
        // String str3 = sc.nextLine();
        // System.out.println(str3);

        // String str5 = "Tony stark";
        // System.out.println(str5.length());

        // String Fname = "Ramkrushna";
        // String Lname = "Parkipandla";
        // String fullName = Fname+" "+Lname;
        // System.out.println(fullName+" "+fullName.length());
        // System.out.println(Fname.charAt(0));
        // printLetters(fullName);

        // String str = "ShradhaDidi";
        // String str1 = "ApnaCollege";
        // String str2 = "ShradhaDidi";
        // System.out.println(str.equals(str1)+" "+str.equals(str2));

        String str = "ApnaCollege".replace("l", "");
        System.out.println(str);
    }
}