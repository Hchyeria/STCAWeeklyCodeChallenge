class Solution {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int globalMax = Integer.MIN_VALUE;
        for (int num : nums) {
            res = Math.max(num, res + num);
            globalMax = Math.max(res, globalMax);
        }
        return globalMax;
    }

    // Time = O(n)
    // Space = O(1)
}