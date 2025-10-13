class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add a copy of the current subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);
            // Recurse
            backtrack(nums, i + 1, current, result);
            // Exclude nums[i] (backtrack)
            current.remove(current.size() - 1);
        }
    }
}