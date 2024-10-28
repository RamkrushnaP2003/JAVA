import java.util.ArrayList;

public class PairSUm {
    // time complexity -> O(n^2)
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i)+list.get(j)==target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size()-1;
        while (left<right) {
            int leftNum = list.get(left);
            int rightNum = list.get(right);
            if(leftNum + rightNum == target) {
                return true;
            }
            if(leftNum + rightNum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // for sorted rotated
    // time complexity -> O(n)
    public static boolean pairSum3(ArrayList<Integer> list, int target) {
        int pivot = -1;
        int n = list.size();
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                pivot = i;
                break;
            }
        }
        int left = pivot+1;
        int right = pivot;
        while (left!=right) {
            int leftEle = list.get(left);
            int rightEle = list.get(right);
            if(leftEle + rightEle == target) {
                return true;
            }
            if(leftEle + rightEle < target) {
                left = (left+1) % n; 
            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 100;
        // System.out.println(pairSum2(list, target));
        System.out.println(pairSum3(list, target));
    }
}
