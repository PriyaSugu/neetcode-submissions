class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
            }
        }

        for (int j = 0; j < cols; j++) {
            Set<Character> col = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                if (board[i][j] != '.') {
                    if (col.contains(board[i][j])) {
                        return false;
                    }
                    col.add(board[i][j]);
                }
            }
        }

        for (int square = 0; square < rows; square++) {
            Set<Character> sq = new HashSet<>();
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    int row = (square / 3) * 3 + r;
                    int col = (square % 3) * 3 + c;
                    if (board[row][col] != '.') {
                        if (sq.contains(board[row][col])) {
                            return false;
                        }
                        sq.add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }
}
