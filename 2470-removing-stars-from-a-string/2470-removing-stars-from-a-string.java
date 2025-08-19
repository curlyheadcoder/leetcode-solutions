class Solution {
    public String removeStars(String s) {
        char [] arr = new char [s.length()];
        int i  = 0;
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            if(ch == '*'){
                i--;
            }else{
                arr[i] = ch;
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < i; j++){
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}