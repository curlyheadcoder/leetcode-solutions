class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        // Sort by ascending starting point 
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> res = new ArrayList<>();
        int [] newInterval = intervals[0];
        res.add(newInterval);

        for(int [] interval : intervals){
            if(interval [0] <= newInterval[1]){
                // overlapping intervals,
                // update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                // Disjoint intervals,
                // add the new interval to the list 
                newInterval = interval;
                res.add(newInterval);
            }
            
        }
        return res.toArray(new int [res.size()][]);
    }
}