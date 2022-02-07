class Solution {
    public char findTheDifference(String s, String t) {
        int sInt = 0;
        for(char c: s.toCharArray()) {
            sInt += c;
        }
        
        int tInt = 0;
        for(char c: t.toCharArray()) {
            tInt += c;
        }
        
        return (char) (tInt - sInt);
    }
}