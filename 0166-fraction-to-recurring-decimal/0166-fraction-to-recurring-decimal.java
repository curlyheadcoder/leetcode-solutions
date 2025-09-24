class Solution {
    public String fractionToDecimal(int n, int d) {
        if(n == 0) return "0";

        // To build the result string
        StringBuilder sb = new StringBuilder();

        // Determine the sign of the result
        // If exactly one of n or d is negative, prepend "-"
        if( (n < 0) ^ (d < 0) ){
            sb.append("-");
        }

        // Convert to long to prevent overflow and take absolute values
        long a = Math.abs((long) n); // numerator
        long b = Math.abs((long) d); // denominator

        // Append the integer part of the division
        sb.append(a / b);

        // Calculate the initial remainder
        long remainder = a % b;

        // If no remainder, return the result as there is no fractional part
        if(remainder == 0){
            return sb.toString();
        }

        // There is a fractional part, so add the decimal point
        sb.append(".");

        // Map to store previously seen remainders and their positions in sb
        Map<Long, Integer> map = new HashMap<>();

        // Process fractional part using long division
        while(remainder != 0){
            // If this remainder has been seen before, it's repeating
            if(map.containsKey(remainder)){
                int pos = map.get(remainder);
                sb.insert(pos, "("); // insert '(' at the first occurrence
                sb.append(")");      // append ')' at the end
                break;               // repeating part handled, exit loop
            }

            // Store the position of this remainder
            map.put(remainder, sb.length());

            // Multiply remainder by 10 and append the quotient digit
            sb.append(remainder * 10 / b);

            // Update remainder
            remainder = (remainder * 10) % b;
        }

        // Return the final string representation
        return sb.toString();
    }
}