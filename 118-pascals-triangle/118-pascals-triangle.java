class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row;
        for(int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for(int j = 0; j < i + 1; j ++) {
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    row.add(a + b);
                }
            }
            result.add(row);
        }
        return result;
    }
}