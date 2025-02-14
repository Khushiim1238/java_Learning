public class Sort{
	
	public static void bubbleSort(int[] arr){
		for(int i = 0;i<arr.length -1;i++){
			for(int j = 0;j<arr.length-1-i;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
                }
            }
        }
    }

	public static void selectionSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int min= i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

	public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]>temp){            
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev+1] = temp;
        }
}

	public static void countSort(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
        int[] count = new int [largest+1];
        for(int i = 0;i<arr.length;i++){             // frequency count 
            count[arr[i]]++;
        }

        int j = 0;
        for(int i= 0;i<count.length;i++){
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

	public static void printArray(int[] arr){
	for(int i = arr.length-1;i>=0;i--){
		System.out.print(arr[i] + " ");
	}
}


	public static void main(String[] args){
		int[] arr ={3,6,2,1,8,7,4,5,3,1};
		// bubbleSort(arr);
		// printArray(arr);

		// selectionSort(arr);
		// printArray(arr);

		// insertionSort(arr);	
		// printArray(arr);

		countSort(arr);
		printArray(arr);
	}
}
