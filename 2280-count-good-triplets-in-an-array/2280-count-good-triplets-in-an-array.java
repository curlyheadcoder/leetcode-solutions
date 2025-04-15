class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // Step 1: Map each value to its index in num2
        int [] indexInNums2 = new int[n];
        for(int i = 0; i < n; i++){
            indexInNums2[nums2[i]] = i;
        }
        // Step 2: Transform nums1 using the mapping
        int [] transformed = new int [n];
        for(int i = 0; i < n; i++){
            transformed[i] = indexInNums2[nums1[i]];
        }
        // Step 3: Count increasing triplets using BIT
        BIT bit = new BIT(n);
        long [] left = new long[n];
        long [] right = new long[n];

        // Count of elements less than current to the left
        for(int i = 0; i < n; i++){
            left[i] = bit.query(transformed[i]);
            bit.update(transformed[i], 1);
        }
        // Reset BIT for right count
        bit = new BIT(n);

        // Count of elements greater than current to the right
        for(int i = n-1; i >= 0; i--){
            right[i] = bit.query(n-1) - bit.query(transformed[i]);
            bit.update(transformed[i],1);
        }

        // Calculate total good triplets
        long count = 0;
        for(int i = 0; i < n; i++){
            count += left[i] * right[i];
        }
        return count;
    }
    // Binary Indexed Tree (Fenwick Tree) implementation 
    public class BIT{
        long [] tree;
        int size;

        public BIT(int size){
            this.size = size+2;
            tree = new long[this.size];
        }
        public void update(int index, long value){
            index += 1;
            while(index < size){
                tree[index] += value;
                index += index & -index;
            }
        }
        public long query(int index){
            index += 1;
            long result = 0;
            while(index > 0){
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}