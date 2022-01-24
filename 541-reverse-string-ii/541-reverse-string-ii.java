class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for(int i = 0; i < a.length; i += 2 * k) {
            int lo = i, hi = Math.min(i + k - 1, a.length - 1);
            while(lo < hi) {
                char temp = a[lo];
                a[lo] = a[hi];
                a[hi] = temp;
                lo++;
                hi--;
            }
        }
        return new String(a);
    }
}