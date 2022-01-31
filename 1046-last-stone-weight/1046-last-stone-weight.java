class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n: stones) {
            maxHeap.add(n);
        }
        int result = 0;
        while(!maxHeap.isEmpty()) {
            if(maxHeap.size() >= 2) {
                int stone1 = maxHeap.poll();
                int stone2 = maxHeap.poll();
                if(stone1 != stone2) {
                    maxHeap.add(stone1 - stone2);
                }
            } else {
                result = maxHeap.poll();
            }
        }
        return result;
    }
}