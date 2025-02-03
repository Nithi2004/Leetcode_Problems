class Solution {
    public void solveSudoku(char[][] board) {
        SudokuSolver(board,0,0);
        print(board);
    }
    public static boolean SudokuSolver(char sudoku[][],int row ,int col) {
        // base case 
        if(row==9){
            return true;
        }
        // recursion
        // cheak when to increase row& col
        int nextRow=row;
        int nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(sudoku[row][col]!='.'){
            return SudokuSolver(sudoku,nextRow,nextCol);
        }
        for(char digit='1';digit<='9';digit++){
            if(isValid(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(SudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col]='.';
            }
        }
        return false;
    }
    public static boolean isValid(char sudoku[][],int row,int col,int digit){
        // cheak row
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        // cheak col
        for(int j=0;j<9;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        // cheak Grid 
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static void print(char sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}