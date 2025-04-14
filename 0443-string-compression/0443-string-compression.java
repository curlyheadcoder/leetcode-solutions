class Solution {
    public int compress(char[] chars) {
        int write = 0; // position to write the compressed character
        int start = 0; // start index of each group

        for (int i = 0; i <= chars.length; i++) {
            // If end of array or current char differs from previous one
            if (i == chars.length || chars[i] != chars[start]) {
                chars[write++] = chars[start]; // write the character

                int count = i - start;
                if (count > 1) {
                    String numStr = String.valueOf(count);
                    for (char ch : numStr.toCharArray()) {
                        chars[write++] = ch; // write each digit
                    }
                }

                start = i; // move to next group
            }
        }

        return write;
    }
}
