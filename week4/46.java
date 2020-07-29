class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        helper(res, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            res.add(convert(nums));
            return;
        }
        int n = nums.length;
        for (int i = index; i < n; ++i) {
            swap(nums, index, i);
            helper(res, nums, index + 1);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    private List<Integer> convert(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
    
    // Time complexity: O(n + n*(n-1) + n*(n-1)*(n-2) + ... + n!) = O(n!), ignore the toList
    // Space complexity: O(n)

}