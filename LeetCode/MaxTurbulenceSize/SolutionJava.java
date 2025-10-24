class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;
        
        if (n < 2) return n;

        int maxLen = 1;
        int left = 0; // Start of the window

        for (int right = 1; right < n; right++) {
            int cmp = Integer.compare(arr[right - 1], arr[right]);
            if (cmp == 0) {
                // Equal elements reset the turbulence
                left = right;
            } else if (right == n - 1 || cmp * Integer.compare(arr[right], arr[right + 1]) != -1) {
                // Pattern breaks — calculate length and reset
                maxLen = Math.max(maxLen, right - left + 1);
                left = right;
            }
        }

        return maxLen;
    }
}