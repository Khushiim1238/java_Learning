public class Third {
    // ARRAYS
    // Linear Search
    public static int linearSearch(int[] numbers,int key) {
        for(int i =0;i< numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }   return -1;     
    }

    // Largest number
    public static int largestnum(int[] numbers){
        int max = Integer.MIN_VALUE; //-infinty
        for(int i =0;i<numbers.length;i++){
            if(numbers[i]>max){
                max = numbers[i];
            }
        }
        return max;
    }

    // Binary Search
    public static int binSearch(int[] numbers,int key) {
        int start = 0;
        int end = numbers.length-1;
        while(start<=end){
            int mid = start +(start+end)/2;
            if(numbers[mid] == key){
                return mid;
            }
            if(numbers[mid]<key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    // reverse of an array
    public static void reverseArray(int[] numbers){
        int first = 0; int last = numbers.length -1;
        while(first<last){
            int temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp;
            first++;
            last--;
        }
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }

    // pairs in array   TC = o(n**2)
    public static void pairsInArray(int [] numbers){
        int totalPairs = 0;
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+numbers[i]+","+numbers[j]+")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs are: "+totalPairs);
    }

    // Print subarray +priniting sum of array and max sum of the array by using Broute Force
    public static void subArray(int [] numbers){
        int totalPairs = 0;
        int sum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<=numbers.length;i++){             // First loop for starts
            for(int j=i;j<numbers.length;j++){          // Second loop for ends
                sum =0;
                for(int k = i;k<=j;k++){                // Third loop for priniting from start to end
                    System.out.print(numbers[k]+" ");  
                    sum = sum+numbers[k];               //sum of each sub array elements
                }
                totalPairs++;
                System.err.print("- "+sum);
                System.out.println();
                if(maxSum<sum){                         // max sum in whole subarray
                    maxSum =sum;
                }
            }
            System.out.println();

        }
        System.out.println("Total Pairs are: "+totalPairs);
        System.out.println("Maximum sum is: "+maxSum);        
    }


    // Max subarray sum Prefix Sum                        ------error in the code
    public static void maxSubarraySum(int[] numbers){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[numbers.length];

        prefix[0] = numbers[0];
        for(int i =1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+numbers[i];                 // prefix array mai sum store krte hai starting se end tk ka mean nums = [-2,1,-3,4,-1,2,1,-5,4] toh for first index sum is 2 for second sm is -1 and soo on
        }

        for(int i=0;i<numbers.length;i++){
            int start = i;
            for(int j=i;j<numbers.length;j++){
                int end = j;

                currentSum = start == 0 ? prefix[end] : prefix[end]-prefix[start-1];

                if(maxSum<currentSum){                         // max sum in whole subarray
                    maxSum =currentSum;
                }
            }
        }
        System.out.println("max sum: "+currentSum);
    }


    // Max subarray Sum Kadanes rule     TC = O(n)
    public static void maxKadane(int[] numbers){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0;i<numbers.length; i++){
            cs = cs +numbers[i];
            if(cs<0){
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Our max Subarray sum is: "+ms);
    }

    // special case of kadane rule where all elements are negative then acc to kadane max sum will be zeroo but the answer should be -1


    // Contains Duplicate
    public static boolean checkDuplicate(int[] numbers){
        for(int i = 0;i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++){
                if(numbers[i] == numbers[j]){
                    return true;
                }
                
            }
        }return false;
    }
    

    public static void main(String[] args) {
        /* 
        int[] numbers = {2,4,6,8,10,12};
        int key = 8;

        //Linear Searching TC = O(n)
        int index = linearSearch(numbers, key);
        if(index == -1){
            System.out.println("Key not found");
        }
        else{
            System.out.println("Your key "+key+" in array is at index:"+index);
        }

        //Largest num in array
        int max = largestnum(numbers);
        System.out.println(max);

        // Binary Searching TC = O(log n)
        int binindex = binSearch(numbers, 12);
        if(binindex == -1){
            System.out.println("Key not found");
        }
        else{
            System.out.println("Your key "+key+" in array is at index:"+binindex);
        }
            */

        // reverseArray(numbers);
        System.out.println();

        int[] numbers = {2,4,6,8,10,2};
        int[] marks = {2,4,6,8,10,12};
        int[] marks2 = {1,-2,6,-1,3};

        pairsInArray(marks);            //pairs of array like (2,4) , (2,6)
        // subArray(marks2);               // every sub aaray in array their sum and max sum
        // maxSubarraySum(marks2);         // code is note running properly

        maxKadane(marks2);

        System.out.println(checkDuplicate(numbers));
    }
}
