class Solution {
    // Stack
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int n = height.length;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[stack.peekFirst()] < height[i]) {
                int pre = stack.pollFirst();
                if (!stack.isEmpty()) {
                    int left = stack.peekFirst();
                    res += (Math.min(height[left], height[i]) - height[pre]) * (i - left - 1); 
                }
            }
            stack.offerFirst(i);
        }
        return res;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    // Two Pointer
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int n = height.length;
        int res = 0;
        int left = 0, right = n - 1;
        int leftMax = height[0], rightMax = height[n - 1];
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left++];
            } else {
                res += rightMax - height[right--];
            }
        }
        return res;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}