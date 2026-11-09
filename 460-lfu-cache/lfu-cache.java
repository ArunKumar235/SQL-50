// PreReq: LC 146, LC 895
// ToDo: Replace LinkedHashSet with Map + DoublyLL
class FreqNode{
    int freq;
    LinkedHashSet<Integer> tracker;
    FreqNode(int freq){
        this.freq = freq;
        // insertion order works fine, (accessing order not required)
        // bcoz during updation(accessing), key is removed and shifted to next lruTracker
        // oldest(LRU) .... last used(MRU) 
        this.tracker = new LinkedHashSet<>();
    }
}

class LFUCache {
    int capacity;
    // keys are evicted only at the time of insertion of another key
    // thus, minFreq is always downShifted directly to 1
    // minFreq is always strictly incremented by 1 either during get or put 
    int minFreq;
    // key, val
    Map<Integer, Integer> vault;
    // key, freq
    Map<Integer, Integer> freq;
    // freq, FreqNode
    Map<Integer, FreqNode> freqAddress;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.vault = new HashMap<>();
        this.freq = new HashMap<>();
        this.freqAddress = new HashMap<>();
    }
    
    public int get(int key) {
        if(!vault.containsKey(key)) return -1;

        int oldFreq = freq.get(key);

        removeNode(key, oldFreq);

        freq.put(key, oldFreq+1);
        addNewNode(key, oldFreq+1);
        return vault.get(key);
    }
    
    public void put(int key, int value) {
        if(vault.containsKey(key)){
            vault.put(key, value);
            get(key); // updates freq and LRU order
            return;
        }else{
            // Evict LFU + LRU key if cache is full
            if(vault.size() == capacity){
                int lruKey = freqAddress.get(minFreq).tracker.iterator().next();

                removeNode(lruKey, minFreq);

                vault.remove(lruKey);
                freq.remove(lruKey);
            }
            minFreq = 1;
            vault.put(key, value);
            freq.put(key, 1);
            addNewNode(key, 1);
        }
    }

    private void addNewNode(int key, int newFreq){
        if(!freqAddress.containsKey(newFreq)){
            freqAddress.put(newFreq, new FreqNode(newFreq));
        }

        FreqNode node = freqAddress.get(newFreq);
        node.tracker.add(key);
    }

    private void removeNode(int key, int oldFreq){
        FreqNode oldNode = freqAddress.get(oldFreq);

        oldNode.tracker.remove(key);
        // LRU bucket(doubly ll) is empty
        if (oldNode.tracker.isEmpty()) {
            freqAddress.remove(oldFreq);

            if (minFreq == oldFreq) {
                minFreq++; // case being, key freq increased, so +1
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */