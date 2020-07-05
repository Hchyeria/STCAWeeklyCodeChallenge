class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            Integer other = map.get(target - nums[i]);
            if (other != null) {
                return new int[] {i, other};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }

    // Time = O(n)
    // Space = O(n)
}