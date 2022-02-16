class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int freshOranges = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j));
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        queue.offer(new Pair(-1,-1));
        
        int minutesElapsed = -1;
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            if(row == -1){
                minutesElapsed++;
                if(!queue.isEmpty()){
                    queue.offer(new Pair(-1,-1));
                }
                } else {
                for(int[] d: direction){
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if(neighborRow>= 0 && neighborRow < ROWS && neighborCol >= 0 && neighborCol < COLS){
                        if(grid[neighborRow][neighborCol] == 1){
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
            }
        return freshOranges == 0 ? minutesElapsed : -1;
        }
    
    }
