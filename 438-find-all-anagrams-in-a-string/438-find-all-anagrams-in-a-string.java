class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        if(s.length() < p.length()) {
            return result;
        }
        
        //char count array
        int[] pCount = new int[26];
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pCount[c - 'a']++;
        }
        
        int[] sCount = new int[26];
        // setting the window
        int windowSize = p.length();
        int i = 0;
        while(i < windowSize) {
            char c = s.charAt(i);
            sCount[c - 'a']++;
            i++;
        }
        
        if(checkEqual(pCount, sCount)) {
            result.add(i - windowSize);
        }
        
        while(i < s.length()) {
            // add new char
            char c = s.charAt(i);
            sCount[c - 'a']++;
            
            // del old char
            c = s.charAt(i - windowSize);
            sCount[c - 'a']--;
            
            i++;
            
            if(checkEqual(pCount, sCount)) {
                result.add(i - windowSize);
            }
            
        }
        return result;
    }
    
    boolean checkEqual(int[] count1, int[] count2) {
        for(int i = 0; i < count1.length; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}