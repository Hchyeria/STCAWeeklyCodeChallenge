class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> tmp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[index]);
        dfs(res, nums, index + 1, tmp);
        tmp.remove(tmp.size() - 1);
        dfs(res, nums, index + 1, tmp);
    }

    // Time = O(2 ^ n)
    // Space = O(n)
}