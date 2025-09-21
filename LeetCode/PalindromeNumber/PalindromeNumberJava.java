class Solution {
    public boolean isPalindrome(int x) {

        // Edge Cases:
        //   1. Negative numbers can't be palindroms
        //   2. Numbers ending in zero (except zero by itself)
        if ( x < 0 || ((x % 10 == 0) && (x != 0)) )
            return false;

        int reverse = 0;

        // reverses half the number and places into "reverse" variable
        while (x > reverse) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return x == reverse || ( x == reverse / 10);
        
    }
}