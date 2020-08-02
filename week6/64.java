class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
                dp[i][j] = dp[i][j] == Integer.MAX_VALUE ? grid[i][j] : dp[i][j] + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Time = O(m * n)
    // Space = O(m * n) -> O(n)

    // optimise space
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
        int now = 1, old = 1;
        for (int i = 0; i < m; ++i) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < n; ++j) {
                dp[now][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[now][j] = Math.min(dp[now][j], dp[old][j]);
                }
                if (j > 0) {
                    dp[now][j] = Math.min(dp[now][j], dp[now][j - 1]);
                }
                dp[now][j] = dp[now][j] == Integer.MAX_VALUE ? grid[i][j] : dp[now][j] + grid[i][j];
            }
        }
        return dp[now][n - 1];
    }
}