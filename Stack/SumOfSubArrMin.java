public class SumOfSubArrMin {
    // time complexity -> O(n^3)
    public static int sumSubarrMin(int arr[]) {
        int max = 0;
        int ans=0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int min = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++) {
                    if(arr[k] < min) {
                        min = arr[k];
                    }
                }
                ans += min;
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    // time complexity -> O(n^2)
    public static int sumSubarrMin2(int arr[]) {
        int max = 0;
        int ans=0;
        for(int i=0; i<arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=i; j<arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                }
                
                ans += min;
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {11, 81, 94, 43, 3};
        System.out.println(sumSubarrMin2(arr));
    }
}
