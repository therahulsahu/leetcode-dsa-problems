class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        
        // transpose
        for(int i = 0; i < row; i++) {
            for(int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reverse
        for(int i = 0; i < col / 2; i++) {
            for(int j = 0; j < row; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][row - 1 - i];
                matrix[j][row - 1 - i] = temp;
            }
        }
    }
}