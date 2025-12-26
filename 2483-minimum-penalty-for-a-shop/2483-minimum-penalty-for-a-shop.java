class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
       int[] countY = new int[n];
        // prefix count of Y
        countY[0] = customers.charAt(0) == 'Y' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            countY[i] = countY[i - 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int totalY = countY[n - 1];
        // closing at hour 0
        int minPenalty = totalY;
        int bestHour = 0;
        // closing at hour i (1 .. n-1)
        for (int i = 1; i < n; i++) {
            // N in open hours [0 .. i-1]
            int openPenalty = i - countY[i - 1];
            // Y in closed hours [i+1 .. n-1]
            int closedPenalty = totalY - countY[i];
            // contribution of hour i itself (closed)
            int hourPenalty = (customers.charAt(i) == 'Y') ? 1 : 0;
            int penalty = openPenalty + closedPenalty + hourPenalty;
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i;
            }
        }
        // closing at hour n
        int allDayOpenPenalty = n - totalY;
        return allDayOpenPenalty < minPenalty ? n : bestHour;
    }
}