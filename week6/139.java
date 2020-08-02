class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String i : wordDict) {
            set.add(i);
        }
        int n = s.length();
        char[] input = s.toCharArray();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i - 1; ++j) {
                if (dp[j] && set.contains(new String(input, j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    // n: length of s
    // m: size of dict
    // Time Complexity: O(m + n^2)
    // Space Complexity: O(m + n)
}