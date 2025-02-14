
public class Sorting {
    /*
     * Basic sorting Algorithm
      -Bubble Sort
      -Selection Sort
      -Insertion Sort
      -Counting Sort
     */

    //  Bubble Sort - sorteed array in decreasing or increasing order(prefered)    TC = O(n**2)

    public static void bubbleSort(int[] numbers) {
        // sorting is done in n-1 turn
        // and in 1st iteration we go on n-1-i itteration and for each next we went to n-1-i
        // for sorted arr time complexity is still O(n^2) but to minimize it we have a solution to check how many swaps are there in the end TC is O(n)
        for(int turn = 0;turn<numbers.length;turn++){
            for(int j = 0;j<numbers.length-1-turn;j++){
                if(numbers[j]>numbers[j+1]){           //swaping
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] numbers){
        for(int i = 0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }


    //  Selection Sort - sorteed array in decreasing or increasing order(prefered)    TC = O(n**2)
    public static void selectionSort(int[] numbers) {
        // smallest element ko pick krna hai and sabse aage put krna hai so there will not be any unnecessary swaps 
        
        for(int i = 0; i<numbers.length -1 ;i++){
            int minElem = i;
            for(int j = i+1;j<numbers.length ;j++){      //phle yea loop i+1 se last element tk jayega and 
                if(numbers[minElem] > numbers[j]){       // isme update krte rhengai min value ki position ko
                    minElem = j;
                }
            }
            // swap
            int temp = numbers[minElem];
            numbers[minElem] = numbers[i];
            numbers[i] = temp;
        }
    } 


    //  Insertion Sort - sorteed array in decreasing or increasing order(prefered)    TC = O(n^2)
    public static void insertionSort(int[] arr) {  
        // it's inspiration is taken from cards where we pick element from unsorted part and place it at it's right place
        // here we assume that our first element is sorted and rest is unsoerted part then we  pick first element of unsorted part and put it in sorted part
        // let's take ex of 5,4,1,3,2 in which 5 is sorted and 4 to 2 is unsorted then we take 4 and compare it with 5 rest of numbers will remain at there original position and 4 is in temp memory 
        // after comparing we get 5 is greater then we push it to 1 position ahead and at black space we put 4
        //  and so on....
        for(int i = 1;i<arr.length - 1;i++){
            int temp = arr[i];
            int prev = i-1;
            // finding out the correct position to insert
            while(prev >= 0 && arr[prev] > temp){                        //Example: If arr = [3, 1, 2] and i = 1, after shifting, it becomes [3, 3, 2] (but temp = 1 is still stored).
                arr[prev+1] = arr[prev];
                prev--; 
            }
            // insertion
            arr[prev+1] = temp;                                    // Example: In the earlier case, prev = -1, so prev + 1 = 0, and arr[0] becomes 1, resulting in [1, 3, 2].
        }
    }


    //  Counting Sort - sorteed array in decreasing or increasing order(prefered)    TC = O(n+range)
    public static void countSort(int[] arr) {
        // used when no. are not so big (ex range of positive min to max is small)
        // sabse phle yea count krengai konsa element kitni baar aaya hai uss range , Ek count array banayengai
        // then original array mai change krengai like count array mai dekhengai ki 0 ki freq kitni hai then utne 0 put kr dengai original array mai next check krte jayengai and put krte jayengai
        // {1,4,1,8,3,0,2,4,3,7,0}
        int largest = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest + 1]; 
        for(int i =0;i<arr.length;i++){
            count[arr[i]]++;   
        }
        // sorting
        int j = 0;                              //j acts as a index to the position in the original array arr where the next sorted element will be placed.
        for(int i=0;i<count.length;i++){        //yea loop outer loop hai jo count array ki length jitna chalega
            while(count[i]>0){                  //yea inner loop check krega value at ith position in the count array , if 0 se bada hai number toh update krta rahega in original array mai jb tk count at that index ki value 0 nhi ho jata and 0 hote hi loop se bahar aa jayega 
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    } 
    
    
    public static void main(String[] args) {
        int[] numbers = {5,4,1,3,2};
        bubbleSort(numbers);
        printArray(numbers);

        int[] array = {5,4,1,3,2};
        selectionSort(array);
        printArray(array);

        int[] arr = {3,6,2,8,1,5,7};
        insertionSort(arr);
        printArray(arr);

        int[] arr1 = {1,4,1,8,3,0,2,4,3,7,0};               // counts the freq of num in the array 
        countSort(arr1);
        printArray(arr1);
    }
}
