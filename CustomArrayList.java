import java.util.ArrayList;
import java.util.List;



//we are importing the ArrayList class from the java.util package
public class CustomArrayList {
    /*
     * In Built Data Structures which is linear in nature
     * It's a resizable array as it has dynamic memory allocation
     * It store non-primitive data types like Integer, String, Boolean etc
     * It is a part of Java Collections Framework which is the collection of classes and interfaces that are used to store and manage the objects by using inbuilt Data Structures
     * 
     * Operations:
     * 1. add() - to add the elements in the ArrayList    TC = O(1)
     * 2. remove() - to remove the elements from the ArrayList   TC = O(n)
     * 3. get() - to get the elements from the ArrayList     TC = O(1)
     * 4. set() - to set the elements at index in the ArrayList  TC = O(n)
     * 5. size() - to get the size of the ArrayList        TC = O(1)
     * 6. clear() - to clear the ArrayList         TC = O(1)
     * 7. contains() - to check if the element is present in the ArrayList     TC = O(n)
     * 
     * Implementation - it is actual array with some logic defined in it 
     * when ever we declare a arrayList an array is formed in the memory that have some fixed size defined and whenever it gets fill another array is called of its double size and old elements are sorted in them
     * 
     */

    /*
    public static void main(String[] args) {
        // in c++ we use "vectors" to store the data of variable size 
        ArrayList<Integer> list = new ArrayList<>();         //<> is used to show which type of data we are storing in the ArrayList
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Add Operation
        list.add(10);    //TC = O(1)
        list.add(2);
        list.add(3);
        list.add(14);
        list.add(50);
        System.out.println(list); 
        
        // list.add(2,8);    //TC = O(n) this is becoz we are shifting the elements after the index to the right side

        // Get Operation
        System.out.println(list.get(2));       

        //Remove Operation
        // list.remove(2);     //TC = O(n) this is becoz we are searching the element and then removing it and resizing the array
        // System.out.println(list);       

        //Set Operation
        // list.set(2, 10);     //TC = O(n) this is becoz we are searching the element and then setting it
        System.out.println(list);    
       
        //Contains Operation
        System.out.println(list.contains(10));       
        System.out.println(list.contains(20));

        //size Operation
        System.out.println(list.size());         //.size() is a method which returns the size of the ArrayList

        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        // reverse of an ArrayList  TC =O(n)
            // for(int i= list.size()-1; i>=0; i--){
            //     System.out.print(list.get(i)+" ");
            // }
            // System.out.println();

        // max element in array         TC = O(n)
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<list.size(); i++){
            // if(list.get(i)>max){
            //     max = list.get(i);
            // }
            max = Math.max(max,list.get(i));
        }
        System.out.println("Max element is: "+max);

        // swap two numbers
        swap(list, 1, 3);
        
        // Sorting in java
        
        // * Collection - it is a interfacee
        // * Collections - it is a class
        // * .sort() is the optimsed function
         
        //ascending order
        Collections.sort(list);
        System.out.println(list);

        //descending order
        Collections.sort(list, Collections.reverseOrder());      //comparator -func  in java that defines logics how we have to sort the array
}
    */

    public static void main(String[] args) {
        // Multi-dimensional Array
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();


        for(int i =1;i<=5;i++){
            list.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        mainList.add(list);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);
        for(int i=0; i<mainList.size(); i++){
            ArrayList<Integer> curreList = mainList.get(i);
            for(int j=0; j<curreList.size(); j++){
                System.out.print(curreList.get(j)+" ");
            }
            System.out.println(); 
        }

        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);      height.add(8);      height.add(2);      height.add(5);      height.add(4);      height.add(8);      height.add(3);      height.add(7);
        
        // System.out.println(container(height));            //TC = O(n^2)
        // System.out.println(containerOptimised(height));   //TC = O(n)

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);        nums.add(2);        nums.add(3);        nums.add(4);        nums.add(5);        nums.add(6);

        pairSum(nums, 5);

        ArrayList<Integer> nums1 = new ArrayList<>();
        nums.add(11);        nums.add(15);        nums.add(6);        nums.add(8);        nums.add(9);        nums.add(10);
    }

    public static int container(ArrayList<Integer> height){
        int mostWater = 0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j-i;
                int currWater = ht*wt;
                mostWater = Math.max(currWater, mostWater);
            }
        }
        return mostWater;
    } 

    // Optimised solution of container problem
    // 2 pointer approach LeftPointer  rightPointer
    public static int containerOptimised(ArrayList<Integer> height){
        int maxWater= 0;
        int LeftPointer = 0;
        int rightPointer = height.size()-1;
        while(LeftPointer < rightPointer){
            // calculate the area of water
            int ht = Math.min(height.get(LeftPointer), height.get(rightPointer));
            int wt = rightPointer -LeftPointer;
            int currWater = ht* wt;
            maxWater = Math.max(maxWater, currWater);
            // choti line hi container ke andar pani ko control krti hai that y we have to move it to get the max water
            if(height.get(LeftPointer)<height.get(rightPointer)){
                LeftPointer++;
            }
            else{
                rightPointer--;
            }
        }
        return maxWater;
    }

    // Pair Sum Problem in sorted arrayList
    public static boolean pairSum(ArrayList<Integer> nums, int target){
        int sum =0;
        // for(int i=0;i<nums.size();i++){
        //     for(int j=i+1;j<nums.size();j++){
        //         sum = nums.get(i) + nums.get(j);
        //         if(sum == target){
        //             System.out.println(nums.get(i) +" " + nums.get(j));
        //         }
        //     }
        // }

        // optimised code based on 2 pointer
        int lp =0;
        int rp = nums.size()-1;
        while(lp!=rp){
            // case1
            if(nums.get(lp)+nums.get(rp) == target){
                System.out.println(nums.get(lp) +" " + nums.get(rp));
                return true;
            }
            else if(nums.get(lp)+nums.get(rp) < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }

    // pair sum 2 in sorted and rotated arrayList
    public static boolean pairSum2(ArrayList<Integer> nums){
        
        //finding out piviot point/breaking point 
        return false;
    }

    public static void swap(ArrayList<Integer> list,int idx1, int idx2){
        
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
        
        System.out.println(list);
    }

    
}
