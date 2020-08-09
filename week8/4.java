class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            int one = findKthInTwoArray(nums1, 0, nums2, 0, (m + n) / 2);
            int two = findKthInTwoArray(nums1, 0, nums2, 0, (m + n) / 2 + 1);
            return ((double) one + two) / 2.0;
        } else {
            return (double) findKthInTwoArray(nums1, 0, nums2, 0, (m + n) / 2 + 1);
        }
    }
    
    private int findKthInTwoArray(int[] a, int aLeft, int[] b, int bLeft, int k) {
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        }
        if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aLeft], b[bLeft]);
        }
        
        int aValue = k / 2 - 1 + aLeft < a.length ? a[k / 2 - 1 + aLeft] : Integer.MAX_VALUE;
        int bValue = k / 2 - 1 + bLeft < b.length ? b[k / 2 - 1 + bLeft] : Integer.MAX_VALUE;
        if (aValue <= bValue) {
            return findKthInTwoArray(a, aLeft + k / 2, b, bLeft, k - k / 2);
        } else {
            return findKthInTwoArray(a, aLeft, b, bLeft + k / 2, k - k / 2);
        }
    }
}