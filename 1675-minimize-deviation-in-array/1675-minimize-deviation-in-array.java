class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        for(int n: nums) {
            if((n & 1) == 1) {
                n *= 2;
            }
            min = Math.min(min, n);
            maxHeap.add(n);
        }
        int diff = Integer.MAX_VALUE;
        while((maxHeap.peek() & 1) == 0) {
            int top = maxHeap.poll();
            diff = Math.min(diff, top - min);
            min = Math.min(min, top / 2);
            maxHeap.add(top / 2);
        }
        
        return Math.min(diff, maxHeap.poll() - min);
    }
}