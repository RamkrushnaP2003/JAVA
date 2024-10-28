public class MajorityEle {
    public static int MajorityElement(int arr[], int si, int ei) {
        if(si == ei) return arr[si];
        int mid = si + (ei-si)/2;
        int left = MajorityElement(arr, si, mid);
        int right = MajorityElement(arr, mid+1, ei);
        if(left == right) return left;
        int countleft = count(arr, left, si, ei);
        int countRight = count(arr, right, si, ei);
        return countleft > countRight ? left : right;
    }

    public static int count(int arr[], int num, int si, int ei) {
        int count = 0;
        for(int i=si; i<=ei; i++) {
            if(arr[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 3, 3};
        System.out.println(MajorityElement(arr, 0, arr.length-1));
    }
}