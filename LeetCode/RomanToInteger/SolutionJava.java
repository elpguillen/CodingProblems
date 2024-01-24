class Solution {
    /**
     * Converts a roman numeral to decimal integer.
     * @param s string representation of roman numeral
     * @return Integer representation of roman numeral
     */
    public int romanToInt(String s) {

        Character[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};

        // Use hash map to store roman to integer conversion for each
        // roman numeral. key -> roman numeral, value -> decimal integer
        HashMap<Character, Integer> roman = new HashMap<>();

        for (int i = 0; i < symbols.length; i++) {
            roman.put(symbols[i], values[i]);
        }

        int result = 0;
        int sLength = s.length();

        /*
         * [a][b] -> check if a < b and if so subtract from total sum else add
         * [b] -> simply add when only one item left
         */
        for (int index = 0; index < sLength; index++) {
            int value = roman.get(s.charAt(index));
            if ( index + 1 < sLength && value < roman.get(s.charAt(index + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }
}