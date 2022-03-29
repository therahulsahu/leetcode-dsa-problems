class Solution {
    // this soln modifies the nums array, logic: cyclic sort
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] != i + 1) {
                int correctIdx = nums[i] - 1;
                if(nums[i] != nums[correctIdx]) {
                    swap(nums, i, correctIdx);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}