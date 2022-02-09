class Solution {
    
    private char[][] board;
    private int rows;
    private int cols;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        
        for(int row = 0; row < this.rows; row++){
            for(int col = 0; col < this.cols; col++){
                if(this.backtrack(row, col, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    protected boolean backtrack(int row, int col, String word, int index){
        if(index >= word.length()){
            return true;
        }
        if(row < 0 || row == this.rows || col < 0 || col == this.cols || this.board[row][col] != word.charAt(index)){
            return false;
        }
        
        this.board[row][col] = '#';
        
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        
        for(int i = 0; i < 4; i++){
            if(this.backtrack(row + rowOffsets[i], col + colOffsets[i], word, index + 1)){
                return true;
            }
        }
        this.board[row][col] = word.charAt(index);
        return false;
    }
}