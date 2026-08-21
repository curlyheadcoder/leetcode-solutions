class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right){
            swap(s,left,right); 
            left++;
            right--;
        }
    }
    private void swap(char [] s, int pos1, int pos2){
        char temp = s[pos1];
        s[pos1] = s[pos2];
        s[pos2] = temp;
    }
}