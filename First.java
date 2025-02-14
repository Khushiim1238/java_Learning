import java.util.*;

public class First {

    // public static void evenOdd(int n){
    //     if ((n%2) == 0){
    //         System.out.println("Number is Even.");
    //     }
    //     else{
    //         System.out.println("Number is odd.");
    //     }
    // }
    public static void main(String[] args) {

// // Sum of even and odd
//         int even = 0;
//         int odd = 0;
//         // System.out.println("Hello Khushi!");
//         for(int i =0;i<=5;i++){
//         Scanner input = new Scanner(System.in);
//         int numb = input.nextInt();
//         if(numb%2==0){
//             even += numb;
//         }
//         else{
//             odd +=numb;   
//         }
//         }
//         System.out.println("Sum of even number is:"+even);
//         System.out.println("Sum of odd number is:"+odd);


// // Factorial of a number
//         Scanner input = new Scanner(System.in);
//         System.out.println("Enter a number:");
//         int numb = input.nextInt();
//         int fact = 1;
//         while(numb>0){
//             fact *= numb;
//             numb--;
//         }
//         System.out.println("Factorial of is: "+fact);

        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter a number:");
        // int numb = input.nextInt();
        // for(int i=1;i<11;i++){
        //     System.out.println(i*numb);
        // }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int numb = input.nextInt();
// // Inverse Pattern
        // for(int line = 1; line<numb; line++){
        //     for(int star = numb-line; star >=1; star--){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        ////// Half pyramid pattern
        // for(int i=1;i<=numb;i++){
        //     for(int j = 1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // // // Print Character pattern
        // char ch = 'a';
        // for(int i=1;i<=numb;i++){
        //     for(int j = 1;j<=i;j++){
        //         System.out.print(ch);
        //         ch++;
        //     }
        //     System.out.println();
        // }

        
        /*  int row = input.nextInt();
        int col = input.nextInt();  */
        

        // // // Hollow Rectangle
        // for(int i=1;i<=row;i++){
        //     for(int j=1;j<=col;j++){
        //         if(i==1 || j == 1 || i == row || j == col){
        //         System.out.print("* ");}
        //         else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        // // // Inverted &rotated half pyramid
        // for(int i = 1; i <=numb;i++){
        //     for(int j =numb-i; j>=1;j--){
        //         System.out.print(" ");
        //     }
            
        //     for(int k=1;k<=i;k++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // // // Inverted half pyramind with numbers
        // for(int i = 1; i<=numb;i++){
        //     for(int j =1;j<=numb-i+1;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // // // Floyds triangle
        // int a = 1;
        // for(int i =1;i<=numb;i++){
        //     for(int j =1;j<=i;j++){
        //         System.out.print(a+ " ");
        //         a++;
        //     }
        //     System.out.println();
        // }
        

        // // // 0-1 Triangle pattern

        // for(int i= 1;i<=numb;i++){
        //     for(int j =1;j<=i ; j++){
        //         int a = i+j;
        //         if (a%2== 0){
        //         System.out.print(1);
        //         }
        //         else{
        //             System.out.print(0);
        //         }
        //     }
        //     System.out.println();
        // }

        // // //SOLID RHOMBUS pattern
        // for (int i =1;i <=numb;i++){
        //     for(int k = 1; k<=numb-i+1;k++){
        //         System.out.print(" ");}
        //     for(int j=1;j<=numb;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

 
        // // //HOLLOW RHOMBUS pattern
        // for(int i=1;i<=row;i++){
        //     for(int k = 1; k<=row-i+1;k++){
        //         System.out.print(" ");}
        //     for(int j=1;j<=col;j++){
        //         if(i==1 || j == 1 || i == row || j == col){
        //                 System.out.print("* ");
        //         }
        //         else{
        //                 System.out.print("  ");
        //             }
        //         }
        //         System.out.println();
        //     }

        // // //DIAMOND pattern
        // for (int i=1;i<=numb;i++){
        //     for(int j=1;j<=numb-i+1;j++){
        //         System.out.print(" ");
        //     }
        //     for(int k =1;k<=2*i-1;k++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for (int i=numb;i>=1;i--){
        //     for(int j=numb-i+1;j>=1;j--){
        //         System.out.print(" ");
        //     }
        //     for(int k=2*i-1;k>=1;k--){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }           
       

        // // //NUMBER PYRAMID pattern
        // for (int i=0;i<=numb;i++){
        //     for(int j=0;j<=numb-i+1;j++){
        //         System.out.print(" ");
        //     }
        //     for(int k =0;k<=i-1;k++){
        //         System.out.print(i+ " ");
        //     }
        //     System.out.println();
        // }


        // // //PALINDROMIC Pattern with Numbers pattern
        // for (int i=1;i<=numb;i++){
        //     for(int j=1;j<=numb-i+1;j++){
        //         System.out.print("  ");
        //     }
        //     for(int k=i;k>=1;k--){
        //         System.out.print(k+" ");
        //     }
        //     for(int k =2;k<=i;k++){
        //         System.out.print(k+ " ");
        //     }
        //     System.out.println();
        // }

        // // //Butterfly pattern
        // for(int i =1;i<=numb;i++){
        //     for(int j = 1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     for(int y =1;y<=numb-i;y++){
        //         System.out.print("    ");
        //     }
        //     for(int k=1;k<=i;k++){
        //         System.out.print(" *");
        //     }
        //     System.out.println();
        // }
        // for(int i =numb;i>=1;i--){
        //     for(int j = i;j>=1;j--){
        //         System.out.print("* ");
        //     }
        //     for(int y =numb-i;y>=1;y--){
        //         System.out.print("    ");
        //     }
        //     for(int k=i;k>=1;k--){
        //         System.out.print(" *");
        //     }
        //     System.out.println();
        // }

        /* Pattern
         Input : n = 3
        Output :
        1*2*3*10*11*12
        --4*5*8*9
        ----6*7
         */
        // int a =1;
        // for(int i =1;i<=numb;i++){
        //     for(int k = 1;k<=2*i-2;k++){
        //         System.out.print("-");
        //     }
        //     for(int j=numb;j>=i;j--){               
        //         System.out.print(a+"*");
        //         a++;
        //     }
        //     System.out.println();
        // }
        // // for half pattern
            
        // for(int i =numb;i>=1;i--){     
        //     for(int j=numb;j>=i;j--){               
        //         System.out.print(a+"*");
        //         a++;
        //     }
        //     System.out.println();
        // }

        // // // pascals triangle
        
        // for (int i = 1; i <= numb; i++) {
        //     for(int j = numb;j>i-1;j--){
        //         System.out.print(" ");
        //     }
        //     int x = 1;
        //     for(int k =1;k<=i;k++){
        //         System.out.print(x+" ");
        //         x = x * (i - k) / k;
        //     }
        //     System.out.println();
        // }

 // // // hollow DIAMOND pattern
        for (int i=1;i<=numb;i++){
            for(int j=1;j<=numb-i;j++){
                System.out.print(" ");
            }
            for(int k =1;k<=2*i-1;k++){
                if(k==1 || k== 2*i-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i=numb-1;i>=1;i--){
            for(int j=numb-i;j>=1;j--){
                System.out.print(" ");
            }
            for(int k=2*i-1;k>=1;k--){
                if( k==1 || k== 2*i-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        } 

    }
}


