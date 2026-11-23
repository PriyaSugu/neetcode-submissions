class TimeMap {

    class Node<K,V>{
        public K time;
        public V val;
        Node(K time, V val){
            this.time = time;
            this.val = val;
        }
    }
    HashMap<String, List<Node<Integer,String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key) || timeMap.get(key).size() < 1){
            return "";
        }
        List<Node<Integer, String>> values = timeMap.get(key);
        int l = 0, r = values.size();
        while(l < r){
            int m = l + (r-l)/2; 
            if(values.get(m).time <= timestamp){
                l = m + 1;
            }else{
                r = m;
            }
        }
        return l == 0? "" :values.get(l - 1).val;
    }
}
