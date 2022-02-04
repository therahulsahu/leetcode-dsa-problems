class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Converting all 0 to -1
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        int sum = 0; // current
        int max = 0; // final-ans
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // put reference in the starting of 0 & -1 in the starting  
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i]; // cumulative sum
            if(map.containsKey(sum)){ // if cumulative sum key :- 0, -1, 1 already present
                int last = map.get(sum); 
                max = Math.max(max, i - last); 
            }
            else{
                map.put(sum, i);
            }
        }
        return max;
    }
}