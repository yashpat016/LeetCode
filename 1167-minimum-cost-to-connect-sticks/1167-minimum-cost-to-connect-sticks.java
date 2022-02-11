class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick: sticks){
            pq.offer(stick);
        }
        int minCost = 0;
        while(pq.size() >= 2){
            int first = pq.poll();
            int second = pq.poll();
            int combined = first + second;
            minCost += combined;
            pq.offer(combined);
        }
        return minCost;
    }
}