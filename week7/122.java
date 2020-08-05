class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int n = prices.length;
        int pre = prices[0];
        for (int i = 1; i < n; ++i) {
            if (prices[i] > pre) {
                sum += prices[i] - pre;
            }
            pre = prices[i];
        }
        return sum;
    }
    // Time = O(n)
    // Space = O(1)
}