class Solution {
    public int splitArray(int[] nums, int m) {
        int start = Integer.MIN_VALUE, end = 0;
        
        for(int n: nums) {
            start = Math.max(n, start);
            end += n;
        }
        
        if(m == 1) {
            return end;
        }
        
        int mid;
        while(start < end) {
            mid = start + (end - start) / 2;
            
            if(isPossible(mid, nums, m)) {
                end = mid;
            } else {
                start = mid + 1;
            }   
        }
        return start;
    }
    
    boolean isPossible(int mid, int[] nums, int m) {
        int sum = 0, part = 1;
        for(int n: nums) {
            if(n > mid) {
                return false;   
            }
            sum += n;
            if(sum > mid) {
                sum = n;
                part += 1;
                if(part > m){
                    return false;
                }
            }
        }
        return true;
    }
}