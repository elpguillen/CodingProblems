class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 segments and used all characters, add to result
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            // Avoid out of bounds
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            // Skip invalid segments (e.g. leading zeros, >255)
            if (!isValid(segment)) continue;

            current.add(segment);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}