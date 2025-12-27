class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by their start time 
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        // PriorityQueue for available rooms (sorted by room number)
        PriorityQueue<Integer> avlRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            avlRooms.offer(i);
        }
        // PriorityQueue for occupied rooms (sorted by end time)
        // Each entry: [endTime, roomNumber]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        // Meeting count for each room
        int [] meetingCount = new int [n];
        for(int [] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            // Free rooms that have completed current meeting start
            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= start){
                avlRooms.offer((int) busyRooms.poll()[1]);
            }
            if(!avlRooms.isEmpty()){
                // assign the meeting to the smallest-numbered available room
                int room = avlRooms.poll();
                busyRooms.offer(new long []{start + duration, room});
                meetingCount[room]++;
            }else{
                // Delay the meeting until the earliest room becomes free

                long [] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                busyRooms.offer(new long [] {newStart + duration, room});
                meetingCount[room]++;
            }
        }

        // Find the room with the most meetings 
        int maxMeetings = 0;
        int resultRoom = 0;
        for(int i = 0; i < n; i++){
            if(meetingCount[i] > maxMeetings){
                maxMeetings = meetingCount[i];
                resultRoom = i;
            }
        }
        return resultRoom;
    }
}