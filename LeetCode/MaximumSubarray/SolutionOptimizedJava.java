class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize both current sum and maximum sum to the first element
        int currMax = nums[0];
        int maxSum = nums[0];
        
        // Iterate starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray at nums[i] 
            // or extend the existing subarray
            currMax = Math.max(nums[i], nums[i] + currMax);
            
            // Update the global maximum sum if needed
            maxSum = Math.max(maxSum, currMax);
        }
        
        // Return the largest sum found
        return maxSum;
    }
}