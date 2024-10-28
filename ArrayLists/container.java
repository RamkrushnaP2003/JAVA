public class container {
    public static int containerWithMostWater(int height[]) {
        int mostWater = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=i+1; j<height.length; j++) {
                int min = Math.min(height[i], height[j]);
                mostWater = Math.max(mostWater, min*(j-i));
            }
        }
        return mostWater;
    }

    public static int containerWithMostWater2(int height[]) {
        int mostWater = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int ht = Math.min(leftHeight, rightHeight);
            int width = (right-left);
            int area = ht * width;
            mostWater = Math.max(mostWater, area);
            if(leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return mostWater;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater2(height));
    }
}
