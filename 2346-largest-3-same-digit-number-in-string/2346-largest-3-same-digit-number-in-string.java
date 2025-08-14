class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String ans = "###";
        for(int i = 1; i <= n-2; i++){
            if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i+1)){
                // Candidate.
                char a = num.charAt(i);
                if(a > ans.charAt(0)){
                    ans = new StringBuilder().append(a).append(a).append(a).toString();
                }
            }
        }
        if(ans.equals("###")) return "";
        return ans;
    }
}