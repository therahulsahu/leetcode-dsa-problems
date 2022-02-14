class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        StringBuilder op = new StringBuilder();
        solve(digits, op, 0, letters, result);
        return result;
    }
    
    private void solve(String digits, StringBuilder op, int index, String[] letters, List<String> result) {
        if(index == digits.length()) {
            result.add(new String(op));
            return;
        }
        
        int digit = digits.charAt(index) - '0';
        for(char c: letters[digit].toCharArray()) {
            op.append(c);
            solve(digits, op, index + 1, letters, result);
            op.deleteCharAt(op.length() - 1);
        }
    }
}