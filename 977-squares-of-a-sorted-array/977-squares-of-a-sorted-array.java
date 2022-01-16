class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1;
        int k = j;
        
        while(i <= j) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                k--;
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                k--;
                j--;
            }
        }
        return ans;
    }
}