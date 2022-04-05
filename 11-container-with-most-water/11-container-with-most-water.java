class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while(l < r) {
            maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]) {
                l++;
            } else if(height[l] > height[r]){
                r--;
            } else {
                l++;
                r--;
            }
        }
        return maxWater;
    }
}