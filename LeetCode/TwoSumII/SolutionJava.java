class Solution {
    /**
     * Finds the indices of two numbers that sum to 'target' in a sorted
     * (non-decreasing order) array and returns them added by one.
     * Assume there is exactly one solution.
     * 
     * @param nums   array sorted in non-decreasing order
     * @param target target number
     * @return indices added by one of the two numbers that sum to 'target'
     */
    public int[] twoSum(int[] numbers, int target) {
        int frontPtr = 0;
        int endPtr = numbers.length - 1;
        int[] result = new int[2];

        while (frontPtr < endPtr) {
            int sum = numbers[frontPtr] + numbers[endPtr];
            
            if (sum == target) {
                result[0] = ++frontPtr;
                result[1] = ++endPtr;
                break;
            } else if (sum < target) {
                frontPtr++;
            } else {
                endPtr--;
            }
        }

        return result;
    }
}