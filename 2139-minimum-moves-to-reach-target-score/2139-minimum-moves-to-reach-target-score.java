class Solution {
    public int minMoves(int target, int maxDoubles) {
        int countOperations = 0;
        while(target != 1) {
            countOperations++;
            if(target % 2 != 0){
                target -= 1;
            } else {
                if(maxDoubles > 0) {
                    target /= 2;
                    maxDoubles--;
                } else {
                    countOperations += target - 2;
                    break;
                }
            }
        }
        return countOperations;
    }
}