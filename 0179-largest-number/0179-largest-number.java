class Solution {
    public String largestNumber(int[] nums) {
        /*  [10,2] => 102, 210
            [3,30,34,5,9]  =>  309, 930
            30 > 9, InitialDigit(9) > InitialDigit(30)
            34, 30 => InitialDigit(34) > InitialDigit(30)
            30, 3 => 303, 330 => 3, 30  => 0 < 3
            34, 3 => 343, 334 => 4 > 3
            [9,5,34,3,30]  => 9534330
        */
        List<String> list = new ArrayList<>();
        for(int i : nums){
            list.add(String.valueOf(i));
        }
        Collections.sort(list, (a,b) -> compare(a,b));
        String ans = String.join("",list);
        if(allZeroes(ans)) return "0";
        return ans;
    }
    private boolean allZeroes(String s){
        for(char c : s.toCharArray()){
            if(c != '0') return false;
        }
        return true;
    }
    private int compare(String a, String b){
        int i = 0, j = 0;
        while(i < a.length() || j < b.length()){
            if(i == a.length()) i = 0;
            if(j == b.length()) j = 0;
            if(a.charAt(i) > b.charAt(j)) return -1;
            if(a.charAt(i) < b.charAt(j)) return 1;
            i++;
            j++;
        }
        return 0;
    }
}