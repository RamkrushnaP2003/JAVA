public class LemonadeChange {
    public static boolean lemonadeChange(int nums[]) {
        int five = 0, ten = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 5) five++;
            else if(nums[i] == 10) {
                if(five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if(five >= 1 && ten >= 1) {
                    five--;ten--;
                } else if(five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(nums));
    }
}
