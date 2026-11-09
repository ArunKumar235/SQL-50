// https://leetcode.com/problems/maximum-frequency-stack/solutions/1862015/best-explanation-visually-by-hi-malik-2vck

class FreqStack {
    Map<Integer, Integer> freq; // val, freqCount
    Map<Integer, Stack<Integer>> map; // freqCount, values in order
    int maxFreq;
    public FreqStack() {
        this.freq = new HashMap<>();
        this.map = new HashMap<>();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);

        if(freq.get(val) > maxFreq){
            maxFreq++;
            map.put(maxFreq, new Stack<>());
        }

        map.get(freq.get(val)).push(val);
    }
    
    public int pop() {
        int val = map.get(maxFreq).pop();
        if(map.get(maxFreq).isEmpty()){
            map.remove(maxFreq);
            maxFreq--;
        }
        freq.put(val, freq.get(val)-1);
        if(freq.get(val) == 0){
            freq.remove(val);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */