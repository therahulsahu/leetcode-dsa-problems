class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = 0;
        for(int i = 0; i < a.length; i += n + 1) {
            int lo = i, hi = i;
            while(hi + 1 < a.length && a[hi + 1] != ' ') {
                hi++;
            }
            n = hi - lo + 1;
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