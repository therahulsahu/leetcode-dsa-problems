class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll()[0];
        }
        return result;
    }
}