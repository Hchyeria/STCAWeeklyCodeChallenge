class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || (coins.length == 0 && amount != 0)) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                // need to make sure dp[i - c] != Integer.MAX_VALUE
                if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)
}