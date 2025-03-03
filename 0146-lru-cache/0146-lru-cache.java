class LRUCache {
    private final int capacity;
    private final Map<Integer,Integer> cache;
    private final Deque<Integer> order;
    
    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity,0.75f, true);
        this.order = new LinkedList<>();

    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        order.remove(key);
        order.addLast(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            order.remove(key);
        }
        else if(capacity <= cache.size()){
            int oldest = order.pollFirst();
            if(cache.containsKey(oldest)) cache.remove(oldest);
        }
        
        cache.put(key,value);
        order.addLast(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */