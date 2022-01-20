class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        
        while(start < end) {
            mid = start + (end - start) / 2;
            if(((mid & 1) == 1 && nums[mid - 1] == nums[mid]) || ((mid & 1) == 0 && nums[mid] == nums[mid + 1])) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}