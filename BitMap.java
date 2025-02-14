public class BitMap {
    //  Bit Manipulation
    // to represent a number in binary system it take log(base 2)n + 1 bits
    // In computer memoery is stored in Binary Number System 
    // In actual we don't have any subtraction operation we only have addition operation and we perform subtraction by adding 2's complement of that number
    // Bit wise Opreator- Bin AND (&) , Bin OR(|), Bin XOR(^) , Bin One Complement (~) , Bin Left Shift (<<) , Bin Right Shift (>>)
    // Rules[Bin AND (&)] = 0 & 0 -> 0 , 0 & 1 -> 0 , 1 & 0 -> 0 , 1 & 1 -> 1
    // Rules[Bin OR (|)] = 0 & 0 -> 0 , 0 & 1 -> 1 , 1 & 0 -> 1 , 1 & 1 -> 1
    // Rules[Bin XOR (^)] = 0 & 0 -> 0 , 0 & 1 -> 1 , 1 & 0 -> 1 , 1 & 1 -> 0
    // Rules[Bin One's Comp (~)] = ~ 0 -> 1 , ~ 1 -> 0 
    // Rules[Bin Left Shift (<<)] = a << b() we shift our number in left from b spaces and then filll left out places with 0
    // Rules[Bin Right Shift (>>)] = a >> b() we shift our number in Right from b spaces and then fill right out places with 0

    public static void oddEven(int n){
        int bitMask = 1;        // it is that number which we use to perform operation with n
        if((n & bitMask) == 0){
            System.out.println("It is even");
        }
        else{
            System.out.println("It is odd");
        }

    }

// Getting ith bit of a number
    public static int getIthBit(int n,int i){
        int bitMask = 1<<i;         //here we have shifted 1 to left for i spaces  
        if((n & bitMask) == 0){         // here we are checking that at ith index what is the value after performing & operation 
            return 0;
        }
        else{
            return 1;
        }
    }

// Setting ith bit of a number
    public static int setIthBit(int n,int i){
        int bitMask = 1<<i;         //here we have shifted 1 to left for i spaces  
        return n | bitMask;        // here we are performing OR "|" operation to change the ith bit to 1 or returning the same if one is already there
    }

// Clearing ith bit - make ith bit 0 whether it is 0 0r 1
// for this we will perform not operation of bitmask and then do AND operation 
    public static int clearIthBit(int n,int i){
        int bitMask = ~(1<<i);         //here we have shifted 1 to left for i spaces  
        return n & bitMask ;
    }

// Update ith bit
    public static int updateIthBit(int n, int i, int newBit){
        // if(newBit == 0){
        //     return clearIthBit(n, i);
        // }
        // else{
        //     return  setIthBit(n, i);
        // }
        n = clearIthBit(n, i);        //ith bit clear hho chuki hai
        int bitMask = newBit<<i;
        return n | bitMask;
    }

// Clear List i bits
    public static int clearIBit(int n, int i){
        int bitMask = (~0)<<i;                      // in this we are taking not of 0 that is -1 which is represented by 11111111 and then performing left shift of i spaces
        return n & bitMask;                        // and then taking AND of both numbers so we will get zeros for diff bit
    }

// Clear Range of i bits
    public static int clearRangeofBit(int n, int i, int j){
        int a =(~0)<<j+1;
        int b =(1<<i)-1;
        int bitMask = (a)|(b);                     // a = 11100000 abd b = 000000011  when we will perform or in this we will get the bitmask  //(~0) is 111111111    //(1<<i)-1 = 2^i -1
        return n & bitMask;                        // and then taking AND of both numbers so we will get zeros for diff bit
    }

// Checking number is of 2's power
    public static boolean isPowerofTwo(int n){
        return (n & (n-1)) == 0;
    }

// Counr set bit
    public static int countSetBit(int n){
        int count = 0;
        while(n>0){
            if((n & 1) != 0){    //checks LSB of the number
                count++;
            } 
            n = n >> 1; 
        }
        return count;
    }

// Fast Exponentiation
    public static int FastExpo(int n , int p){           //TC = 0(log n + 1)
        int ans =1;
        while(p > 0){
            if((p & 1) != 0){    //Checking LSB
                ans = ans * n;   //Here n is updated one after 1'st iteration
            }
            n = n*n;
            p = p>>1;
        }
        return ans;
    }

// Swap two numbers without using temp variable
    public static void swapNum(int a , int b){
        System.out.println("Numbers before swaping are: "+a +" " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Numbers after swaping are: "+a +" " + b);
    }
    public static void main(String[] args) {
/* 
        // this will give result in decimal
        System.out.println((5 & 6));         // Bitwise And Operator - in this we only use single &
        System.out.println((5 | 6));         // Bitwise Or Operator - in this we only use single |
        System.out.println((5 ^ 6));         // Bitwise XOR Operator 

        // In this we get LSB(leftmost) and MSB(rightmost) , msb specifies number is +ve or -ve when it is 0 and 1 respectively.
        System.out.println((~5));         // Bitwise One's Complement Operator 
        
        System.out.println((5<<2));         // Bitwise Left Shift Operator a << b = a* 2^b 
        System.out.println((5>>2));         // Bitwise Right Shift Operator a >> b = a/ 2^b 
*/    

        // check numb is odd or even -->   in old numbers lsb is 1 and in even numbers it is 0
        // now we have to check only lsb for which we have to remove numb before lsb and we perform AND with 0 operation on that and AND with 1 for LSB  
        // example -> 3 is even or odd 011 & 001 = 001 that means it is odd
        oddEven(8);
        oddEven(12);
        oddEven(23);

        // Get ith bit 
        System.out.println(getIthBit(23, 2)); 
        // Set ith bit -> convert it to 1 by using or operator
        System.out.println(setIthBit(10, 2)); 
        // Clear ith bit -> change ith bit to 0 whether it is 0 or 1
        System.out.println(clearIthBit(12, 2));
        //Update ith bit
        System.out.println(updateIthBit(12, 1, 1));
        
        // Clear Last i bits 
        System.out.println(clearIBit(23, 2));

        // Clear Range of i bits ,eg: n = 100111010011 , i=2,j=7
        // this can be done by taking bitMaskk which is a or b
        System.out.println(clearRangeofBit(10, 3,5));
        
        // Checking number is of 2's power
        System.out.println(isPowerofTwo(256));

        // Count set bits in a number  --> set bit are thus bits in the number which are 1
        System.out.println(countSetBit(23));

        // Fast Exponentiation
            // a^N  its original TC = O(n) but we reduce it to O(logn)
        System.out.println(FastExpo(2, 3));
        
        // Swaping Numbers
        swapNum(12, 23);
    }
}
