class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1.0 / x;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            if (n < 0) {
                return half * half * (1.0 / x);
            } else {
                return half * half * x;
            }
        }
    }
    // Time Complexity: O(log(n))
    // Space Complexity: O(1)
}