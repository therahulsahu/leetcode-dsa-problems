class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0, nLadder = 0;
        int i = 0;
        for(i = 1; i < heights.length; i++) {
            if(heights[i] > heights[i - 1]) {
                sum += heights[i] - heights[i - 1];
                maxHeap.add(heights[i] - heights[i-1]);
                if(sum > bricks) {
                    if(nLadder < ladders) {
                        sum -= maxHeap.poll(); 
                        nLadder++;
                    } else {
                        break;
                    }
                }
            }
        }
        return i - 1;
    }
}