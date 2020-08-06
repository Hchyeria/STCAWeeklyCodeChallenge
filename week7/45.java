class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int n = nums.length;
        int step = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            if (i > cur) {
                step++;
                if (cur == max) {
                    return -1;
                }
                cur = max;
                if (cur >= n - 1) {
                    break;
                }
            }
            
            max = Math.max(max, i + nums[i]);
        }
        return step;
    }

    // Time = O(n)
    // Space = O(1)
}