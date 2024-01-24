class Solution {
    /**
     * For an array with N unique items and size M where N <= M, places all unique items
     * between index 0 and (N - 1) in sorted order. All items past index (N - 1) are repeated.
     * @param nums sorted array (non-decreasing order)
     * @return array with index 0 to (N - 1) having unique items in sorted order
     */
    public int removeDuplicates(int[] nums) {
        int indexLastUnique = 0;
        int numUnique = 1;

        for (int curIndex = 0; curIndex < nums.length; curIndex++) {
            if (nums[curIndex] != nums[indexLastUnique]) {
                indexLastUnique++;
                nums[indexLastUnique] = nums[curIndex];
                numUnique++;
            }
        }
        return numUnique;
    }
}