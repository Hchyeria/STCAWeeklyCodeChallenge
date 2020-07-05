class Solution {
    // TreeMap
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0
           || intervals[0].length != 2) {
            return intervals;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        
        List<int[]> res = new ArrayList<>();
        int count = 0;
        int pre = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (count == 0) {    
                pre = e.getKey();
            }
            count += e.getValue();
            if (count == 0) {
                res.add(new int[] {pre, e.getKey()});
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }

    // Time Complexity: O(n*log(n))
    // Space Complexity: O(n)

    // Sort
    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> res = new ArrayList<>();
        int[] pre = intervals[0];
        res.add(pre);
        
        for (int[] interval : intervals) {
            if (pre[1] >= interval[0]) {
                pre[1] = Math.max(pre[1], interval[1]);
            } else {
                pre = interval;
                res.add(pre);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    // Time Complexity: O(n*log(n))
    // Space Complexity: O(n)
}