class Solution {
    public String robotWithString(String s) {
        int [] freq = new int [26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        char [] stack = new char [s.length()];
        int top = -1;
        StringBuilder res = new StringBuilder();
        int smallest = 0;
        for(char ch : s.toCharArray()){
            freq[ch -'a']--;
            stack[++top] = ch;
            while(smallest < 26 && freq[smallest] == 0){
                smallest++;
            }
            while(top >= 0 && (stack[top] - 'a') <= smallest){
                res.append(stack[top--]);
            }
        }
        while(top >= 0) res.append(stack[top--]);
        return res.toString();
    }
}