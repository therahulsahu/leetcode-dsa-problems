class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        // kinda sliding window
        for(int i = 0; i < nums.length; i++) {
            
            if(i > k){
              set.remove(nums[i - k - 1]);  
            } 
            
            // set.add returns false if element is already present
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}