class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroPos = 0;
        
        // setting non zeros at start
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroPos] = nums[i];
                lastNonZeroPos++;
            }
        }
        
        // filling zeros at end
        while(lastNonZeroPos < nums.length) {
            nums[lastNonZeroPos++] = 0;
        }
    }
}