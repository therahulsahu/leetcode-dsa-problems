class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = weights[0];
        int e = 0;
        
        for(int n: weights) {
            e += n; // e is total sum
            s = Math.min(n, s);
        }
        int mid, ans = -1;
        while(s <= e) {
            mid = s + (e - s) / 2;
            if(isPossible(mid, weights, days)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
    
    boolean isPossible(int capacity, int[] weights, int days) {
        int nDay = 1;
        int weight = 0;
        
        for(int n: weights) {
            if(n > capacity) 
                return false;
            
            if(n + weight > capacity) {
                nDay += 1;
                weight = n;
                if(nDay > days)
                    return false;
            } else {
                weight += n;
            }
        }
        return true;
    }
}