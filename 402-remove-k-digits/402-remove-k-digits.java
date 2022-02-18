class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for(char c: num.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() > c && count < k) {
                stack.pop();
                count++;
            }
            stack.push(c);
        }
        
        while(count < k) {
            stack.pop();
            count ++;
        }
        
        StringBuilder op = new StringBuilder();
        while(!stack.isEmpty()) {
            op.append(stack.pop());
        }
        op.reverse();
        
        while(op.length() > 1 && op.charAt(0) == '0') {
            op.deleteCharAt(0);
        }
        return op.toString();
    }
}