class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        if(n == 0) return digits;
        
        if(digits[n-1] != 9) {
            digits[n-1] += 1;
            return digits;
        }
        
        int i = n - 1;
        do {
            digits[i] = 0;
            i--;
            if(i == -1) {
                int[] newArr = new int[n + 1];
                Arrays.fill(newArr, 0);
                newArr[0] = 1;
                return newArr;
            }
        } while(digits[i] == 9);
        digits[i] += 1;
        return digits;
    }
}