public class BackTrack {
      /*
       * Decision - find out solution of a problem
       * Optimisation - finding out the best solution
       * Enumeration - listing all solution
       
       *Backtracking of Arrays  TC = O(n)    SP = O(n) becoz of stack-call 
       */
      public static void changeArr(int arr[], int i, int val){
        // BaseCase
        if(i == arr.length){
            printArr(arr);
            return;
        }

        // kaam = recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);        //fun call step
        arr[i] = arr[i] - 2;           //backtrack step
      }

    private static void printArr(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    /*
     * Find Subset - "abc" = a, b, c, ab, ac, bc, abc, 
     * TC = O(n*2^n)   total subset = 2^n(becoz it has two choices) , tme to find each set is n
     * SC = O(n)
     * we are using string here becoz string is immutable and when we chose yes new string is formed and whe we chose no again new string is formed
     * we can also used String builder the only additional step is to add delete the element for no choice which we have added in yes choice
     */
    public static void findSubsets(String str, String ans, int i){
        // baseCase
        if (i == str.length()) { 
            if(ans.length() == 0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);       
            }
            return;     
        }
        // recursion
        findSubsets(str, ans+str.charAt(i), i+1);                      //yes choice
        findSubsets(str, ans, i+1);                                   //no choice - for this the change will be removed from the string as they are passby value change
    }

    /*
     * Find Permuation of a String (arrangements)
     * for n elements - n! permutation
     * TC = O(n * n!///////////////)           SP= O()
     */

    public static void allpermutation(String str, String ans){
        // baseCase
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        // recursion
        for(int i =0; i<str.length(); i++){
            char curr = str.charAt(i);
            // "abcde" = "ab" + "de"
            String newStr = str.subSequence(0, i) + str.substring(i+1);    //ith char will not be included
            allpermutation(newStr, ans+curr);
        }
    }

    /*
     * N-Queens Problems 
     * on an N x N chessboard such that no 2 queens can attack each other
     * All possible solution
     * TC = O(n!)  Reccurance Relation = T(n) -> 1 Queenplace[O(n)] * T(n-1) + isSafe()
     */

    public static boolean isSafe(char board[][], int row, int col){     
        // vertical up 
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // diag left up
        for (int i = row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // diag right up
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row){              //for printing all possible solution
        // base case
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }

        // column loop
        for(int j = 0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);           //function call
                board[row][j] = '.';             //backtracking step - unplace
            }
        }
    }

    public static boolean nQueens1(char board[][], int row){              //for printing only one solution
        // base case
        if(row == board.length){
            count++;
            return true;
        }

        // column loop
        for(int j = 0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueens1(board, row+1)){             //function call
                    return true;
                }
                board[row][j] = '.';             //backtracking step - unplace
            }
        }
        return false;
    }
    
    private static void printBoard(char[][] board) {
        System.out.println("-------- Chess Board ---------");
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }

    static int count =0;             //it is static becoz in recursion for each level parameter are passed through call by value
    public static void main(String[] args) {
        int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        String str = "abc";
        // findSubsets(str, "", 0);
        // System.out.println();
        // allpermutation(str, "");

        int n = 4;
        char board[][] = new char[n][n];
        // intialize the 2d array with some values
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        // nQueens(board, 0);           //For printing all solution

        
        // System.out.println("ways to solve n quees are: "+count);                 // count of all solution

        
        if(nQueens1(board, 0)){                         // for printing only one solution     it will not backtrack if one the condition is true for n-1 queens   
            System.out.println("\nSolution is possible.");
            printBoard(board);
        }
        else{
            System.out.println("No solution are possible");
        }
    }
}
