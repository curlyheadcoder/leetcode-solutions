class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        // Convert languages[i] to set for quick lookup
        List<Set<Integer>> langSets = new ArrayList<>();
        for(int [] langs : languages){
            Set<Integer> set = new HashSet<>();
            for(int l : langs) set.add(l);
            langSets.add(set);
        }
        // Find all users involved in bad friendships
        Set<Integer> badUsers = new HashSet<>();
        for(int [] f : friendships){
            int u = f[0] - 1, v = f[1] - 1;
            if(!canCommunicate(langSets.get(u), langSets.get(v))){
                badUsers.add(u);
                badUsers.add(v);
            }
        }
        // If no bad users, answer is 0
        if(badUsers.isEmpty()) return 0;
        int minTeach = Integer.MAX_VALUE;
        //Try teaching each language
        for(int lang = 1; lang <= n; lang++){
            int countKnows = 0;
            for(int user :badUsers){
                if(langSets.get(user).contains(lang)){
                    countKnows++;
                }
            }
            int needTeach = badUsers.size() - countKnows;
            minTeach = Math.min(minTeach, needTeach);
        } 
        return minTeach;
    }
    private boolean canCommunicate(Set<Integer> a, Set<Integer> b){
        for(int lang : a){
            if(b.contains(lang)) return true;
        }
        return false;
    }
}