class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n: nums) {
            
            // even check
            if((countDigits(n) & 1) == 0) {
                count++;
            }
        }
        return count;
    }
    
    int countDigits(int n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }
}