class Solution {
    public String largestGoodInteger(String num) {
        String goodInt = "";
        List<String> sameDigitNo = List.of("999","888","777","666","555","444","333","222","111","000");
        for(String sameNo : sameDigitNo){
            if(num.contains(sameNo)){
                goodInt = sameNo;
                break;
            }
        }
        return goodInt;
    }
}