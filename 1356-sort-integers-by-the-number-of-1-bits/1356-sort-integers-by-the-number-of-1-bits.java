class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        // Comparator 
        Arrays.sort(temp, (a,b)->{
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if(countA != countB){
                return countA - countB;
            }else{
                return a-b;
            }
        });

        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }
}