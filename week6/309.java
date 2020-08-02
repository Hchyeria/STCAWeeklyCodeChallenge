class Solution {
    
    // hold[i]: max(hold[i - 1], unhold[i - 2] - A[i])
    // unHold[i]: max(hold[i - 1] + A[i] or unHold[i - 1])
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int unHold = 0, unHold2 = 0;
        int hold = -prices[0];
        
        for (int i = 1; i < n; ++i) {
            int pre = unHold;
            unHold = Math.max(hold + prices[i], unHold);
            hold = Math.max(hold, unHold2 - prices[i]);
            unHold2 = pre;
        }
        return unHold;
    }
    // Time = O(n)
    // Space = O(1)
}