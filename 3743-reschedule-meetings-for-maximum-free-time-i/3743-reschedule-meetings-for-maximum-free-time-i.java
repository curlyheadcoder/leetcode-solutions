class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        ArrayList<Integer> freeArray = new ArrayList<>();

        /*
            Agar ith event pe khada hu, toh:
            ith ka start minus (i-1)th ka end equals to gap duration(freeTime)

        */
        int n = startTime.length;
        freeArray.add(startTime[0]);
        for(int i = 1; i < n; i++){
            freeArray.add(startTime[i] - endTime[i-1]);
        } 
        freeArray.add(eventTime - endTime[endTime.length - 1]);


        // Khandani Sliding Window

        int i = 0, j = 0, maxSum = 0;
        int currSum = 0;

        int len = freeArray.size();
        while(j < len){
            currSum += freeArray.get(j);

            if(i < len && j - i + 1 > k + 1){
                currSum -= freeArray.get(i);
                i++;
            }
            maxSum = Math.max(maxSum, currSum);
            j++;
        }
        return maxSum;
    }
}