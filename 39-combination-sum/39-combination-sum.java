class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(result, new ArrayList<>(), candidates, target,  0);
        return result;
    }
    
    void solve(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int index) {
        if(remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        else if(remain < 0) {
            return;
        }
        
        for(int i = index; i < candidates.length; ++i) {
            current.add(candidates[i]);
            solve(result, current, candidates, remain - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}