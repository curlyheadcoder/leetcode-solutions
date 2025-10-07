class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> map = new HashMap<>();   // lake -> last day it was filled
        TreeSet<Integer> dryDays = new TreeSet<>();    // indices of dry days (rains[i] == 0)
        int[] ans = new int[n];
        Arrays.fill(ans, 1);                           // default all dry days to dry lake 1

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                dryDays.add(i);                        // record this dry day
            } else {
                ans[i] = -1;                           // raining day — can't dry any lake

                if (map.containsKey(lake)) {
                    // lake already filled previously
                    Integer dryDay = dryDays.higher(map.get(lake));  // next dry day after it was last filled

                    if (dryDay == null) {
                        // no dry day available to empty this lake before raining again → flood
                        return new int[0];
                    }

                    ans[dryDay] = lake;                // use this dry day to dry the lake
                    dryDays.remove(dryDay);
                }

                map.put(lake, i);                      // record latest day this lake was filled
            }
        }

        return ans;
    }
}