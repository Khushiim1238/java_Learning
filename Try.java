import java.util.*;
// public class Try{
//     public static int avg(int a, int b,int c){
//         int res = (a + b + c)/3;
        
//         return res;
//     }

//     public static boolean isEven(int num){
        
//         if(num%2 == 0){
//             return true;
//         }
//         else{
//             return false;
//         }
//     }

//     public static boolean isPalin(int num){
//         int mynum = num;
//         int digit =0;
//         while(mynum!=0){
//             int rem = mynum%10 ;
//             digit = digit*10 + rem;
//             mynum = mynum/10;
//         }
//         if(num == digit){
//             return true;
//         }    
//         return false;
//     }

//     public static int sumOfDigit(int num){
        
//         int sum = 0;
//         while(num>0){
//             int rem = num%10;
//             sum = sum + rem;
//             num = num/10;
//         }
//         return sum;        
//     }

//     public static void main(String[] args) {
//         Scanner read = new Scanner(System.in);
//         System.out.println("Enter a number: ");
//         int n1 = read.nextInt();
//         // int n2 = read.nextInt();
//         // int n3 = read.nextInt();
//         // int ans = avg(n1,n2,n3);
//         // System.out.println(ans);
//         int res = sumOfDigit(n1);
//         System.out.println(res);
//         if(isPalin(n1)){
//             System.out.println("yes");
//         }
//         else{
//             System.out.println("no");
//         }

//         int a = read.nextInt();
//         for(int i=1;i<=a;i++){
//             for(int k = 1;k<=a-i;k++){
//                 System.out.print(" ");
//             }
//             for(int l=i;l>=1;l--){
//                 System.out.print(l);
//             }
//             for(int j =2;j<=i;j++){
//                 System.out.print(j);
//             }

//             System.out.println();
//         }
//     }
// }
public class Try{
    public static int countValue(int[][] matrix, int key){
        int count = 0;
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == key){
                    count +=1;
                }
            }
        }
        System.out.println("Count of "+key+" is "+count);
        return 0;
    }

    public static int sumOfRow(int[][] matrix) {
        int sum = 0;
        for(int j =0;j<matrix[0].length;j++) {
            sum += matrix[1][j];
        }
        System.out.println("Sum is "+sum);
        return 0;
    }
    // count lower Case Vowel in String
    public static void countVowel(String str){
        int count = 0;
        for(int i = 0;i<str.length();i++){
            switch(str.charAt(i)){
                case 'a':
                    count++;
                    break; 
                case 'e':
                    count++;
                    break;
                case 'i':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("No. of Lowercase vowels are: "+count);
    }

    // Checking Strings are anagram
    public static void checkAnagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){
            // Convert to char array
            char[] str1charArr = str1.toCharArray();
            char[] str2charArr = str2.toCharArray();
            // Sort char Array
            Arrays.sort(str1charArr);
            Arrays.sort(str2charArr);
         
            boolean result = Arrays.equals(str1charArr,str2charArr);
            if(result){
                System.out.println(str1 + " and "+str2 + " are anagram of each other.");
            }
            else{
                System.out.println(str1 + " and "+str2 + " are not anagram of each other.");
            }
        }
        else{
            System.out.println(str1 + " and "+str2 + " are not anagram of each other.");
        }
    }

    public static int valueOfPower(int n){
        int ans = 1;
        
        return ans;

    }
    
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int count =0;
        for(int i =0 ; i<arr.length ; i++){
            if(arr[i-1] != arr[i]){
                count++;
            }
        }
        int res = count - k;
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {{4,7,8},{8,8,7}};
        int key = 7;
        // countValue(matrix, key);

        int[][] nums = {{1,4,9},{11,4,3},{2,2,3}};
        // sumOfRow(nums);


        // Scanner sc =new Scanner(System.in);
        // String str1 = sc.nextLine();
        // String str2 = sc.nextLine();

        // // countVowel(str1);

        // checkAnagram(str1, str2);

        // // value of x^x of any value of x
        // System.out.println(valueOfPower(2));

        int[] arr = {5,5,4};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
        
    }
}


    
