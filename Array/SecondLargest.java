public class SecondLargest {
    public static int SecondLargestEle(int arr[]) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        int second = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=max) {
                second = Math.max(arr[i], second);
            }
        }
        return second;
    }

    public static int[] getSecondOrderElements(int n, int []a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(max < a[i]) {
                max = a[i];
            }
            if(min > a[i]) {
                min = a[i];
            }
        }
        int secMax = Integer.MIN_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(secMax < a[i] && max != a[i]) {
                secMax = a[i];
            }
            if(secMin > a[i] && min != a[i]) {
                secMin = a[i];
            }
        }
        return new int[] {secMax, secMin};
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 6, 7,35, 76};
        System.out.println(SecondLargestEle(arr));
    }
}
