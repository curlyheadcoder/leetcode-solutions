class Solution {
    private static final double EPS = 0.000001;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int x : cards) list.add( (double) x );
        return sol(list);
    }

    private boolean sol(List<Double> list){
        int n = list.size();
        if(n==1){
            // check for answer and return bool
            if (Math.abs(list.get(0) - 24) < EPS)   return true;
            return false;
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double a = list.get(i);
                double b = list.get(j);

                List<Double> newList = new ArrayList<>();
                for(int k = 0; k<n; k++){
                    if(k==i || k==j) continue;
                    newList.add(list.get(k));
                }

                for(double x : candidates(a,b)){
                    newList.add(x);
                    if( sol(newList) )
                        return true;
                    newList.removeLast();
                }
            }
        }

        return false;
    }

    // Generate all possible results from combining a and b with + - * /
    private List<Double> candidates(double a, double b) {
        List<Double> res = new ArrayList<>(6);
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS) res.add(a / b);
        if (Math.abs(a) > EPS) res.add(b / a);
        return res;
    }
}