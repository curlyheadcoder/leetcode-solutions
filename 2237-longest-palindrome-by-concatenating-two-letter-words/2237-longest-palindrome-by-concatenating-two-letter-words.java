class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        boolean hasCenter = false;

        for(String word : words){
            String reversed = "" + word.charAt(1) + word.charAt(0);
            if(map.getOrDefault(reversed, 0) > 0){
                res += 4;
                map.put(reversed, map.get(reversed) - 1);
            }else{
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for(String key : map.keySet()){
            if(key.charAt(0) == key.charAt(1) && map.get(key) > 0){
                hasCenter = true;
                break;
            }
        }
        if(hasCenter){
            res += 2;
        }
        return res;
    }
}