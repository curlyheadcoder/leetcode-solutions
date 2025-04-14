class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        int lengthGCD = findGCD(str1.length(), str2.length());
        return str1.substring(0, lengthGCD);
    }
    private int findGCD(int a, int b){
        while(b != 0){
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}