class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<Integer>());
        for(int n: nums) {
            int size = answer.size();
            for(int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(answer.get(i));
                subset.add(n);
                answer.add(subset);
            }
        }
        return answer;
    }
}