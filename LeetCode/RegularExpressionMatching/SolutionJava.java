class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true; // empty string matches empty pattern

        // Pre-fill patterns that can match empty string (like a*, a*b*, etc.)
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // Case 1: '*' means zero occurrences of p[j-2]
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: '*' means one or more occurrences if match
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Single character or '.'
                    if (pc == '.' || pc == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[n][m];
    }
}