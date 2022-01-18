class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = binarySearch(nums, target, true);
        if(result[0] != -1) {
            result[1] = binarySearch(nums, target, false);
        }
        return result;
    }
    int binarySearch(int[] nums, int target, boolean firstOcc) {
        int left = 0, right = nums.length - 1;
        int mid, ans = -1;
        while(left <= right){
            mid = left + (right - left) / 2;
            
            if(nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                ans = mid;
                if(firstOcc) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
        }
        return ans;
    }
}