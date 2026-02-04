class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for(int l : left){
            lastMoment = Math.max(l, lastMoment);
        }
        for(int r : right){
            lastMoment = Math.max(lastMoment, n-r);
        }
        return lastMoment;
    }
}