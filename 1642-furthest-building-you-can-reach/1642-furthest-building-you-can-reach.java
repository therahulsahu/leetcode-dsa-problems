class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int nBricks = 0;
        for(int i = 0; i < heights.length - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if(d > 0) {
                minHeap.add(d);
            }
            if(minHeap.size() > ladders) {
                nBricks += minHeap.poll();
            }
            if(nBricks > bricks) {
                return i;
            }
        }
        return heights.length - 1;
    }
}