class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] match: matches){
            int winner = match[0];
            int loser = match[1];
            seen.add(winner);
            seen.add(loser);
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }   

        for(int player: seen){
            if(!map.containsKey(player)){res.get(0).add(player);}
            else if(map.get(player) == 1){res.get(1).add(player);}
        }

        Collections.sort(res.get(0));
        Collections.sort(res.get(1));

        return res;   
    }
}