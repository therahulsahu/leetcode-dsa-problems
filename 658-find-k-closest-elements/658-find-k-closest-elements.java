class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if(o2[0] == o1[0]){
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        for(int n: arr) {
            maxHeap.add(new int[]{ Math.abs(n - x), n });
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }
        Collections.sort(result);
        return result;
    }
}