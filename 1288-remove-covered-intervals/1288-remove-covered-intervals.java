class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        
        if(intervals.length <= 1) {
            return intervals.length;
        }
        
        int count = 0;
        for(int i = 0, j = 1; j < intervals.length; ++j) {
            if(intervals[i][1] >= intervals[j][1]) {
                count += 1;
            } else {
                i = j;
            }
        }
        return intervals.length - count;
    }
}