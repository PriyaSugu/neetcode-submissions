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

        int i = 0;
        while(i < str.length()){
            int j = i;
           
            while(str.charAt(j) != '#'){
                j++;
            }
            // System.out.println(j);
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            decodedStr.add(str.substring(i,j));
            // System.out.println(decodedStr);
            i = j;
        }

        return decodedStr;

    }
}
