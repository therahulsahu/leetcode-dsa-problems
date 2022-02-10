class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for(int i = 1; i <= nums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int count = 0;
        for(int i = 0; i < sums.length; ++i) {
            for(int j = i + 1; j < sums.length; ++j) {
                if(sums[j] - sums[i] == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
}