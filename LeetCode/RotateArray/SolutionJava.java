class Solution {

    /**
     * Rotates array by k steps, where k is non-negative.
     * To do so begin by reversing the entire array first.
     * Then reverse up to but not including the kth index.
     * Then reverse from the kth index to the end of the array.
     * 
     * @param nums array of integers
     * @param k non-negative integer indicating steps to rotate by
     */
    public void rotate(int[] nums, int k) {
        int rotateK = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, rotateK);
        reverse(nums, rotateK, nums.length);
    }

    /**
     * Reverses the contents of an array between a given starting (inclusive) and 
     * ending index (exclusive).
     * 
     * @param nums  array of integers
     * @param start starting index
     * @param end   ending index
     */
    public void reverse(int[] nums, int start, int end) {
        int numsLength = nums.length;
        int mid = (end - start) / 2;
        int startIndex = start;
        int endIndex = Math.min(numsLength, end) - 1;
        int index = 0;
        
        if (numsLength < start)
            return;
        
        while (index < mid) {
            int tempStart = nums[startIndex];
            nums[startIndex++] = nums[endIndex];
            nums[endIndex--] = tempStart;
            index++;
        }
    }
}