public class Practice {
    public static void main(String[] args) {
        try {
            int a = 10/0;
            int nums[] = new int[5];
            System.out.println(nums[5]);
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Code excecuted");
        }
    }
}
