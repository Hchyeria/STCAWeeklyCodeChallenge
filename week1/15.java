class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int i = 2;
        while (i < n) {
            // need to pick the last element of the duplicate
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
            twoSum(nums, i, -nums[i], res);
            i++;
            
        }
        return res;
    }
    
    private void twoSum(int[] nums, int i, int target, 
                                 List<List<Integer>> res) {
        int left = 0;
        int right = i - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target
               && (right == i - 1 || nums[right + 1] != nums[right])) {
                res.add(Arrays.asList(nums[left++], nums[right--], nums[i]));
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
 
    }

    // For loop + Two Sum (sort + two pointers): Time complexity is O(n^2), space complexity is O(log(n)),
    //    because of quick sort (for primitive types).
}