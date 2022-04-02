class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return (checkPalidrome(s, l + 1, r) || checkPalidrome(s, l, r - 1));
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean checkPalidrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}