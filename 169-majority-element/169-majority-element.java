class Solution {
    public int majorityElement(int[] nums) {
        // Boyce-Moore Algorithm
        int count = 0;
        int candidate = 0;
        
        for(int n : nums) {
            if(count == 0) {
                candidate = n;
            }
            
            count += (candidate == n) ? 1 : -1;
        }
        return candidate;
    }
}