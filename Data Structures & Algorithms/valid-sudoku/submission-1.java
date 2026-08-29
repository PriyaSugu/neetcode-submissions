class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Integer>> rows = new HashMap<>();
        Map<Integer, HashSet<Integer>> cols = new HashMap<>();
        Map<String, HashSet<Integer>> squares = new HashMap<>(); //key - [r/3,c/3]

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                String squareKey = i/3 + "," + j/3;
                int value = board[i][j];
                if(rows.computeIfAbsent(i, k -> new HashSet<>()).contains(value)||
                    cols.computeIfAbsent(j,k -> new HashSet<>()).contains(value)||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(value)){
                        return false;
                    }
                    rows.get(i).add(value);
                    cols.get(j).add(value);
                    squares.get(squareKey).add(value);
            }
        }
        
        return true;
        
    }
}
