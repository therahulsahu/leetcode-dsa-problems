class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) {
            return 0;
        }
        
        //bfs
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                char[] wordChar = currentWord.toCharArray();
                
                for(int j = 0; j < wordChar.length; ++j) {
                    char orignalChar = wordChar[j];
                    
                    for(char k = 'a'; k <= 'z'; ++k) {
                        if(wordChar[j] == k) continue;
                        
                        wordChar[j] = k;
                        String newWord =  String.valueOf(wordChar);
                        
                        if(newWord.equals(endWord)) {
                            return level + 1;
                        }
                        
                        if(set.contains(newWord)) {
                            queue.add(newWord);
                            set.remove(newWord);
                        }
                    }
                    
                    wordChar[j] = orignalChar;
                }
            }
            
            level++;
        }
        
        return 0;
    }
}