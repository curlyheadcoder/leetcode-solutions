class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numericString = new StringBuilder();
        for(char ch : s.toCharArray()){
            numericString.append(ch - 'a' + 1);
        }

        String numStr = numericString.toString();
        for(int i = 0; i < k; i++){
            int sum = 0;
            for(char ch : numStr.toCharArray()){
                sum = sum + ch - '0';
            }
            numStr = String.valueOf(sum);
        }
        return Integer.parseInt(numStr);
    }
}