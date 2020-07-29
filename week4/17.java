class Solution {
    String[] data = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        
        helper(res, new StringBuilder(), digits);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char num = digits.charAt(sb.length());
        if (num == '1') {
            return;
        }
        String s = data[num - '2'];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            sb.append(c);
            helper(res, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Time = O(4^n)
    // Space = O(n)
}