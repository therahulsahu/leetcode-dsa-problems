class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> output = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        
        for (int[] i : intervals) {
            
            if(i[0] <= end) {
                end = end > i[1] ? end : i[1];
            } else {
                output.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
            
        }
        
        output.add(new int[]{start, end});
        
        return output.toArray(new int[0][]);
    }
}