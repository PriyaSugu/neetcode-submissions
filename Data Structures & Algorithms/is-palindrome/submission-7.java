class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while(left < right){
                if(Character.isLetterOrDigit(s.charAt(left))){
                    break;
                }
                left++;
            }
            while(left < right){
                if(Character.isLetterOrDigit(s.charAt(right))){
                    break;
                }
                right--;
            }
            if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
