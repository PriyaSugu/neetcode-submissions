class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lchar = s.charAt(left);
            char rchar = s.charAt(right);
            if (!Character.isLetterOrDigit(lchar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rchar)) {
                right--;
            } else if (Character.toLowerCase(lchar) != Character.toLowerCase(rchar)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
