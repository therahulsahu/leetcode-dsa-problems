class Solution {
    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        if(pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if(target < nums[0]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }
    
    int binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return - 1;
    }
    
    int getPivot(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            
            if(nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                if(nums[mid] < nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}