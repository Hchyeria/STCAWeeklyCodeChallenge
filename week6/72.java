class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        } else if (word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        } else if (word1.isEmpty() || word2.isEmpty()) {
            return word1.isEmpty() ? word2.length() : word1.length();
        }
        
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i == 0 ? j : i;
                    continue;
                }
                int nothing = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    nothing = dp[i - 1][j - 1];
                }
                int replace = dp[i - 1][j - 1] + 1;
                int add = dp[i][j - 1] + 1;
                int remove = dp[i - 1][j] + 1;
                dp[i][j] = min(new int[] {nothing, replace, add, remove});
            }
        }
        return dp[m][n];
    }
    
    private int min(int[] nums) {
        int res = nums[0];
        for (int i : nums) {
            res = Math.min(res, i);
        }
        return res;
    }

    // m: word1.length()
    // n: word2.length()
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n) -> O(m)

    // optimise space
    public int minDistance2(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        } else if (word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        } else if (word1.isEmpty() || word2.isEmpty()) {
            return word1.isEmpty() ? word2.length() : word1.length();
        }
        
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[2][n + 1];
        int now = 1, old = 1;
        for (int i = 0; i <= m; ++i) {
            old = now;
            now = 1 - now;
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    dp[now][j] = i == 0 ? j : i;
                    continue;
                }
                int nothing = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    nothing = dp[old][j - 1];
                }
                int replace = dp[old][j - 1] + 1;
                int add = dp[now][j - 1] + 1;
                int remove = dp[old][j] + 1;
                dp[now][j] = min(new int[] {nothing, replace, add, remove});
            }
        }
        return dp[now][n];
    }
}