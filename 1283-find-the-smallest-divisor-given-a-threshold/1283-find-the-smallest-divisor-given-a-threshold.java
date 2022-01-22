class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = Integer.MIN_VALUE;
        
        for(int n: nums) {
            end = Math.max(n, end);
        }
        
        int mid;
        while(start < end) {
            mid = start + (end - start) / 2;
            
            if(check(nums, mid, threshold)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    boolean check(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for(int n: nums) {
            sum += Math.ceil((double) n / divisor);
        }
        return sum <= threshold;
    }
}