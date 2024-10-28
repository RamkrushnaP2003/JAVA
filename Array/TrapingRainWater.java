public class TrapingRainWater {
    public static int TrappedRainWater(int height[], int width) {
        int n = height.length;
        // 1 - find left max heiht and store in Auxillary Array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // 2 - find right max height and store in Auxillary Array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        //find min of them store them into Auxillary Array
        int water[] = new int[n];
        for(int i=0; i<n; i++) {
            water[i] = Math.min(leftMax[i], rightMax[i]);
        }
        // add[sum] them in one variable
        int TrappedRainWater = 0;
        for(int i=0; i<n; i++) {
            TrappedRainWater += ((water[i] - height[i]) * width);
        }
        return TrappedRainWater;
    }

    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int width = 3;
        System.out.println(TrappedRainWater(height, width));
    }
}