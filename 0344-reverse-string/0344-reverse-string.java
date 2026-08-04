class Solution {
    public void reverseString(char[] s) {
        int st = 0, end = s.length-1;
        while(st < end){
            swap(s, st, end);
            st++;
            end--;
        }
    }
    private void swap(char [] str, int pos1, int pos2){
        char temp = str[pos1];
        str[pos1] = str[pos2];
        str[pos2] = temp;
    }
}