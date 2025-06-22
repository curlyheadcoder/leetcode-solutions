class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < n){
            int j = Math.min(i+k, n);   // get end index (exclusive)
            String temp = s.substring(i, j);  
            if(j - i < k){
                int rem = k - (j - i);
                temp += String.valueOf(fill).repeat(rem); 
            }
            res.add(temp);
            i += k;
        }
        return res.toArray(new String[0]);
    }
}