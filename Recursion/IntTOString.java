// 2019 -> two zero one nine
public class IntTOString {
    static String digits[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void conversion(int n) {
        if(n==0) {
            return;
        }
        int lastDigit = n % 10;
        conversion(n/10);
        System.out.print(digits[lastDigit]+" ");
    }

    public static void main(String[] args) {
        int n=123;
        conversion(n);
    }
}
