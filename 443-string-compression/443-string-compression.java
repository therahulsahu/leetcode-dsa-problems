class Solution {
    public int compress(char[] chars) {
        int i = 0, ansIdx = 0;
        
        while(i < chars.length) {
            int j = i + 1;
            
            while(j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            
            chars[ansIdx++] = chars[i];
            
            int count = j - i;
            
            if(count > 1) {
                String s = Integer.toString(count);
                for(char c : s.toCharArray()) {
                    chars[ansIdx++] = c;
                }
            }
            i = j;
        }
        
        return ansIdx;
    }
}