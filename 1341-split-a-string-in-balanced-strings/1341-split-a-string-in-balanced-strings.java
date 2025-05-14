class Solution {
    public int balancedStringSplit(String s) {
        int bal = 0, count = 0;
        for(char c : s.toCharArray()){
            if(c == 'L') bal++;
            else if(c == 'R') bal--;
            if(bal == 0) count++;
        }
        return count;
    }
}