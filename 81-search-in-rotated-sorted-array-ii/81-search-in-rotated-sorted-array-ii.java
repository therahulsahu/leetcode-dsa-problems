class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            
            if(nums[mid] == target) {
                return true;
            }
            
            if( (nums[start] == nums[mid]) && (nums[end] == nums[mid]) ) {
                ++start;
                --end;
            }else if(nums[start] <= nums[mid]) {
                if((nums[start] <= target) && (target < nums[mid])) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if((target <= nums[end]) && (target > nums[mid])) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}