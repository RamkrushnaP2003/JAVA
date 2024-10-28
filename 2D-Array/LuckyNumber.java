public class LuckyNumber {
    public static boolean isLuckyNumber(int n, int counter) {
        if(n < counter) return true;
        if(n % counter == 0) return false;
        return isLuckyNumber(n-(n/counter), counter+1);
    }

    public static void main(String[] args) {
        int n = 9;
        int count = 2;
        System.out.println(isLuckyNumber(n, count));
    }
}
