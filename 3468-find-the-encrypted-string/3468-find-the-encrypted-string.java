class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        StringBuilder encrypted = new StringBuilder();
        for(int i = 0; i < n; i++){
            int newIndex = (i+k) % n;
            encrypted.append(s.charAt(newIndex));
        }
        return encrypted.toString();
    }
}