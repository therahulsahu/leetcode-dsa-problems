class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int one_before = 1;
        int two_before = 2;
        int ans = 0;
        for(int i = 3; i <= n; i++) {
            ans = one_before + two_before;
            one_before = two_before;
            two_before = ans;
        }
        return ans;
    }
}