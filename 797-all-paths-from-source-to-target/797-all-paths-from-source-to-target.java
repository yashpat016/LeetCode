class Solution {
        public int target;
        public List<List<Integer>> results;
    
    public void backtrack(int[][] graph, int currNode, LinkedList<Integer> path){
        if(currNode == target){
            results.add(new ArrayList<Integer>(path));
            return;
        }
        for(int nextNode : graph[currNode]){
            path.addLast(nextNode);
            backtrack(graph, nextNode, path);
            path.removeLast();
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     target = graph.length - 1;
     results = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        backtrack(graph, 0, path);
        return results;
    } 
}