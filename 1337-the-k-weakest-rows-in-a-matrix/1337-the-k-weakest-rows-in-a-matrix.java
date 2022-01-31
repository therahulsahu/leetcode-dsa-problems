class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] rows = new int[mat.length];
        for(int i = 0; i < mat.length; i++) {
            int sum = 0;
            for(int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            rows[i] = sum;
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
}