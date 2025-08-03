class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n == 0)
            return;
        
        int pointerIndex1 = m - 1;
        int pointerIndex2 = n - 1;
        int nextItem = m + n - 1;
        
        while (pointerIndex1 >= 0 && pointerIndex2 >= 0) {
            if(nums1[pointerIndex1] > nums2[pointerIndex2])
                nums1[nextItem--] = nums1[pointerIndex1--];
            else
                nums1[nextItem--] = nums2[pointerIndex2--];
        }
        
        while (pointerIndex1 >= 0) {
            nums1[nextItem--] = nums1[pointerIndex1--];
        }
        
        while (pointerIndex2 >= 0) {
            nums1[nextItem--] = nums2[pointerIndex2--];
        }
    }
}