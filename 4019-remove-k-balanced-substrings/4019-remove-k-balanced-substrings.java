class Solution {
    public String removeSubstring(String s, int k) {
        if(s == null || s.isEmpty() || k <= 0) return s;
        int n = s.length();
        StringBuilder dummy = new StringBuilder();
        int [] arr = new int [n];
        int top = 0;
        int len = 2 * k;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            dummy.append(c);
        
            if(top > 0 && dummy.charAt(top-1) == c){
                arr[top] = arr[top-1] + 1;
            }else{
                arr[top] = 1;
            }
            top++;
    
            while(top >= len && dummy.charAt(top-1) == ')' && arr[top-1] >= k){
                int lastOpen = top - k - 1;
                if(lastOpen >= 0 && dummy.charAt(lastOpen) == '(' && arr[lastOpen] >= k){
                    top -= len;
                    dummy.setLength(top);
                }else{
                    break;
                }
            }
        }
        return dummy.toString();
    }
}