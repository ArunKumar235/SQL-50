class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    // maintains insertion order, oldest(lru) ..... newest
    private final LinkedHashSet<Integer> tracker;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.tracker = new LinkedHashSet<>();    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        tracker.remove(key);
        tracker.add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            tracker.remove(key);
            tracker.add(key);
        }else{
            if(map.size() == capacity){
                int lruKey = tracker.iterator().next();
                
                map.remove(lruKey);
                tracker.remove(lruKey);
            }
            map.put(key, value);
            tracker.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */