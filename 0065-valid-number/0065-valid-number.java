class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitSeen = true;
            } else if (c == '+' || c == '-') {
                // Sign is allowed only at the beginning
                // or immediately after e/E
                if (i > 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }

                // Sign cannot be the last character
                if (i == s.length() - 1) {
                    return false;
                }
            } else if (c == '.') {
                // Decimal point cannot repeat or occur
                // after the exponent
                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                // Exponent must occur only once and
                // must follow a number
                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitSeen = false;
            } else {
                return false;
            }
        }

        return digitSeen;
    }
}