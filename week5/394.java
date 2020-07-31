public class Solution {
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Deque<Integer> nums = new LinkedList<>();
        Deque<StringBuilder> sbs = new LinkedList<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                sbs.offerFirst(sb);
                nums.offerFirst(num);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = sbs.pollFirst();
                int count = nums.pollFirst();
                for (int j = 0; j < count; ++j) {
                    tmp.append(sb);
                }
                sb = tmp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n)
}