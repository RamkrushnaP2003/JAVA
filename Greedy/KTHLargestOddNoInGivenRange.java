public class KTHLargestOddNoInGivenRange {
    public static int KThLaargestOdd(int l, int r, int k) {
        for(int i=r; i>=l; i--) {
            if(i % 2 != 0) {
                k--;
                if(k == 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static int KThLaargestOdd2(int l, int r, int k) {
        if(k<=0) return 0;
        if((r&1) > 0) {
            int count = (int)Math.ceil((r-l+1)/2);
            if(k > count) {
                return 0;
            } else {
                return (r-(2*k)+1);
            }
        } else {
            int count = (r-l+1)/2;
            if(k > count) {
                return 0;
            } else {
                return(r-(2*k)+1);
            }
        }
    }

    public static void main(String[] args) {
        int l=-10, r=10, k=8;
        System.out.println(KThLaargestOdd(l, r, k));
    }
}
