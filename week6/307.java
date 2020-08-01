class NumArray {
    private long[] tree;
    private int[] A;
    private void add(int i, int val) {
        int n = tree.length;
        while (i < n) {
            tree[i] += val;
            i += (i & (-i));
        }
    }
    // Time = O(log(n))

    private long query(int i) {
        long sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }
    // Time = O(log(n))

    public NumArray(int[] nums) {
        int n = nums.length;
        tree = new long[n + 1];
        A = new int[n];
        for (int i = 0; i < n; ++i) {
            add(i + 1, nums[i]);
            A[i] = nums[i];
        }
    }
    // Time = O(n * log(n))

    public void update(int i, int val) {
        add(i + 1, val - A[i]);
        A[i] = val;
    }
    // Time = O(log(n))

    public int sumRange(int i, int j) {
        return (int) (i == 0 ? query(j + 1) : query(j + 1) - query(i));
    }
    // Time = O(log(n))
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */