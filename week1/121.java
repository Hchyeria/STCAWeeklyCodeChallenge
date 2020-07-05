class Solution {
    public int maxProfit(int[] prices) {
        // remember to check validity
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int globalMax = Integer.MIN_VALUE;
        for (int p : prices) {
            min = Math.min(p, min);
            globalMax = Math.max(p - min, globalMax);
        }
        return globalMax;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}