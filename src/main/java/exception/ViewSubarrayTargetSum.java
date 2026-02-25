package exception;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewSubarrayTargetSum {
    static int[] minSubArr= {};

	    public static int minSubArrayLen(int target, int[] nums) {
	        int left = 0;
	        int sum = 0;
	        int minLength = Integer.MAX_VALUE;
	        

	        for (int right = 0; right < nums.length; right++) {
	            sum += nums[right];

	            while (sum >= target) {
	                minLength = Math.min(minLength, right - left + 1);
	                minSubArr=Arrays.copyOfRange(nums, left, right+1);
	                sum -= nums[left];
	                left++;
	            }
	        }

	        return minLength == Integer.MAX_VALUE ? 0 : minLength;
	    }

	    public static void main(String[] args) {
	        int target = 7;
	        int[] nums = {2, 3, 1, 2, 4, 3};
	  
	        System.out.println(minSubArrayLen(target, nums)); // Output: 2
	        System.out.println(Arrays.toString(minSubArr));
	    }
	


}
