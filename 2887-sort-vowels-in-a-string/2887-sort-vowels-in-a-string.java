class Solution {
    public String sortVowels(String s) {
        String vowels = "AEIOUaeiou";
        // Step 1. Collect all teh vowels
        List<Character> vList = new ArrayList<>();
        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                vList.add(ch);
            }
        }
        // Step 2. sort the vowels
        Collections.sort(vList);

        // Step 3. Create/Build the result 
        StringBuilder res = new StringBuilder();
        int idx = 0;
        for(char ch : s.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                res.append(vList.get(idx++));    // replace with sorted vowel
            }else{
                res.append(ch);     // keep consonants
            }
        }
        return res.toString();
    }
}