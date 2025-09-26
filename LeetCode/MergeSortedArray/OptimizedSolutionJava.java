class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointerIndex1 = m - 1;
        int pointerIndex2 = n - 1;
        int nextItem = m + n - 1;

        // Merge from the back
        while (pointerIndex1 >= 0 && pointerIndex2 >= 0) {
            if (nums1[pointerIndex1] > nums2[pointerIndex2]) {
                nums1[nextItem--] = nums1[pointerIndex1--];
            } else {
                nums1[nextItem--] = nums2[pointerIndex2--];
            }
        }

        // Copy remaining nums2 elements (if any)
        while (pointerIndex2 >= 0) {
            nums1[nextItem--] = nums2[pointerIndex2--];
        }
    }
}