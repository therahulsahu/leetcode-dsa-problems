class Solution {
    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                set.remove(stack.peek());
                stack.pop();
            }
            stack.push(c);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}