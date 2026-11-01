class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[10];
        int[] col = new int[10];
        int[] square = new int[10];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] != '.'){
                    int val = board[r][c] - '1';
                    int mask = 1 << val;

                    if((row[r] & mask) > 0 || (col[c] & mask) > 0 || (square[(r/3) * 3 + (c/3)] & mask) > 0){
                        return false;
                    }

                    row[r] |= mask;
                    col[c] |= mask;
                    square[(r/3) * 3 + (c/3)] |= mask;
                }
            }
        }
        return true;
    }
}
