class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        
        int low = 1, high = position[n - 1] - position[0], mid;
        int ans = -1;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(canPlaceBalls(mid, position, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    boolean canPlaceBalls(int force, int[] position, int m) {
        int count = 1, pos = position[0];
        
        for(int i = 1; i < position.length; i++) {
            if(position[i] - pos >= force) {
                count++;
                pos = position[i];
            }
            
            if(count >= m) {
                return true;
            }
        }
        return false;
    }
}