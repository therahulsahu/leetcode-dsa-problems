class Solution {
    public int singleNumber(int[] nums) {
        int singleElement = 0;
        for(int i: nums){
            singleElement ^= i;
        }
        return singleElement;
    }
}