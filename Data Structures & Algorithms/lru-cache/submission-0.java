class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(){}
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node lru;
    Node mru;
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lru = new Node();
        mru = new Node();
        lru.next = mru;
        mru.prev = lru;
    }

    private void addNode(Node node){
        Node prev = mru.prev;
        mru.prev = node;
        node.next = mru;
        node.prev = prev;
        prev.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        int res = -1;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            res = node.val;
            removeNode(node);
            addNode(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
        }else{
            if(cache.size() == capacity){
                Node nodeToRemove = lru.next;
                removeNode(nodeToRemove);
                cache.remove(nodeToRemove.key);
            }
            Node node = new Node(key,value);
            cache.put(key, node);
            addNode(node);
        }
    }
}
