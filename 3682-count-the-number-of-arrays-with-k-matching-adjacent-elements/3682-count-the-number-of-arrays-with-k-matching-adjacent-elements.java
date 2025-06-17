class Solution {
    int MOD = 1000000007;
    public int countGoodArrays(int n, int m, int k) {
        	int adjPairPossible = n - 1; // out of these i have to find k pair such that adjacent elements are equal
		//System.out.println(combination);
		int combination =(int)((1L* m*find(adjPairPossible, k))%MOD);  // for putting elements on adj to each other
		System.out.println(combination);

		int secCombination = BinaryExpo(m-1,adjPairPossible -k); // Combination for adjacent pair which are not equal
	System.out.println(secCombination);
		return (int) ((1L*combination*secCombination)%MOD);
    }
    private  int BinaryExpo(int n, int pow) {
		if(pow ==0) {
			return 1; 
		}
		int val = BinaryExpo(n,pow/2);
		long res= (int)((1L*val*val)%MOD);
		if(pow%2==0) {
			return (int)res;
		}
		else {
			return (int)((res*1L*n)%MOD);
		}
	}

	private  int find(int adjPairPossible, int k) {
		// TODO Auto-generated method stub
		int n = fact(adjPairPossible);
		
		int lb = (int)((1L*fact(k)*fact(adjPairPossible-k))%MOD);
		
		return  (int)((1L*n*modInverse(lb))%MOD);
	}

	private  int modInverse(int lb) {  // Little fermat theorem
		// TODO Auto-generated method stub
		return BinaryExpo(lb,MOD-2);
		
	}

	private  int fact(int n) {
		   if(n==0||n==1) return 1;
           return (int)((1L*n*fact(n-1))%MOD);
	}
}