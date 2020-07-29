class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] index = new int[n];
        Arrays.fill(index, -1);
        
        boolean[] line = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] reverse = new boolean[2 * n - 1];
        dfs(res, index, 0, n, line, diagonal, reverse);
        return res;
    }
    
    private void dfs(List<List<String>> res, int[] tmp, int index, int n, 
                     boolean[] line, boolean[] diagonal, boolean[] reverse) {
        if (index  == n) {
            res.add(convert(tmp));
        }
        
        for (int i = 0; i < n; ++i) {
            if (!line[i] && !diagonal[index + i] && !reverse[n - 1 - index + i]) {
                flip(line, diagonal, reverse, i, index);
                tmp[index] = i;
                dfs(res, tmp, index + 1, n, line, diagonal, reverse);
                flip(line, diagonal, reverse, i, index);
            }
        }
    }
    
    private void flip(boolean[] line, boolean[] diagonal, boolean[] reverse, int i, int index) {
        int n = line.length;
        line[i] = !line[i];
        diagonal[i + index] = !diagonal[i + index];
        reverse[n - 1 - index + i] = !reverse[n - 1 - index + i];
    }
    
    private List<String> convert(int[] array) {
        List<String> res = new ArrayList<>();
        int n = array.length;
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            for (int j = 0; j < n; ++j) {
                if (j == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
            sb.setLength(0);
        }
        return res;
    }

    // Time complexity: O(n*n!), this is an upper bound, which is not tight
    // Space complexity: O(n)
}