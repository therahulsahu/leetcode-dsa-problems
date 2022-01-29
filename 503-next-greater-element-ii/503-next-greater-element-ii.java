class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(result, -1);
        
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        // second time
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
        }
        
        return result;
    }
}