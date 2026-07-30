class Solution {
    public boolean checkValidString(String s) {
        // String s = "((*))"
        // push ---> open par into st1 
        // Two Pointer 
        int st = 0, end = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st++;
                end++;
            }else if(ch == ')'){
                st--;
                end--;
            }else{
                st--;
                end++;
            }
            if(end < 0) return false;
            st = Math.max(st, 0);
        }
        return st == 0;
    }
}