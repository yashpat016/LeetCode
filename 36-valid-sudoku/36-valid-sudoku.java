class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            Set<Character> setr = new HashSet<>();
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.' && !setr.contains(board[i][j])){
                    setr.add(board[i][j]);
                }
                else if(board[i][j] == '.'){}
                else {
                    return false;
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            Set<Character> setc = new HashSet<>();
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != '.' && !setc.contains(board[j][i])){
                    setc.add(board[j][i]);
                }
                else if(board[j][i] == '.'){}
                else {
                    return false;
                }
            }
        }
        int x = 0;
        int y = 0;
        Set<Character> setb = new HashSet<>();
        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        for(int i = x+3; i < x + 6; i++){
            for(int j = y; j < y + 3; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        for(int i = x+6; i < x + 9; i++){
            for(int j = y; j < y + 3; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        for(int i = x; i < x + 3; i++){
            for(int j = y+3; j < y + 6; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        for(int i = x+3; i < x + 6; i++){
            for(int j = y+3; j < y + 6; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
         for(int i = x+6; i < x + 9; i++){
            for(int j = y+3; j < y + 6; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        for(int i = x; i < x + 3; i++){
            for(int j = y+6; j < y + 9; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        for(int i = x+3; i < x + 6; i++){
            for(int j = y+6; j < y + 9; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        
        for(int i = x+6; i < x + 9; i++){
            for(int j = y+6; j < y + 9; j++){
                if(board[i][j] != '.' && !setb.contains(board[i][j])){
                    setb.add(board[i][j]);
                    continue;
                } else if(board[i][j] == '.') {}
                else {return false;}
            }
        }
        setb.clear();
        
        return true;
    }
}