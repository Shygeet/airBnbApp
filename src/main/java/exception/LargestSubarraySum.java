package exception;

public class LargestSubarraySum {

	public static void main(String[] args) 
	{
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
		

	}

	  public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];  // Initialize with first element
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either start new subarray at current element or extend previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum); // Update global max if needed
        }

        return maxSum;
    }
}
