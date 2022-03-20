class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = minOf(nSwaps(tops[0], tops, bottoms),
                    nSwaps(bottoms[0], tops, bottoms),
                    nSwaps(tops[0], bottoms, tops),
                    nSwaps(bottoms[0], bottoms, tops));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    int minOf(int a, int b, int c, int d) {
        return Math.min(Math.min(Math.min(a, b), c), d);
    }
    
    int nSwaps(int target, int[] tops, int[] bottoms) {
        int swapCount = 0;
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] != target) {
                if(bottoms[i] != target) {
                    return Integer.MAX_VALUE;
                } else {
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}