class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        if(m * k > bloomDay.length) {
            return -1;
        }
        
        for(int n: bloomDay) {
            start = Math.min(n, start);
            end = Math.max(n, end);
        }
        
        int mid, ans = -1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(isPossible(mid, bloomDay, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    boolean isPossible(int days, int[] bloomDay, int m, int k) {
        int adj = 0;
        int nBouq = 0;
        
        for(int i = 0; i < bloomDay.length; i++) {
            if(days - bloomDay[i] >= 0) {
                adj += 1;
                if(adj == k) {
                    nBouq += 1;
                    adj = 0;
                }
                if(nBouq == m) {
                    return true;
                }
            } else {
                adj = 0;
            }
        }
        return false;
    }
}