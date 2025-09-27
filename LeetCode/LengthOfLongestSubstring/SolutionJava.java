class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        java.util.Map<Character, Integer> lastPos = new java.util.HashMap<>();
        int maxLen = 0;
        int left = 0; // start index of current window

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If we've seen this character before and it's inside the current window,
            // move left to one position after its last seen index.
            if (lastPos.containsKey(c) && lastPos.get(c) >= left) {
                left = lastPos.get(c) + 1;
            }

            // Update last seen index for current character
            lastPos.put(c, right);

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}