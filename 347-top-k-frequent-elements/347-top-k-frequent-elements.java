class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}