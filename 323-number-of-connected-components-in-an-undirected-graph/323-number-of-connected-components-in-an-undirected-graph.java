class Solution {
    public int countComponents(int n, int[][] edges) {
      int components = 0;
        int[] visited = new int[n];
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i< edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }
    
    public void dfs(List<List<Integer>> adjList, int[] visited, int startNode){
        visited[startNode] = 1;
        
        for(int i = 0; i<adjList.get(startNode).size(); i++){
            if(visited[adjList.get(startNode).get(i)] == 0){
                dfs(adjList, visited, adjList.get(startNode).get(i));
            }
        }
    }
}