class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        // Base case: if the current combination has k numbers
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Explore choices
        for (int i = start; i <= n; i++) {
            current.add(i);              // Choose
            backtrack(result, current, n, k, i + 1); // Explore
            current.remove(current.size() - 1);       // Unchoose
        }
    }
}