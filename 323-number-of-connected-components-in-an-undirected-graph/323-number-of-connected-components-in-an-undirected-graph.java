class Solution {
    public int countComponents(int n, int[][] edges) {
      int[] representative = new int[n];
        int[] size = new int[n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            representative[i] = i;
        }
        int components = n;
        
        for(int i = 0; i < edges.length; i++){
            components -= combine(representative, size, edges[i][0], edges[i][1]);
        }
        return components;
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