class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] mapST = new int [256];
        int [] mapTS = new int [256];
        for(int i = 0; i < 256; i++){
            mapST[i] = -1;
            mapTS[i] = -1;
        }
        for(int i = 0; i < s.length(); i++){
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if(mapST[chS] == -1 && mapTS[chT] == -1){
                mapST[chS] = chT;
                mapTS[chT] = chS;
            }else if(mapST[chS] != chT || mapTS[chT] != chS){
                return false;
            }
        }
        return true;
    }
}