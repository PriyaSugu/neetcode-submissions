class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(){}
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache;
    Node lru;
    Node mru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lru = new Node();
        mru = new Node();
        lru.next = mru;
        mru.prev = lru;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
        }else{
            if(cache.size() == capacity){
                cache.remove(lru.next.key);
                removeNode(lru.next);
                
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            addNode(node);
        }
    }
//lru - 1 - 2 - 3 - mru
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node){
        node.next = mru;
        node.prev = mru.prev;
        mru.prev.next = node;
        mru.prev = node;
    }
}
