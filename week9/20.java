class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (stack.isEmpty() || c != stack.pollFirst()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
}