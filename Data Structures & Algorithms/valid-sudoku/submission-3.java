class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        

        for(int i = 0; i < board.length; i++){
            int[] rowCount = new int[10];
            for(int j = 0; j < board[0].length;j++){
                char val = board[i][j];
                // System.out.println(val);
                if(val != '.'){
                    if(rowCount[val - '0'] > 0){
                        return false;
                    }
                    rowCount[val - '0']++; 
                }
                
            }
        }
        for(int j = 0; j < board[0].length; j++){
            int[] colCount = new int[10];
            for(int i = 0; i < board.length; i++){
                int val = board[i][j];
                if(val != '.'){
                    if(colCount[val - '0'] > 0){
                        return false;
                    }
                    colCount[val - '0']++;
                }
                
            }
        }
        for(int square = 0; square < board.length; square++){
            int[] squareCount = new int[10];
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3;j++){  
                    int row = (square/3) * 3 + i;
                    int col =  (square%3) * 3 + j;
                    char val = board[row][col];
                    // System.out.println(val);
                    if(val != '.'){
                        if(squareCount[val - '0'] > 0){
                            return false;
                        }
                        squareCount[val - '0']++; 
                    }
                    
                }
            }
            
        }
        


        return true;
    }
}
