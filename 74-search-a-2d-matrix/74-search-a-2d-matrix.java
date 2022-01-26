class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length, col = matrix[0].length;
        // col = row size (no. of cols)
        // row = col size (no. of rows)
        
        int n = row * col;
        
        int start = 0, end = n - 1, mid;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            int element = matrix[mid / col][mid % col];
            
            if(element == target) {
                return true;
            }
            
            if(element < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}