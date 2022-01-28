class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n]; // will contain index to next greater element
        
        Stack<Integer> stack = new Stack<>(); // will contain index
        
        for(int i = n - 1; i >= 0; i--) {
            while(stack.size() > 0 && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if(stack.size() > 0) {
                result[i] = stack.peek();
            } else {
                result[i] = i;
            }
            stack.push(i);
        }
        
        for(int i = 0; i < result.length; i++) {
            result[i] = result[i] - i; // nextGreaterElementIdx - itself index; = no. of days
        }
        return result;
    }
}