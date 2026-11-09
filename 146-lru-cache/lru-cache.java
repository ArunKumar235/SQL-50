class LRUCache {
    private final int capacity;
    // maintains access order, oldest (lru) ....... newly accessed
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(16, 0.75f, true);
        // 16    - initial capacity
        // 0.75f - load factor
        // true  - enables access-order mode   
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
        }else{       
            if(map.size() == capacity){
                int lruKey = map.keySet().iterator().next();
                map.remove(lruKey);
            }
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */