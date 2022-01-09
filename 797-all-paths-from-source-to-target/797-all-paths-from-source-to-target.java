class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtrack(graph, 0, target, path, result);
        return result;
    }
    
    public void backtrack(int[][] graph, int currNode, int target, LinkedList<Integer> path, List<List<Integer>> result){
        
        if(currNode == target){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int neighbor : graph[currNode]){
            path.addLast(neighbor);
            backtrack(graph, neighbor, target, path, result);
            path.removeLast();
        }
    }
}