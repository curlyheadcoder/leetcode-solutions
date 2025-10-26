class Solution {
    public int totalMoney(int n) {
        int terms = n / 7; // Weeks

        int first = 28;
        int last = 28 + (terms - 1) * 7; // AP formula for n-th term

        int result = terms * (first + last) / 2; // Sum of nth terms in an AP

        // Remaining days (use AP formula)
        int remain = n % 7;
        int firstTerm = 1 + terms;
        int lastTerm = firstTerm + remain - 1;
        result += remain * (firstTerm + lastTerm) / 2;

        return result;
    }
}