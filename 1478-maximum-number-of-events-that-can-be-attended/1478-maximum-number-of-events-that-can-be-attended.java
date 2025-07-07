class Solution {
    public int maxEvents(int[][] events) {
        // total number of events
        int totalEvents = events.length;
        // Find the last possible day any event can end
        int lastDay = 0;
        for(int [] event : events){
            lastDay = Math.max(lastDay, event[1]);
        }
        // Sort events by their starting day
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));
        // Min heap to store event end days
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int eventsAttended = 0;
        int idx = 0;
        // Try to attend one event per day from day1 to lastDay
        for(int currentDay = 1; currentDay<= lastDay; currentDay++){
            // Add all events starting today or before today
            while(idx < totalEvents && events[idx][0] <= currentDay){
                minHeap.add(events[idx][1]);
                idx++;
            }
            // Remove all events that have already ended before today
            while(!minHeap.isEmpty() && minHeap.peek() < currentDay){
                minHeap.poll();
            }
            // Attend the event that ends the earliest
            if(!minHeap.isEmpty()){
                minHeap.poll();
                eventsAttended++;
            }
        }
        return eventsAttended;
    }
}