class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -2, n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max) {
                end = i;
            }
            
            min = Math.min(min, nums[n - 1 - i]);
            if(nums[n - 1 - i] > min) {
                start = n - 1 - i;
            }
        }
        return end - start + 1;
    }
}