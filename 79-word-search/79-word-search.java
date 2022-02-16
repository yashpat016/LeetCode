class Solution {
   private char[][] board;
    private int rows;
    private int cols;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(this.backtrack(i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean backtrack(int row, int col, String word, int index){
        if(index >= word.length()){
            return true;
        }
        
        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)){
            return false;
        }
        
        board[row][col] = '#';
        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};
        
        for(int i = 0; i < dirRow.length; i++){
            if(backtrack(row + dirRow[i], col + dirCol[i], word, index + 1)){
                return true;
            }
        }
        
        board[row][col] = word.charAt(index);
            
        return false;
    }
}