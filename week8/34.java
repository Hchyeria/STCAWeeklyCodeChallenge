class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = find(nums, target, true);
        if (left == -1) {
            return res;
        }
        res[0]  = left;
        res[1] = find(nums, target, false);
        return res;
    }
    
    private int find(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (isLeft) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        int pre = isLeft ? left : right;
        int after = isLeft ? right : left;
        
        if (nums[pre] == target) {
            return pre;
        } else if (nums[after] == target) {
            return after;
        }
        return -1;

    }
}