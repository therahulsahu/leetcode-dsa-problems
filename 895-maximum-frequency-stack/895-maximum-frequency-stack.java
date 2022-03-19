class FreqStack {
    HashMap<Integer, Deque<Integer>> st;
    HashMap<Integer, Integer> freqMap;
    int maxFreq;
    public FreqStack() {
        st = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0);
        freq++;
        freqMap.put(val, freq);
        if(!st.containsKey(freq)) {
            st.put(freq, new ArrayDeque<>());
        }
        st.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int popped = st.get(maxFreq).pop();
        int freq = freqMap.get(popped);
        freq--;
        freqMap.put(popped, freq);
        if(st.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return popped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */