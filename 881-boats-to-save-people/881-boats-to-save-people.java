class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int l = 0, r = people.length - 1;
        
        while(l <= r) {
            if(people[l] + people[r] <= limit) {
                res += 1;
                l += 1;
                r -= 1;
            } else {
                r -= 1;
                res += 1;
            }
        }
        return res;
    }
}