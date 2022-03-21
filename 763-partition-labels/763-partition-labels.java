class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        
        int maxIdx = 0;
        for(int i = 0, j = 0; i < s.length(); ++i) {
            maxIdx = Math.max(maxIdx, lastIndex[s.charAt(i) - 'a']);
            if(i == maxIdx) {
                res.add(i - j + 1);
                j = i + 1;
            }
        }
        return res;
    }
}