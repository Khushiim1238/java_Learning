public class DandQ {
    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
        int nums[] = {4,5,6,7,0,1,2};      //rotated about pivot element 2
        int target = 0;

        int tarIdx = search(nums, target, 0, nums.length-1);
        System.out.println(tarIdx);
    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.err.println();
    }

    // Merge Sort    - TC = O(nlog n)    SP = O(n)
    /*
     * It use Divide & Conqure method
     * 1. mid = si + (ei-si)/2 - by using this formula we will reduce the problem of overflow when the indexs are of greater range
     * 2. mergeSort(left) , mergeSort(Righ)
     * 3. merge - temp arr Left els  Right els
     * 
     * baseCase- si>ei || si == ei
     * Divide, mergeSort(left) - mergeSort(right) , merge
     * 
     */

     public static void mergeSort(int[] arr, int si, int ei){
        // BaseCase
        if(si>= ei){
            return;
        }
        //kaam
        int mid=si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si,mid,ei);
     }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei-si+1];
        int i = si;            //iterator for left part
        int j = mid+1;          //iterator for right part
        int k = 0;              //iterator for temp arr
        while(i <= mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){       //for Left part remainig
            temp[k++] = arr[i++];                         //k & i ki current value use krengai and then unme one ka increment
        }
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // Copy temp to my original arr
        for(k=0 ,i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];                             //copying temp in arr
        }
    }


    // Quick Sort
    /*
     * Average case TC = O(nlogn) , Worst Case = O(n^2) , SC = O(1)
     * Works using "Pivot & Partition" Technique
     *      1. Chose Pivot - (random, median, first, last)
     *      2. Partition(parts)
     *      3. QuickSort(left) , Quicksort(right2)
     * 
     * i = -1 , swaping in original array
     */

     public static void quickSort(int[] arr, int si, int ei){
        // Base case
        if(si >= ei){
            return;
        }
        // pivot - last element
        int pindx = partition(arr,si,ei);

        quickSort(arr, si,pindx-1);    //leftpat
        quickSort(arr, pindx+1, ei);    //rightpart

     }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;    //to make space for elements smaller than pivot
        
        for(int j=si ; j<ei ;j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i] ;
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];      //don't change in pivot 
        arr[i] = temp;
        return i;
    }

    /* Worst Case TC in quick Sort is O(n^2) becoz pivot is always smallest or the largest
     * it happens when we are given with sortedd array and then then pivot element will be the last 
     * so the number of partition is done n time for first level n-1 times for 2nd and so on which forms a AP 
     * the sum of all tc is (n(n+1))/2 which come out to be O(n^2)
     */


    //  Search in Rotated Sorted Array

    /*
     * Represent the array in the graph
     * arr[mid] on line 1 or line 2 
     * Case 1: mid on L1 [Case a: L1 left(si=<tar<=mid)   Case b:mid right else]
     * Case 2: mid on L2 [Case c: L1 right(mid=< tar <=ei)    Case d:mid left else]
     */

    public static int search(int nums[],int target, int si, int ei){
        if(si>ei){
            return -1;
        }
        // kaam
        int mid = si+(ei-si)/2;

        // case Found at mid
        if(nums[mid] == target){
            return mid;
        }
        // mid on L1
        if(nums[si] <= nums[mid]){
            //case a: right
            if(nums[si] <= target && target <= nums[mid]){
                return search(nums, target, si, mid-1);
            }
            // case b: left
            else{
                return search(nums, target, mid+1, ei);
            }
        }

        // mid on L2
        else{
            // case c: right
            if(nums[mid] <= target && target <= nums[ei]){
                return search(nums, target, mid+1, ei);
            }
            //case d: left
            else{
                return search(nums, target, si, mid-1);
            }
        }
    }
}
