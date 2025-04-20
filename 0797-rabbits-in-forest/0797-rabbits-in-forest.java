class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalRabbits = 0;
        for(int ans : answers){
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        for(Map.Entry <Integer, Integer> entry : map.entrySet()){
            int x = entry.getKey(); // Answer given by the rabbit
            // How many rabbits gave this answer
            int count = entry.getValue();
            int groupSize = x + 1;
            int groups = (count + x) / groupSize;
            totalRabbits = totalRabbits + groups * groupSize;
        }
        return totalRabbits;
    }
}