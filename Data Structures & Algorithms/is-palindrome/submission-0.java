class Solution {
    public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i<j; ){
            if(!isAlphaNum(s.charAt(i))) i++;
            else if(!isAlphaNum(s.charAt(j))) j--;
            else if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++; j--;
            }
            else{
                System.out.println(s.charAt(i)+" "+ s.charAt(j));
                return false;
            }

        }
        // if(i>=j) return true;
        return true;
    }
    public boolean isAlphaNum(char c){
        return ( c >= 'A' && c <= 'Z' ||
                 c >= 'a' && c <= 'z' ||
                 c >= '0' && c <= '9' );
    }
}
