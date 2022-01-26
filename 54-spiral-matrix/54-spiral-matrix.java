class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        
        // indices
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = row - 1;
        int endingCol = col - 1;
        
        int count = 0, total = row * col;
        
        while(count < total) {
            
            // starting row
            for(int i = startingCol; i <= endingCol && count < total; i++) {
                result.add(matrix[startingRow][i]);
                count++;
            }
            startingRow++;
            
            // ending col
            for(int i = startingRow; i <= endingRow && count < total; i++) {
                result.add(matrix[i][endingCol]);
                count++;
            }
            endingCol--;
            
            // ending row
            for(int i = endingCol; i >= startingCol && count < total; i--) {
                result.add(matrix[endingRow][i]);
                count++;
            }
            endingRow--;
            
            // starting col
            for(int i = endingRow; i >= startingRow && count < total; i--) {
                result.add(matrix[i][startingCol]);
                count++;
            }
            startingCol++;
        }
        return result;
    }
}