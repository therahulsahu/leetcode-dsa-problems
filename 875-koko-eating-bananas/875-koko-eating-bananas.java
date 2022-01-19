class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        
        for(int n: piles) {
            end = Math.max(n, end);
        }
        
        if(h == piles.length) {
            return end;
        }
        
        int mid, ans = -1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(isPossible(mid, piles, h)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    boolean isPossible(int k, int[] piles, int h) {
        
        int hour = 0;
        for(int pile : piles) {
            hour += Math.ceil((double) pile / k);
        }
        return hour <= h;
    }
}