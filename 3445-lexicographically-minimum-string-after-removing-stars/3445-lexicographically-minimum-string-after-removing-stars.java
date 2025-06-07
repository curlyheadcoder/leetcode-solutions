class Solution {
    public String clearStars(String s) {
        TreeMap<Character, Deque<Integer>> map = new TreeMap<>();
        int n = s.length();
        boolean [] removed = new boolean[n];
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                removed[i] = true;
                for(char key : map.keySet()){
                    if(!map.get(key).isEmpty()){
                        int idx = map.get(key).removeLast();
                        removed[idx] = true;
                        if(map.get(key).isEmpty()) map.remove(key);
                        break;
                    }
                }
            }else{
                map.putIfAbsent(ch, new ArrayDeque<>());
                map.get(ch).add(i);
            }
        }      
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(!removed[i] && s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}