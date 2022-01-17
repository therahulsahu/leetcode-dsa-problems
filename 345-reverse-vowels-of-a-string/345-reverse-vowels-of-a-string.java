class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        int left = 0, right = s.length() - 1;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder(s);
        while(left < right) {
            while(left < right && !set.contains(s.charAt(left))) {
                left++;
            }
            while(left < right && !set.contains(s.charAt(right))) {
                right--;
            }
            sb.setCharAt(left, s.charAt(right));
            sb.setCharAt(right, s.charAt(left));
            left++;
            right--;
        }
        return sb.toString();
    }
}