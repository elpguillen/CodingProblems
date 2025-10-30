class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums); // Sort the array first
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first three numbers

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If this sum is closer to target, update closestSum
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                // Move pointers
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // Exact match found
                    return sum;
                }
            }
        }

        return closestSum;
    }
}