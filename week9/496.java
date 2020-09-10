class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        } 
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && stack.peekFirst() < nums2[i]) {
                map.put(stack.pollFirst(), nums2[i]);
            }
            stack.offerFirst(nums2[i]);
        }
        n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    // Time = O(n + m)
    // Space = O(n)
}