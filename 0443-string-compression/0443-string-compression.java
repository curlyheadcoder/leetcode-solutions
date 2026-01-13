class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        int i = 0;
        while(i < n){
            char curr = chars[i];
            int count = 0;
            
            // find count of duplicates
            while(i < n && chars[i] == curr){
                count++;
                i++;
            }

            // Now do the assign work
            chars[idx] = curr;
            idx++;
            
            // if count is greater than 1
            if(count > 1){
                String countStr = String.valueOf(count);
                for(char ch : countStr.toCharArray()){
                    chars[idx] = ch;
                    idx++;
                }
            }
        }
        return idx;
    }
}