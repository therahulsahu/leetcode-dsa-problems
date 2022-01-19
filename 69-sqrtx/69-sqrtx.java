class Solution {
    public int mySqrt(int x) {
        // binary search
        
        int start = 0, end = x, mid;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            long sq = (long) mid * mid;
            
            if(sq == x) {
                return mid;
            }
            if(sq < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}