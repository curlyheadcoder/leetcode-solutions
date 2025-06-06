class Solution {
    public String removeDigit(String number, char digit) {
        String res = "";
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == digit){
                StringBuilder sb = new StringBuilder(number);
                sb.deleteCharAt(i);
                String current = sb.toString();
                if(current.compareTo(res) > 0){
                    res = current;
                }
            }
        }
        return res;
    }
}