class LFUCache {
    private final int capacity;
    private final Map<Integer,Integer> cache; // Key - value 저장
    private final Map<Integer,Integer> frequency; // key - frequency 저장
    private final TreeMap<Integer,LinkedHashSet<Integer>> frequencyMap ;// 사용 빈도별 키 목록
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequency = new HashMap<>();
        this.frequencyMap = new TreeMap<>();
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;
        // 빈도수 증가
        updateFrequency(key);
        return this.cache.get(key);
    }
    
    public void put(int key, int value) {

        if(this.cache.containsKey(key)){
            this.cache.put(key,value);
            updateFrequency(key);
            return;
        }

        if(this.cache.size() >= this.capacity){
            // 가장 빈도수 낮은 key 제거
            evictLFU();
        }

        this.cache.put(key,value);
        this.frequency.put(key,1);
        this.frequencyMap.computeIfAbsent(1 , k -> new LinkedHashSet<>()).add(key);
    }

    private void updateFrequency(int key){
        int cnt = this.frequency.get(key);
        this.frequency.put(key,cnt+1);

        this.frequencyMap.get(cnt).remove(key);
        if(this.frequencyMap.get(cnt).isEmpty()){
            this.frequencyMap.remove(cnt);
        }

        this.frequencyMap.computeIfAbsent(cnt+1 , k -> new LinkedHashSet<>()).add(key);
    }

    private void evictLFU(){
        int leastFreq = this.frequencyMap.firstKey();
        LinkedHashSet<Integer> keys = this.frequencyMap.get(leastFreq);
        int evictKey = keys.iterator().next(); // 가장 오래된 키 제거

        keys.remove(evictKey);
        if(keys.isEmpty()){
            this.frequencyMap.remove(leastFreq);
        }
        
        this.cache.remove(evictKey);
        this.frequency.remove(evictKey);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */