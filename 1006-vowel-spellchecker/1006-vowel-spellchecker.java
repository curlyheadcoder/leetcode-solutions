class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for(int i = wordlist.length-1; i >= 0; i--){
            String word = wordlist[i];
            String lower = word.toLowerCase();
            String mask = maskVowel(lower);
            caseInsensitive.put(lower, word);
            vowelInsensitive.put(mask, word);
        }

        String [] ans = new String [queries.length];
        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            if(exact.contains(query)){
                ans[i] = query;
            }else{
                String lower = query.toLowerCase();
                String mask = maskVowel(lower);
                if(caseInsensitive.containsKey(lower)){
                    ans[i] = caseInsensitive.get(lower);
                }else if(vowelInsensitive.containsKey(mask)){
                    ans[i] = vowelInsensitive.get(mask);
                }else{
                    ans[i] = "";
                }
            }
        }
        return ans;
    }
    private String maskVowel(String word){
        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()){
            if("aeiou".indexOf(ch) >= 0){
                sb.append('*');
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}