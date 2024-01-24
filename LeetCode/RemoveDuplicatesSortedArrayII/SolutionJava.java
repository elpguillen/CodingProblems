class Solution {

    /**
     * In-place removal of elements that appear more than twice in a sorted
     * array of non-decreasing order
     * @param nums array of integers sorted in non-decreasing order
     * @return the amount of elements after removing duplicates
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 1)
            return 1;

        return moveMultipleDups(nums);
    }

    /**
     * auxiliary function that performs the in-place removal of elements for
     * the function removeDuplicates
     * @param nums array of integers sorted in non-decreasing order
     * @return the amount of elements after removing duplicates
     */
    public int moveMultipleDups(int[] nums) {
        int numsLength = nums.length;
        int lastPlaced = 0;
        int duplicateCount = 0;

        /*
         * keep track of the index of the last element in which the element
         * has not appeared more than twice (lastPlaced)
         * 
         * for each element:
         *    check how many times the currently traversed element has been
         *      previously found
         *    
         *    when the duplicate count is less than 2, updated lastPlaced and put
         *      the element in current index into lastPlaced. 
         */
        for (int curIndex = 1; curIndex < numsLength; curIndex++) {

            if (nums[curIndex] == nums[lastPlaced]) {
                duplicateCount++;
            } else {
                duplicateCount = 0;
            }

            if (duplicateCount > 1) {
                continue;
            } else {
                lastPlaced++;
                nums[lastPlaced] = nums[curIndex];
            }
        }

        return lastPlaced + 1;
    }
}