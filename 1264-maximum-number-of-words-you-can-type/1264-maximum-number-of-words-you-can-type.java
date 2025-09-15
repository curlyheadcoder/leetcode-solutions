class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()){
            set.add(ch);
        } 
        int count = 0;
        String [] words = text.split(" ");
        for(String word : words){
            for(char ch : word.toCharArray()){
                if(set.contains(ch)){
                    count++;
                    break;
                }
            }
        }
        return words.length - count;
    }
}