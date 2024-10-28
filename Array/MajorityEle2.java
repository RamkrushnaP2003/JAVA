import java.util.ArrayList;

public class MajorityEle2 {
    // time complexity -> O(n)
    public static void majorityEle2(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int ele1=0;
        int ele2=0;
        int count1=0, count2=0;
        for(int i=0; i<n; i++) {
            if(ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else if(count1 == 0) {
                ele1=nums[i];
                count1++;
            } else if(count2 == 0){
                ele2=nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1=count2=0;
        for(int i=0; i<n; i++) {
            if(nums[i] == ele1) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            }
        }

        if(count1 > (n/3)) {
            ans.add(ele1);
        } 
        if (count2 > (n/3)) {
            ans.add(ele2);
        }
        System.out.println(ans);
    }

    // time complexity -> O(n^2)
    public static void majorityEle22(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n=nums.length;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=i; j<n; j++) {
                if(nums[i] == nums[j]) count++;
            }
            if(count > (n/3)) ans.add(nums[i]);
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        int nums[] = {2,1,1,3,1,4,5,6};
        majorityEle22(nums);
    }
}