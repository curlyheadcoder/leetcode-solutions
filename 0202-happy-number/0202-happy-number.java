class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = getSquareSum(n);
        while(fast!= 1 && slow != fast){
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        }
        return fast == 1;
    }
    private int getSquareSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}