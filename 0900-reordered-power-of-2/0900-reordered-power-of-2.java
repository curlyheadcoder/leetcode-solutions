class Solution {
    private static final Set<String> powerSignatures = new HashSet<>();
    static{
        for(int i = 0; i < 31; i++){
            int power = 1 << i;
            powerSignatures.add(signature(power));
        }
    }
    public boolean reorderedPowerOf2(int n) {
        return powerSignatures.contains(signature(n));
    }
    private static String signature(int num){
        char [] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}