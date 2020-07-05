class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0
           || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        helper(matrix, res, 0, m, n);
        return res;
    }
    
    private void helper(int[][] matrix, List<Integer> res, int offset, int m, int n) {
        if (m == 0 || n == 0) return;
        else if (m == 1) {
            for (int i = 0; i < n; ++i) {
                res.add(matrix[offset][offset + i]);
            }
        } else if (n == 1) {
            for (int i = 0; i < m; ++i) {
                res.add(matrix[i + offset][offset]);
            }
        } else {
            for (int i = 0; i < n - 1; ++i) {
                res.add(matrix[offset][offset + i]);
            }
            for (int i = 0; i < m - 1; ++i) {
                res.add(matrix[offset + i][offset + n - 1]);
            }
            for (int i = n - 1; i > 0; --i) {
                res.add(matrix[offset + m - 1][offset + i]);
            }
            for (int i = m - 1; i > 0; --i) {
                res.add(matrix[offset + i][offset]);
            }
            helper(matrix, res, offset + 1, m - 2, n - 2);
        }
        return;
    }

    // Time = O(m * n)
    // Space = O(min(m, n))
}