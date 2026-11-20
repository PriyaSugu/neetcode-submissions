class TimeMap {

    class Pair<K,V>{
        public K time;
        public V val;

        Pair(K time, V val){
            this.time = time;
            this.val = val;
        }
    }

    Map<String, List<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key) || timeMap.get(key).size() < 1){
            return "";
        }
        List<Pair<Integer, String>> values = timeMap.get(key);
        int l = 0, r = values.size() - 1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(values.get(m).time <= timestamp){
                l = m + 1; 
            }else{
                r = m - 1;
            }
        }
        return r < 0? "" : values.get(r).val;
    }
}
