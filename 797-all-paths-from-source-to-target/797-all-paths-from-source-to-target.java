class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        queue.add(Arrays.asList(0));
        while(!queue.isEmpty()){
            path = queue.poll();
            int val = path.get(path.size() - 1);
            if(val == target){
                result.add(path);
            }
            for(int neighbor: graph[val]){
                List<Integer> list = new ArrayList<>(path);
                list.add(neighbor);
                queue.add(list);   
            }
        }
        return result;
    }
}