public class Question {
    // Que 1 -> What is value of x^x for any value of x
    public static int xXORx(int x) {
        return x^x;
    }

    // Que 2 -> swap two no without using third variable
    public static void swap(int a, int b) {
        b = a ^ b;
        a = b ^ a;
        b = a ^ b;
        System.out.println("a="+a+", b="+b);
    }

    // Que 3 -> Add 1 to an integer using BitManupulation
    // time complexity -> O(1)
    // space complexity -> O(1)
    public static int addone(int n) {
        return -(~n);
    }

    // Que 4 -> convert uppercase to lowercase
    public static char convert(char ch) {
        return (char)((ch) & ~( 1 << 5));
    }

    public static void main(String[] args) {
        System.out.println(convert('q'));
    }
}
