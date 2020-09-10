class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; ++i) {
            while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i % n]) {
                res[stack.pollFirst()] = nums[i % n];
            }
            if (i < n) {
                stack.offerFirst(i);
            }
        }
        return res;
    }
    // Time = O(n)
    // Space = o(n)
}