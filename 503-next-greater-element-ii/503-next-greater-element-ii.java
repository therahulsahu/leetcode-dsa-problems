class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] tempNums = new int[n * 2];
        for(int i = 0; i < n; i++) {
            tempNums[i] = tempNums[n + i] = nums[i];
        }
        
        int[] result = new int[n * 2];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(result, -1);
        
        for(int i = 0; i < tempNums.length - 1; i++) {
            while(!stack.isEmpty() && tempNums[stack.peek()] < tempNums[i]) {
                result[stack.pop()] = tempNums[i];
            }
            stack.push(i);
        }
        
        return Arrays.copyOf(result, n);
    }
}