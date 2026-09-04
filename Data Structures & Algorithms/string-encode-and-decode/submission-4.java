class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s: strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < str.length()){
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, j+len));
            i = j + len;
            j = i;
        }
        return res;
    }
}
