class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        
        // char count array for s1
        int[] count1 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            count1[index]++;
        }
        
        // char count array for s2
        int[] count2 = new int[26];
        int windowSize = s1.length();
        
        // set the first window
        int i = 0;
        while(i < windowSize) {
            char c = s2.charAt(i);
            count2[c - 'a']++;
            i++;
        }
        
        if(checkEqual(count1, count2)) {
            return true;
        }
        
        // slide window for the rest
        while(i < s2.length()) {
            // adding new char
            char c = s2.charAt(i);
            count2[c - 'a']++;
            
            // deleting prev char
            c = s2.charAt(i - windowSize);
            count2[c - 'a']--;
            
            if(checkEqual(count1, count2)) {
                return true;
            }
            
            i++;
        }
        
        return false;
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