class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for(char c: num.toCharArray()) {
            int n = c - '0';
            while(!stack.isEmpty() && stack.peek() > n && count < k) {
                stack.pop();
                count++;
            }
            stack.push(n);
        }
        
        while(count < k) {
            stack.pop();
            count ++;
        }
        
        StringBuilder op = new StringBuilder();
        while(!stack.isEmpty()) {
            op.append(Character.forDigit(stack.pop(), 10));
        }
        op.reverse();
        String result = new String(op);
        return result.replaceFirst("^0+(?!$)", "");
    }
}