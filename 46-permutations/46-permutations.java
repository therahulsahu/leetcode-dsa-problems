class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for(int n: nums) {
            list.add(n);
        }
        solve(list, result, 0);
        return result;
    }
    
    void solve(List<Integer> nums, List<List<Integer>> result, int index) {
        //base case
        if(index >= nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        for(int i = index; i < nums.size(); i++) {
            swap(nums, index, i);
            solve(nums, result, index + 1);
            swap(nums, index, i);
        }
    }
    
    void swap(List<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }
}