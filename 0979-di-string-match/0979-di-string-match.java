class Solution {
    public int[] diStringMatch(String s) {
        int [] res = new int [s.length() + 1];
        int left = 0, right = s.length();
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I') res[idx++] = left++;
            else res[idx++] = right--;
        }
        if(s.charAt(s.length()-1) == 'I') res[idx] = left;
        else res[idx] = right;
        return res;
    }
}