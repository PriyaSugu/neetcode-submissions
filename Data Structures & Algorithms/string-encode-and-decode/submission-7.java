class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodedStr = new StringBuilder();
        for(String str: strs){
            encodedStr.append(str.length()).append('#').append(str);
        }

        return encodedStr.toString();

    }

    public List<String> decode(String str) {
        List<String> decodedStr = new ArrayList<>();

        int j = 0;
        for(int i = 0; i < str.length(); ){
           
            while(str.charAt(j) != '#'){
                j++;
            }
            // System.out.println(j);
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            decodedStr.add(str.substring(j, j + len));
            // System.out.println(decodedStr);
            i = j + len;
            j = i;
        }

        return decodedStr;

    }
}
