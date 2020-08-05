class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        int n = nums.length;
        int maxDistance = 0;
        for (int i = 0; i <= maxDistance; ++i) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= n - 1) {
                return true;
            }
        }
        return false;
    }

    // Time = O(n)
    // Space = O(1)
}