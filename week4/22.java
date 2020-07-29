class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, new StringBuilder(), n, n);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            helper(res, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right > left) {
            sb.append(")");
            helper(res, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    // Time = O(2 ^ (n * 2))
    // Space = O(2 * n)
}