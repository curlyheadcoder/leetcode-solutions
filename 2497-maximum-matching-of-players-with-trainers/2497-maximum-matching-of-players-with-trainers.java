class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);   // Step 1
        Arrays.sort(trainers);  // Step 2

        int i = 0, j = 0, matches = 0;
        // Step 3: Try matching players with trainers
        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                matches++;    // Match found
                i++;
                j++;
            }else{
                j++;    // Trainer too weak, try next
            }
        }
        return matches;
    }
}