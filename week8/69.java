class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mul = (long) mid * mid;
            if (mul == x) {
                return mid;
            } else if (mul < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}