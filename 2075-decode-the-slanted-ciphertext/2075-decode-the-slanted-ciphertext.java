class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 0) return "";
        int n = encodedText.length();
        int columns = n/rows;

        StringBuilder res = new StringBuilder();
        for(int startCol = 0; startCol < columns; startCol++){
            int i = 0;
            int j = startCol;
            while(i < rows && j < columns){
                res.append(encodedText.charAt(i * columns + j));
                i++;
                j++;
            }
        }
        // remove the trailing spaces 
        int end = res.length()-1;
        while(end >= 0 && res.charAt(end) == ' '){
            end--;
        }
        return res.substring(0, end+1);
    }
}