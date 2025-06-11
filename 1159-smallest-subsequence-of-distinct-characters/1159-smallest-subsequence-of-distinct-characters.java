class Solution {
    public String smallestSubsequence(String s) {
        int [] freq = new int [26];
        boolean [] inStack = new boolean [26];
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;
            if(inStack[ch -'a']) continue;
            while(!st.isEmpty() && ch < st.peek() && freq[st.peek() - 'a'] > 0){
                inStack[st.pop() - 'a'] = false;
            }
            st.push(ch);
            inStack[ch - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for(char ch : st){
            res.append(ch);
        }
        return res.toString();
    }
}