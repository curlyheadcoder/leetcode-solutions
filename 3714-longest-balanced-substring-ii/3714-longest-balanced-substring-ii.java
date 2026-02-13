class Solution {
    public int longestBalanced(String s) {
        /*
                Prefix Difference (Hashing) Technique
        */


        // counts of character should be equal
        int maxLen  = 0; 
        // case 1 : Single Character contributing to the result
        maxLen = Math.max(maxLen, longestSingleChar(s));
        // case 2 : Two Character contributing to the result
        maxLen = Math.max(maxLen, solveTwo(s, 'a', 'b', 'c'));
        maxLen = Math.max(maxLen, solveTwo(s, 'a', 'c', 'b'));
        maxLen = Math.max(maxLen, solveTwo(s, 'b', 'c', 'a'));
        // case 3 : Three (all) Character contributing to the result
        maxLen = Math.max(maxLen, solveThree(s));

        return maxLen;
    }
    //---------------- Single Character -------------- //
    private int longestSingleChar(String s){
        int max = 1, count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    // --------------- Two Characters ---------------- //
    private int solveTwo(String s, char x, char y, char splitChar){
        int maxLen = 0;
        int start = 0;
        for(int i = 0; i <= s.length(); i++){
            if(i == s.length() || s.charAt(i) == splitChar){
                maxLen = Math.max(maxLen, solveSegment(s, start, i-1, x, y));
                start = i + 1;
            }
        }
        return maxLen;
    }
    private int solveSegment(String s, int left, int right, char x, char y){
        if(left > right) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, left - 1);
        int diff = 0, maxLen = 0;
        for(int i = left; i <= right; i++){
            if(s.charAt(i) == x) diff++;
            else if(s.charAt(i) == y) diff--;

            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen, i - map.get(diff));
            }else{
                map.put(diff, i);
            }
        }
        return maxLen;
    }
    // ---------------- Three Character --------------- //
    private int solveThree(String s){
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        int aCount = 0, bCount = 0, cCount = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a') aCount++;
            else if(ch == 'b') bCount++;
            else cCount++;

            int diffAB = aCount - bCount;
            int diffAC = aCount - cCount;

            String key = diffAB + "#" + diffAC;

            if(map.containsKey(key)){
                maxLen = Math.max(maxLen, i - map.get(key));
            }else{
                map.put(key, i);
            }
        }
        return maxLen;
    }
}