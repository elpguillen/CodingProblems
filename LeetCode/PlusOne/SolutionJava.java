class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;        // no carry, just increment
                return digits;      // done
            }
            digits[i] = 0;          // set to 0 and continue carry
        }

        // If we got here, it means all digits were 9 and need a bigger array
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}