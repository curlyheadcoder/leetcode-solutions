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
        
        // Convert int array to String array, so we can sort later 
        String [] strArr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        // Sort Strings according to custom comparator
        Arrays.sort(strArr, new Comparator<String>(){
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        // If, after being sorted, the largest number is '0', the entire number is shifted towards right
        if(strArr[0].equals("0")){
            return "0";
        }
        // Build largest number from Sorted Array
        StringBuilder largestNumberStr = new StringBuilder();
        for(String numAsStr : strArr){
            largestNumberStr.append(numAsStr);
        }
        return largestNumberStr.toString();
    }
}