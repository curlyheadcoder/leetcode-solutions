class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int hh = 0; hh <= 11; hh++){
            for(int mm = 0; mm <= 59; mm++){
                if(Integer.bitCount(hh) + Integer.bitCount(mm) == turnedOn){
                    String hour = String.valueOf(hh);
                    String minute = (mm < 10 ? "0" : "") + mm;
                    ans.add(hour + ":" + minute);
                }
            }
        }
        return ans;
    }
}