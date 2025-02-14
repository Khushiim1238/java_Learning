

public class Recursion {
    // Two main concepts - Iteration, Functions
    // Mainly used in Trees, Graphs, DP
    // Base Case = the last step where we know the answer 
    // Recursive function
    // Top to down (towards to Best Case) , Combine Colution (towards top)

    // Recursion: method of solving a computational problem where the solution depends on solution to smaller instances of the same problem.
    // Base Case definition , any work, inner function call
    
    public static void main(String[] args) {
        // Printing numbers from n to 1(Decreasing Order )
        int n = 10;
        printDec(n);
        printInc(n);
        // System.out.println();
        // System.out.println(factorial(5));
        // System.out.println(sum(5 ));
        // System.out.println(fi bonacci(6 ));
        int arr[] = {1,4,2,3,4};
        System.out.println(isSorted(arr, 0));

        System.out.println(firstOccu(arr, 0, 3));
        System.out.println(lastOccu(arr, 0, 3));

        System.out.println(numPower(2, 10));
        System.out.println(powerNumOptimized(2, 10));

        System.out.println(tilling(4));

        String str = "khushimoon";
        dublicate(str, 0, new StringBuilder(""), new boolean[26]);

        System.out.println(friendPairing(3));

        printBinaryStrings(5, 0, "");
    }

    public static void printDec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    // in java when one function call another function, call stack is formed 

    // Stack Overflow
    /*
     * in memory when call-stack is formed it stores parameter is each function , array in each function is stored again
     * To stop this we use to define base class
     */

    public static void printInc(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        
        System.out.print(n+" ");
    }


    // Factorial
    public static int factorial(int num){        //TC = O(n)  SC = O(n)- Becoz call stacks are formed
        if(num == 0 ){
            return 1;
        }
        int fn = num * factorial(num-1);
        return fn;
    }

    // sum for first n natural number
    public static int sum(int n){          //TC = O(n)  SC = O(n)- Becoz call stacks are formed
        if(n==1){
            return 1;
        }
        int s = n + sum(n-1);
        return s;
    }

    // fibonacci number
    public static int fibonacci(int n){           //height of tree call structure is O(n) - SC    TC = O(2^n) [In tree structure har level pr 2 ki power mai calls lagegi and level n tk hote hai] yea hi total no. of calls hoti hai
        if( n == 0 || n == 1){
            return n;
        }
        int f = fibonacci(n-1) + fibonacci(n-2);
        return f; 
    }

    // Is Sorted 
    public static boolean isSorted(int[] arr, int i){
        if( i == arr.length-1){           //Case in which only one elemnt in the array
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        
        return isSorted(arr , i+1);
    }

    // Find First Occurence 
    public static int firstOccu(int[] arr,int i,int key){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccu(arr,i+1,key);
    }

    // Find Last Occurence 
    public static int lastOccu(int[] arr,int i,int key){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccu(arr,i+1,key);
        if(isFound == -1 && arr[i] == key){           //if key is present only one time 
            return i;
        }

        return isFound;
    }

    //Print x^n 
    public static int numPower(int base,int power){        //TC = O(n)
        if(power == 0){
            return 1;
        }
        int np = base * numPower(base, power-1);
        return np;
    }

    //Print x^n  Optimized
    public static int powerNumOptimized(int num, int pow){           //TC = O(log n)
        if(pow == 0){
            return 1;
        }
        // int halfPwerSq = powerNumOptimized(num, pow/2) * powerNumOptimized(num, pow/2);    //becoz of this time complexity is still O(n)
        int halfPwerSq = powerNumOptimized(num, pow/2);          //Here TC = O(log n)   as we are calling the function for n/2 times
        halfPwerSq = halfPwerSq * halfPwerSq; 
        if(pow%2 != 0){
            halfPwerSq = num * halfPwerSq;
        }
        return halfPwerSq;
    }

    // Tiling problem
    public static int tilling(int n){         //this defines the sixe of board "2xn"
        if(n==0 || n==1 ){
            return 1;
        }
        int vertical = tilling(n-1);           //if n =3 then  then it will call tilling(2) which will return ways = 2
        int horizontal = tilling(n-2);            //here it will call for tilling(1) which will return ways 1 
        int ways = horizontal + vertical;
        return ways;                               //so it will return ways = (1+2) = 3
    }


    // Remove Dublicate in String - condition only small character
    public static void dublicate(String str, int indx, StringBuilder str1, boolean mapArray[]){
        //We are using sb becoz we are adding(appending) next character in string 
        // int indx = currentChar - 'a'
        //map array will track that which letter is aready in the letter or not, its size is 26 and type is boolean so we itreate through the string and 
        // check that first char in strnig if in the array at that char index T is stored then we will not take this char again and if not then it will add that in new string
        // type Conversion - 'a' -'a' = 0   ,  'b' - 'a' = 1  ,  'c' - 'a' = 2 

        if(indx == str.length()){                        //when we reach the end of the original string it will print new string
            System.out.println(str1);
            return;
        }
        char currCh = str.charAt(indx);
        if(mapArray[currCh - 'a'] == true){
            //duplicate
            dublicate(str, indx +1, str1, mapArray);
        }
        else{
            mapArray[currCh - 'a'] = true;                                              //here we are setting true for that char that is not present in the array and appending that char in new string
            dublicate(str, indx+1, str1.append(currCh), mapArray);
        }
    }

    // Friends Pairing Problem
    /*
     * Given n friends, each one can remain single or can be paired up with some other friend. 
     * Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up
     Base Case --
     n = 1 -> 1 way [single]
     n = 2 -> 2 ways [single or one pair]
     */

     public static int friendPairing(int n){
        // baseCase
        if(n ==1 || n ==2){
            return n;
        }
        int single = friendPairing(n-1);
        int pair = (n-1)*friendPairing(n-2) ;               // we have n-1 ways of pairing assuume 4 peoples are there 1st way is ther send alone 2nd way is that thery pair, from n frnds we have taken 1 and left with n-1 choices
        int ways = single + pair;
        return ways;
     }

    // Binary String Problem - here we can't place consecutive 1's if in lastPalce there is 1 then we will not place 1 on next place 

    public static void printBinaryStrings(int n ,int lastPlace , String str){
        // baseCase
        if(n == 0){
            System.out.println(str);
            return;
        }
        
        // kaam
        printBinaryStrings(n-1, 0, str+"0");          // we are always doing this for 0 mean we can place consecutive 0's
        if(lastPlace == 0){                                       
            // sit 0 on chair n
            printBinaryStrings(n-1, 1, str+"1");         //here we are updating last place and appending string with one
        }  
    }

    // Find Occurence(Indices) of a element(key) in the array
    public static void occuOfKey(int arr[] , int key, int i){
        
    } 

    // Number to String
    public static void numToStrnig(int num, StringBuilder str){
        
    }
}
