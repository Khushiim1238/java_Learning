/* 
 * Linear arrays are sorted in contiguous memory(one after other).
 * while 2D array are stored in row major([0,1,2][3,4,5][6,7,8]) , column major([0,3,6][1,4,7][2,5,8]) , but in real in java there is no row major and column major
 * infact in java n no. of individual arrays are formed like int[][] mai 4 rows hai toh 4 arrays linear manner mai kahi bhi store ho jayegi of same size
   and yea array ki staing memory ek array mai store ho jayegi it is not necessary that thery are contiguous
 */

public class TwoDArray{
    // Matrix(horizontal column, vertical row) - 1D , 2D , 3D
    // photos , videos(4d array 4th is of time) rgb matrix banate hai
    // representation - [row][column]

    public static boolean search(int[][] matrix , int key){
        int n = matrix.length,m=matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == key){
                    System.out.println("Key found at (" + i + "," + j + ") cell");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void maxMin(int matrix[][]){
        int n = matrix.length,m=matrix[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]>max){
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max element is "+max);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                }
            }
        }
        System.out.println("Max element is "+min);
    }

    // Spiral Matrix
    /*
     Approach - First we cover the outer cover than in the same way we cover the inner cover until we reach the simgle element or no element
     in one loop we cover top row and bottom row , and in one loop we cover first column and last column which means we have to itreate n/2 times
     */
    public static void printSpiral(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;
        
        while(startRow <= endRow && startCol <= endCol){          //this condition is when we odd n or m or any number
            //printing top boundary
            for(int j = startCol;j<=endCol;j++){          // j for column
                System.out.print(matrix[startRow][j]+" ");
            }
            // printing right boundary
            for(int i=startRow+1;i<=endRow;i++){          // i for column
                System.out.print(matrix[i][endCol]+" ");
            }
            // printing bottom boundary
            for(int j = endCol-1;j>=startCol;j--){          // j for column
                if(startRow == endRow){                     // this condition is used when we have odd number of arrays them middle mai ek hi value bachti hai jo top vale loop mai print ho jayegi right vala loop run nhi hoga but bottom vala run hoga nd vo same hi value hogi toh do baar na print ho thats y
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            } 
            // printing left boundary
            for(int i = endRow-1;i>=startRow+1;i--){          // i for column
                if(startCol == endCol){                     // this condition is used when we have odd number of arrays them middle mai ek hi value bachti hai jo top vale loop mai print ho jayegi right vala loop run nhi hoga but bottom vala run hoga nd vo same hi value hogi toh do baar na print ho thats y
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }


    // Diagonal sum (n=m , it can be odd or even)
    // Primary diag = Left top se Bottom Right   i == j
    // Secondary diag = Right top se left bottom   i+j = n-1
    // then matrix is 3x3 then we have overlaping element 
    public static int diagonalSum(int[][] matrix){
        int sum = 0;
        // for(int i = 0;i<matrix.length;i++) {            // Brute force approach
        //     for(int j =0;j<matrix[0].length;j++){
        //         if(i == j){
        //             sum += matrix[i][j];
        //         }
        //         else if(i+j == matrix.length - 1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        for(int i = 0;i<matrix.length;i++){           //TC = O(n)
            // pd
            sum += matrix[i][i];
            // sd
            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }

    // search in Sorted Matrix (row and column wise sorted) 
    // Brute force  TC = O(n^2)
    // idea is that matrix is sorted (row wise and column wise)
    // Binary Search   TC = o(nlogn)  
    /*[STAIR CASE SEARCH]   TC = o(n + m)  / O(n) when rows are greater in number / O(m) when colums are greater in number
     * we will always see (0,m-1) and (n-1,0) cell and start checking condition that
     * for (0 , m-1) Condition - key < cell_value --> left , key > cell_value --> Bottom
     * for (n-1 , 0) Condition - key < cell_value --> Top , key > cell_value --> Right
     */
    public static boolean stairCaseSearch(int [][] matrix , int key){
        int row = 0 , col = matrix[0].length -1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col] == key){
                System.out.println("Found key at ("+ row +","+ col + ""+")");
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        // int[][] matrix = new int[3][3];    //total no of cells = rows*column
        // int n = matrix.length,m=matrix[0].length;
        // Scanner sc = new Scanner(System.in);
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }
        // // Output
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(search(matrix, 8));
        // maxMin(matrix);

        int matrix1[][] =  {{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};
        int key = 8;
        // printSpiral(matrix1);
        System.out.println(diagonalSum(matrix1));
        stairCaseSearch(matrix1, key);
    }
}