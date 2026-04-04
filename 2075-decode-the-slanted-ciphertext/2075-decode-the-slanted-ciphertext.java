class Solution {
    public String decodeCiphertext(String str, int rows) {
        int n = str.length();
        int cols = n/rows;
        StringBuilder res = new StringBuilder();
        for(int st = 0; st < cols; st++){
            int i = 0, j = st;
            while(i < rows && j < cols){
                res.append(str.charAt(i*cols+j));
                i++;
                j++;
            }
        }
        // remove trailing spaces
        int end = res.length()-1;
        while(end >= 0 && res.charAt(end) == ' '){
            end--;
        }
        return res.substring(0, end+1);
    }
}