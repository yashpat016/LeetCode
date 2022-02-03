class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 1){
            return 1;
        }
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int i = 0;
        for(int[] interval: intervals){
            start[i] = interval[0];
            end[i] = interval[1];
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int start_ptr = 0;
        int end_ptr = 0;
        
        int numberOfRooms = 0;
        while(start_ptr < start.length){
            if(start[start_ptr] >= end[end_ptr]){
                numberOfRooms--;
                end_ptr++;
            }
            
            numberOfRooms++;
            start_ptr++;
        }
        return numberOfRooms;
    }
}