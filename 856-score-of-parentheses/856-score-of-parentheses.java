class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int score = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(score);
                score = 0;
            } else {
                int val = Math.max(2 * score, 1);
                score = stack.pop() + val;
            }
        }
        return score;
    }
}

// ( ) ( ) ( )
//   1   2   3  => 3
// 0 - 1 - 2 -
         
// ( ( ( ) ) )
// 0 0 0   
//       1 2 4