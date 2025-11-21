class Solution {
    fun longestValidParentheses(s: String): Int {
        var left = 0
        var right = 0
        var maxLen = 0

        // Pass 1: left → right
        for (c in s) {
            if (c == '(') left++
            else right++

            if (left == right) {
                maxLen = maxOf(maxLen, 2 * right)
            } else if (right > left) {
                left = 0
                right = 0
            }
        }

        left = 0
        right = 0

        // Pass 2: right → left
        for (i in s.indices.reversed()) {
            val c = s[i]
            if (c == '(') left++
            else right++

            if (left == right) {
                maxLen = maxOf(maxLen, 2 * left)
            } else if (left > right) {
                left = 0
                right = 0
            }
        }

        return maxLen
    }
}