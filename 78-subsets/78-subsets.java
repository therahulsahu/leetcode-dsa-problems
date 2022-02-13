class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, temp, 0, answer);
        return answer;
    }
    private void solve(int[] nums, List<Integer> temp, int index, List<List<Integer>> answer) {
        if(index == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        solve(nums, temp, index + 1, answer);
        temp.add(nums[index]);
        solve(nums, temp, index + 1, answer);
        temp.remove(temp.size() - 1);
    }
}