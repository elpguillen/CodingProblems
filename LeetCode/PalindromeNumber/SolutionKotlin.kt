class Solution {
    fun isPalindrome(x: Int): Boolean {

        if (x < 0)
            return false

        var original = x
        var reversed = 0

        while (original != 0) {
            val digit = original % 10
            reversed = reversed * 10 + digit
            original /= 10
        }
        
        return x == reversed
    }
}