class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Double.compare(a[0], b[0]));
        int[] representative = new int[n];
        int[] size = new int[n];
        for(int i = 0; i < n; i++){
            representative[i] = i;
            size[i] = 1;
        }
        int groupSize = n;
        for(int i = 0; i < logs.length; i++){
            groupSize -= combine(representative, size, logs[i][1], logs[i][2]);
            if(groupSize == 1){
                return logs[i][0];
            } else {
                continue;
            }
        }
        return -1;
    }
        
        public int find(int[] representative, int vertex){
            if(vertex == representative[vertex]){return representative[vertex]; }
            return representative[vertex] = find(representative, representative[vertex]);
        }
        
        public int combine(int[] representative, int[] size, int vertex0, int vertex1){
            vertex0 = find(representative, vertex0);
            vertex1 = find(representative, vertex1);
        
        if(vertex0 == vertex1){
            return 0;
        } else if(size[vertex0] > size[vertex1]){
            size[vertex0] += size[vertex1];
            representative[vertex1] = vertex0;
        } else {
            size[vertex1] += size[vertex0];
            representative[vertex0] = vertex1;
        }
        return 1;
        }
}