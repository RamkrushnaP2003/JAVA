public class MajorityEle {
    public static int MajorityElement(int arr[], int si, int ei) {
        if(si == ei) return arr[si];
        int mid = si + (ei-si)/2;
        int left = MajorityElement(arr, si, mid);
        int right =  MajorityElement(arr, mid+1, ei);
        if(left == right) return left;
        int leftCount = count(arr, left, si, ei);
        int rightCount = count(arr, right, si, ei);
        return leftCount > rightCount ? left : right;
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
        int arr[] = {3, 2, 3};
        System.out.println(MajorityElement(arr, 0, arr.length-1));
    }
}
