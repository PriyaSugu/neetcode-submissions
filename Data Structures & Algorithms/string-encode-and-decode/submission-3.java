class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str: strs){
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        for(int i = 0; i < str.length(); ){
            int j = i;
            while(str.charAt((j)) != '#'){
                j++;
            }
            // System.out.println(str.charAt(i) +" "+ str.charAt(j));

            int len = Integer.parseInt(str.substring(i,j));
            // System.out.println(len);
            i = j + 1;
            j = i + len;
            res.add(str.substring(i, j));
            i = j;
            // System.out.println(str.charAt(i) +" "+ str.charAt(j));

        }
        return res;
    }
}
