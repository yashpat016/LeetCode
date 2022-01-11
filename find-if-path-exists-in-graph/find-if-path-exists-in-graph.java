class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end && n == 1){
            return true;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < n; i++){
         adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }
        
        return dfs(adjList, seen, start, end);
    }
    public boolean dfs(List<List<Integer>> adjList, Set<Integer> seen, int start, int end){
        if(adjList.get(start).contains(end)) {return true;}
        
        for(int neighbor: adjList.get(start)){
            if(!seen.contains(neighbor)) {
                seen.add(neighbor);
                if(dfs(adjList, seen, neighbor, end)){return true;}
            }
        }
        return false;
    }
}