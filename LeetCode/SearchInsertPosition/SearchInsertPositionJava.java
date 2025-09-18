class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            // target found so return mid
            if (nums[mid] == target)
                return mid;
            // target greater than nums[mid], search right half
            else if (nums[mid] < target)
                left = mid + 1;
            // target less than nums[mid], search left half
            else
                right = mid - 1;
        }

        return left;
    }
}