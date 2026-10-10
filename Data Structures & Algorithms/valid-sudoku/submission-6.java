class Solution {
    Set<Character> seen;
    public boolean isValidSudoku(char[][] board) {
        this.seen = new HashSet<>();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(!isValidCell(board[r][c])){
                    return false;
                }
            }
            seen.clear();
        }

        for(int c = 0; c < 9; c++){
            for(int r = 0; r < 9; r++){
                if(!isValidCell(board[r][c])){
                    return false;
                }
            }
            seen.clear();
        }

        for(int square = 0; square < 9; square++){
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    int row = (square / 3) * 3 + r;
                    int col = (square % 3) * 3 + c;
                    if(!isValidCell(board[row][col])){
                        return false;
                    }
                }
            }
            seen.clear();
        }

        return true;
    }

    boolean isValidCell(char cell){
        if(cell == '.'){
            return true;
        }
        if(seen.contains(cell)){
            return false;
        }
        seen.add(cell);
        return true;

    }
}
