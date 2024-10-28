public class pushZeroEnd {
    public static void PushZeroEnd(int arr[]) {
        int nonZero = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=0) {
                int temp = arr[i];
                arr[i] = arr[nonZero];
                arr[nonZero] = temp;
                nonZero++;
            }
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 2, 0, 1, 3, 1, 5};
        PushZeroEnd(arr);
    }
}

/*
 * int arr[] = {1, 0, 0, 2, 0, 1, 3, 1, 5};
 * i=0 nonZero=0
 * swap(arr[o] =1, arr[0] = 1) i=0, nonZero=0
 * arr {1, 0, 0, 2, 0, 1, 3, 1, 4}   
 * nonZero++;
 * i=1 nonZero=1;
 * i=2 nonZero = 1
 * i=3 nonZero =1
 * swap(arr[3], arr[1]) i=3, nnZero=1;
 * arr = {1, 2, 0, 0, 0, 1, 3, 1, 5};
 * nonZero++;
 * i=4, nonZero=2;
 * i=5, nonZero=2
 * swap(arr[5], arr[2]) i=5, nonZero=2
 * arr = {1, 2, 1, 0, 0, 0, 3, 1, 5}
 * nonZero++;
 * i=6 nonZer=3;
 * swap(arr[6], arr[3])
 * arr {1, 2, 1, 3, 0, 0, 0, 1, 5}
 * nonZero++;
 * i=7 nonZero=3;
 * swap(arr[7], arr[3]);
 * arr {1, 2, 1, 3, 1, 0, 0, 0, 5}
 * nonZero++;
 * i=8; nonZero=4;
 * swap(arr[8], arr[4]);
 * arr {1, 2, 3, 1, 5, 0, 0, 0}
 */