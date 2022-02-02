class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        PriorityQueue<int[][]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o1 -> -o1[0][0]));
        
        for(int[] point: points) {
            maxHeap.add(new int[][]{{point[0] * point[0] + point[1] * point[1]}, point});
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll()[1];
        }
        return result;
    }
}