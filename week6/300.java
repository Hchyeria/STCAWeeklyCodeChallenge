class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        
        int n = nums.length;
        int size = 1;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > res[size - 1]) {
                res[size++] = nums[i];
            } else {
                int index = findSmallestLarger(res, 0, size - 1, nums[i]);
                if (index >= 0 && index < size) {
                    res[index] = nums[i];
                }
            }
        }
        return size;
    }
    
    private int findSmallestLarger(int[] array, int left, int right, int val) {
        while (left <=right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == val) {
                return mid;
            } else if (array[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Time = O(n * log(n))
    // Space = O(n)
}