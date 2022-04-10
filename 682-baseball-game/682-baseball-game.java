class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for(String s: ops) {
            if(s.equals("C")) {
                sum -= stack.pop();
            } else if(s.equals("D")) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else if(s.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.peek();
                stack.push(num1);
                stack.push(num1 + num2);
                sum += stack.peek();
            } else {
                int num = Integer.parseInt(s);
                stack.push(num);
                sum += num;
            }
        }
        return sum;
    }
}