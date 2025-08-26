class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }
}


/*
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Shift result to the left to make room for the next bit
            result |= (n & 1);     // Add the least significant bit of n to result
            n >>>= 1;              // Shift n to the right (unsigned) to process the next bit
        }

        return result;
    }
}

*/