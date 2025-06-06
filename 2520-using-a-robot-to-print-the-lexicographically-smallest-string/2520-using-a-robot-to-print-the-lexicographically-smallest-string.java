class Solution {
    public String robotWithString(String s) {
        int [] freq = new int [26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int smallest = 0;
        for(char ch : s.toCharArray()){
            stack.push(ch);
            freq[ch - 'a']--;

            while(smallest < 26 && freq[smallest] == 0){
                smallest++;
            }
            while(!stack.isEmpty() && stack.peek() - 'a' <= smallest){
                res.append(stack.pop());
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}