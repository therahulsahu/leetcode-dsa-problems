class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] rows = new int[mat.length];
        for(int i = 0; i < mat.length; i++) {
            rows[i] = numOnes(mat[i]);
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        
        for(int i = 0; i < rows.length; i++) {
            maxHeap.add(new int[]{rows[i], i});
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll()[1];
        }
        
        return result;
    }
    
    
    // binary search for no. of ones
    private int numOnes(int[] rows) {
        int lo = 0, hi = rows.length;
        int mid;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(rows[mid] == 1){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    
}