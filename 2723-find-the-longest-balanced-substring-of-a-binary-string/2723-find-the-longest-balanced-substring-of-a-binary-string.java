class Solution {
    public int findTheLongestBalancedSubstring(String s) {
       int ans = 0, zeroCount = 0, oneCount = 0;
       for(char c : s.toCharArray()){
        if(c == '0'){
            if(oneCount > 0){
                zeroCount = 0;
                oneCount = 0;
            }
            zeroCount++;
        }else{
            oneCount++;
            if(zeroCount >= oneCount){
                ans = Math.max(ans, oneCount*2);
            }
        }
       } 
       return ans;
    }
}