class LRUCache {

    class Pair{
        int key, value;

        Pair(int key, int value){
        this.key = key;
        this.value = value;
        }
    }

    ArrayList<Pair> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayList<>();    
    }
    
    public int get(int key) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).key == key){
                int val = cache.get(i).value;
                Pair temp = cache.get(i);
                cache.remove(i);
                cache.add(temp);
                return val;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).key == key){
                cache.remove(i);
                cache.add(new Pair(key, value));
                return;
            }
        }
        if(cache.size() == capacity){
            cache.remove(0);
            cache.add(new Pair(key, value));
        }else{
            cache.add(new Pair(key, value));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */