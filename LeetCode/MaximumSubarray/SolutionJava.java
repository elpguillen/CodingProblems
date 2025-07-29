class Solution {
    public int maxSubArray(int[] nums) {
        int numberIntegers = nums.length;
        int[] currMax = new int[numberIntegers];
        currMax[0] = nums[0];
        int index = 1;
        int maxSum = nums[0];
        
        for (; index < numberIntegers; index++) {
            currMax[index] = Math.max(
                nums[index], 
                nums[index] + currMax[index-1] 
            );
            maxSum = Math.max(maxSum, currMax[index]);
        }
        
        return maxSum;
    }
}