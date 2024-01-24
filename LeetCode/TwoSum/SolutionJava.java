class Solution {
    /**
     * Finds the indices of two numbers in an array that sum up to a target value.
     * Assumes each input has exactly one solution and cannot use same element twice.
     * 
     * @param nums   an array(guaranteed with at least 2 items) of integers
     * @param target the target sum value 
     * @return       indices of the two numbers that add up to target (given one valid solution exists)
     */
    public int[] twoSum(int[] nums, int target) {
        // hashmap is used for easy retrieval and insertion
        HashMap<Integer, Integer> numsPresent = new HashMap<Integer, Integer>();

        int[] result = {0, 1};

        // if the first two numbers add up to target then solution found
        if (nums[0] + nums[1] == target) {
            return result;
        }

        // using math: a + b = c or nums[i] + nums[j] = target, where
        //   i and j are the indices of the numbers that add up to target,
        //   one can rearrange to nums[i] = target - nums[j]
        //   meaning that we can check if the difference between target and
        //   current value of the array is present in the hash map.
        //   If it is then we have a pair that sums up to target.
        numsPresent.put(nums[0], 0);
        numsPresent.put(nums[1], 1);

        for (int index = 2; index < nums.length; index++) {
            int difference = target - nums[index];

            if (numsPresent.get(difference) != null) {
                result[0] = index;
                result[1] = numsPresent.get(difference);
                return result;
            }

            numsPresent.put(nums[index], index);
        }

        return result;
    }
}