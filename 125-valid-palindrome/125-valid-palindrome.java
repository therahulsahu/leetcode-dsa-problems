class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while(left < right) {
            while(!Character.isLetterOrDigit(s.charAt(left)) && left < right){
                left++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right))  && right > left){
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}