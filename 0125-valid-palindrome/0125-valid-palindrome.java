class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right){
            // skip non-alphanumeric character
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            // compare characters now case-insensitive
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}