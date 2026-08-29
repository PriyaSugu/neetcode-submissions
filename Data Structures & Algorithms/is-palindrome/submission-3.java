class Solution {
    public boolean isPalindrome(String s) {

        int left = 0, right = s.length()-1;
        while(left < right){
            char lchar = Character.toLowerCase(s.charAt(left));
            char rchar = Character.toLowerCase(s.charAt(right));
            if(!Character.isLetterOrDigit(lchar)){
                left++;
            }else if(!Character.isLetterOrDigit(rchar)){
                right--;
            }else if(rchar != lchar){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
        
    }
}
