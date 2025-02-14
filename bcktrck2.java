public class bcktrck2 {

    /*
     * Grid Ways - 
     * find the no. of ways to reach from (0,0) to (n-1,m-1) in a NxN grid  [Allowed moves - right & down]
     * TC = O(2^(n+m))   becoz n+m is the total no. of turns      
     */
    public static int gridWays(int i,int j, int n, int m){
        // baseCase
        if(i == n-1 && j == m-1){          //when source is at target
            return 1;
        }
        else if(i == n || j == m){            //condition when we have crossed the boundary
            return 0;
        }
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }
    
    /*
     * Optimised Solution of grid Ways
     * way/path which we have take (n-1)Down Turns and (m-1)Right Turns
     * now we have (n-1)D's and (m-1)R's so we take permutation of these characters we get
     * ((n-1+m-1)!)/(n-1)!(m-1)!  this is becoz they have (n-1) (m-1) elements repeating
     * TC = O(n+m)
     */
    
    public static int gridWaysOptimised(int n, int m){
        int N = n-1+m-1;
        int r = n-1;
        int res = 1;
        for(int i=1; i<=r; i++){
            res = res*(N-r+i)/i;
        }
        return res;
    }

    /*
     * Sudoko Solver
     * TC = O(9^(n*n))  becoz we have 9 choices for each cell
     * space = O(n*n)  becoz we are using 2D array
     * Rules - we have to place a number in such a way that it should not repeat in the same "row", same "column" and the same "3x3 grid"
     */

    private static boolean isSafe(int[][] sudoku, int row, int col, int digit) {            //to check if the number is safe to place or not
        //check in the column
        for(int i=0; i<9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        
        //check in the row
        for(int j=0; j<9; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        //check in the 3x3 grid

        //identify the starting point of the 3x3 grid
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // baseCase
        if(row == 9 ){    //if we have reached the end of the sudoku   next row and new col
            return true;
        }

        //reurssion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){       //sudoku se bahar aa gya
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){       //if the cell is already filled
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit= 1; digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){              //if we get the solution
                    return true;
                }
                sudoku[row][col] = 0;  //backtrack
            }
        }
        return false;
    }

    public static void printSudoku(int[][] sudoku) {
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
        }
    public static void main(String[] args) {
        int n =3, m=3;
        // System.out.println(gridWays(0, 0, n, m));
        // System.out.println(gridWaysOptimised(n, m));

        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }
        else{
            System.out.println("Solution does not exists");
        }
    }

     
            
}
