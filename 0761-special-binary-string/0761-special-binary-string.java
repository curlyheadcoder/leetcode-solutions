class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if(n <= 2) return s;

        List<String> list = new ArrayList<>();
        int count = 0, start = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1')count++;
            else count--;

            if(count == 0){
                // recursively solve middle part
                String inner = makeLargestSpecial(s.substring(start+1, i));
                list.add("1" + inner + "0");
                start = i+1;
            }
        }
        // sort descending
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();
        for(String str : list){
            ans.append(str);
        }
        return ans.toString();
    }
}