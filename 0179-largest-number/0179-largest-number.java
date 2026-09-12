class Solution {
    public String largestNumber(int[] nums) {
        String [] strArr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (a,b) -> {
            return (b + a).compareTo(a+b);
        });

        // All numbers are zero
        if(strArr[0].equals("0")){
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for(String s : strArr){
            res.append(s);
        }
        return res.toString();
    }
}