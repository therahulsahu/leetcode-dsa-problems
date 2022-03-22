class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        int i = n - 1;
        k -= n;
        int maxChar = 0;
        while(k != 0) {
            k += 1;
            maxChar = k >= 26 ? 26 : k;
            res[i] = (char) (maxChar + 96);
            i--;
            k -= maxChar;
        }
        
        return new String(res);
    }
}