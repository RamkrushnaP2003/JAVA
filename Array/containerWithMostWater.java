public class containerWithMostWater {
    // brute force approach -> Not Optimal solution
    // time complexity -> O(n^2)
    // space complexity -> O(1)
    public static int ContainerWithMostWater(int height[]) {
        int mostWater = Integer.MIN_VALUE;
        for(int i=0; i<height.length; i++) {
            int minHeight = height[i];
            for(int j=i+1; j<height.length; j++) {
                int waterLevel = Math.min(minHeight, height[j]);
                int area = (j-i) * waterLevel;
                mostWater = Math.max(mostWater, area);
            }
        }
        return mostWater;
    }

    public static int ContainerWithMostWater2(int height[]) {
        int mostWater = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left<right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int minHeight = Math.min(leftHeight, rightHeight);
            mostWater = Math.max(mostWater, minHeight*(right-left));
            if(leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return mostWater;
    }

    public static void main(String[] args) {
        int height[] =  {4,3,2,1,4};
        System.out.println(ContainerWithMostWater2(height));
    }
}
