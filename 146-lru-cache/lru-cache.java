class LRUCache {
    private final int capacity;
    // maintains insertion order, earliest inserted ....... newly inserted
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
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