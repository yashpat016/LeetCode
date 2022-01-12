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
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int val = queue.poll();
            seen.add(val);
            if(val == end){
                return true;
            }
            for(int element: adjList.get(val)){
                if(!seen.contains(element))
                queue.add(element);
            }
        }
        return false;
    }
}