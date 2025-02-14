import java.util.*;

public class Second {

    // PRIME NUMBERS ---

    // public static boolean isPrime(int n){

    //     // corner case for 2
    //     if(n==2){
    //         return true;
    //     }
       
    //     for(int i =2; i<=Math.sqrt(n);i++){
    //         if(n%i == 0){
    //             return false;
    //         }
    //     }return true;
    // }

    // public static void numbers(int num){
    //     for(int j=2;j<=num;j++){
    //         if(isPrime(j)){
    //             System.out.print(j+" ");
    //         }
    //     }System.out.println();
    // }
    // public static void main(String[] args) {
    //     System.out.println("Enter a number:");
    //     Scanner read = new Scanner(System.in);
    //     int numb = read.nextInt();
    //     numbers(numb);
        
    // }
    

    // BINARY TO DECIMAL
    public static void BinToDeci(int num){
        int pow = 0;
        int dec = 0;
        
        while(num>0){
            int ld = num%10;
            dec = dec+(ld*(int)Math.pow(2, pow));
            pow++;
            num /=10;
        }
        System.out.println(dec);
    }

    public static void DeciToBin(int num) {
        int bin = 0;
        int base = 0;
        while(num>0){
            int rem = num% 2;
            bin = bin + (rem*(int)Math.pow(10,base));
            base++;
            num  = num/2;
           
        }
        System.out.println(bin);
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n1 = read.nextInt();
        int n2 =read.nextInt();
        BinToDeci(n1);
        DeciToBin(n2);
    }
}
