class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length-1;
        int boatCount = 0;
        Arrays.sort(people);
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            boatCount++;
        }
        return boatCount;
    }
}