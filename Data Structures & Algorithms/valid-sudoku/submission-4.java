class Solution {
    public boolean isValidSudoku(char[][] board) {

        int rows = board.length;
        int cols = board[0].length; 
        
        for(int r = 0; r < rows; r++){
            int[] rowCount = new int[10];
            for(int c = 0; c < cols; c++){
                char val = board[r][c];
                if(val != '.'){
                    if(rowCount[val - '0'] != 0){
                        return false;
                    }
                    rowCount[val-'0']++;
                }
            }
        }

        for(int c = 0; c < cols; c++){
            int[] colCount = new int[10];
            for(int r = 0; r < rows; r++){
                char val = board[r][c];
                if(val != '.'){
                    if(colCount[val - '0'] != 0){
                        return false;
                    }
                    colCount[val-'0']++;
                }
            }
        }

        for(int square = 0; square < rows; square++){
            int[] squareCount = new int[10];
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    int row = (square/3) * 3 + r;
                    int col = (square % 3) * 3 + c;
                    char val = board[row][col];
                    if(val != '.'){
                        if(squareCount[val - '0'] != 0){
                            return false;
                        }
                        squareCount[val-'0']++;
                    }
                }
            }

        }
        return true;
    }
}
