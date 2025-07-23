class Solution {
    public int maximumGain(String s, int x, int y) {
        // Ensure "ab" is higher value operation
        if(x < y){
            // Reverse the string and swap x and y
            s = new StringBuilder(s).reverse().toString();
            int temp = x;
            x = y;
            y = temp;
        }
        // First Pass: remove all "ab" and get x points
        StringBuilder remaining = new StringBuilder();
        int totalPoints = 0;
        for(char ch : s.toCharArray()){
            int len = remaining.length();
            if(len > 0 && remaining.charAt(len-1) == 'a' && ch == 'b'){
                remaining.deleteCharAt(len-1);
                totalPoints += x;
            }else{
                remaining.append(ch);
            }
        }
        // Second Pass: remove all "ba" and get y points
        StringBuilder finalString = new StringBuilder();
        for(char ch : remaining.toString().toCharArray()){
            int len = finalString.length();
            if(len > 0 && finalString.charAt(len-1) == 'b' && ch == 'a'){
                finalString.deleteCharAt(len-1);
                totalPoints += y;
            }else{
                finalString.append(ch);
            }
        }
        return totalPoints;
    }
}