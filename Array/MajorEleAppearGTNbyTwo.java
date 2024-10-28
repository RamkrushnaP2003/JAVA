public class MajorEleAppearGTNbyTwo {
    // brute force approach
    // time complexity -> O(n^2)
    public static int majorEle(int arr[]) {
        int n=arr.length;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count > n/2) return arr[i];
        }
        return 0;
    }

    public static int majorEle2(int arr[]) {
        int count = 0;
        int ele = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(count == 0) {
                ele = arr[i];
            }
            if (arr[i] == ele) {
                count++;
            } else {
                count--;
            }
        }
        int count1 = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ele) {
                count1++;
            }
        }
        if(count1 > arr.length/2) {
            return ele;
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {3,2, 2, 2, 2, 3};
        System.out.println(majorEle(arr));
    }
}
