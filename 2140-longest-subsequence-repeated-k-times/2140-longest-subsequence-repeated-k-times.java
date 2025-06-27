class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        // TODO 1: Count frequency of each character
        int [] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        // TODO 2: Prepare list of valid characters (those with freq >= k), reverse-lex order
        List<Character> validChars = new ArrayList<>();
        for(int i = 25; i >= 0; i--){
            if(freq[i] >= k){
                validChars.add((char)(i + 'a'));
            }
        }
        // TODO 3: BFS initialization: start with empty string
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        String res = "";
        
        // TODO 4: BFS to build candidates
        while(!queue.isEmpty()){
            String curr = queue.poll();

            // TODO 5: Try appending each valid character
            for(char c : validChars){
                String next = curr + c;

                // TODO 6: Check if next * k is a subsequence of s
                if(isKRepeatedSubsequence(s, next, k)){
                    // TODO 7: If longer or lexicographically larger, update res
                    if(next.length() > res.length() ||
                        (next.length() == res.length() && next.compareTo(res) > 0)){
                            res = next;
                        }
                        // TODO 8: Add to queue to explore longer subsequences
                        queue.offer(next);
                }
            }
        }

        return res;
    }
    // TODO 9: Check if target * k is subsequence of source
    private boolean isKRepeatedSubsequence(String s, String t, int k){
        int tlen = t.length();
        int index = 0, count = 0;

        for(char c : s.toCharArray()){
            if(c == t.charAt(index)){
                index++;
                if(index == tlen){
                    count++;
                    if(count == k) return true;
                    index = 0;   // restart t again
                }
            }
        }
        return false;
    }
}
