class Solution {
    // DFS
    // Time Limit Exceeded
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        return dfs(visited, nums, 0, target, k, n - 1);
    }
    
    private boolean dfs(boolean[] visited, int[] nums, int sum, int target, int k, int index) {
        if (k == 0) return true;
        if (target == sum && dfs(visited, nums, 0, target, k - 1, nums.length - 1)) {
            return true;
        }
        for (int i = index; i >= 0; --i) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(visited, nums, sum + nums[i], target, k, index)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}