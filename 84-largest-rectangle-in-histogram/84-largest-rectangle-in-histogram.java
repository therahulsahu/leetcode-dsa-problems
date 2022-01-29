class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsl = nearestSmallerToLeft(heights);
        int[] nsr = nearestSmallerToRight(heights);      

        int maxArea = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
    
    int[] nearestSmallerToLeft(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    
    int[] nearestSmallerToRight(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                result[i] = heights.length;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}