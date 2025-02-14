
public class Strings {
    // String is an inbuilt class

    public static boolean checkPalindrome(String str){          //TC = O(n)
        for(int i = 0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    // Shortest Path
    public static float shortestPath(String dir){
        int x= 0, y=0;
        for(int i = 0 ;i<dir.length();i++){
            switch (dir.charAt(i)) {
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                default:
                    break;
            }
        }
        int point1 = (int) Math.pow((x-0), 2);
        int point2 = (int) Math.pow((y-0), 2);
          
        float dist = (float)Math.sqrt(point1 +point2);        //float is becoz its size is 32 bit and double size is 64 bits
        return dist;
    }


    // Sub String
    public static String subString(String str ,int si, int ei){
        String subStr = "";
        for(int i =si; i<ei ;i++){
            subStr +=str.charAt(i);
        }
        return subStr;
    } 

    // Converting to uppercase
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1;i<str.length();i++){
            if(str.charAt(i) == ' ' && i<str.length() -1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // String Compresion
    public static String stringCompress(String str){
        String newStr = "";
        for(int i=0;i<str.length();i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count >1){
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        char arr[] = {'a','b','c','d'};
        String str1 = "abc";        // in java when we initialise string without new then it will point out to some old string in heao memory

        String str2 = new String("abc");                     // and when we declare using new keyword then a new variable is initiated

        /* 
        if(str1 == str2){                     
            System.out.println("Strings are equal");
        }
        else{                         //interning  -  becoz of this they are not equal            
            System.out.println("Strings are not equal");
        }

        // heap mai tony name is string ban jayegi and str1 usko point kregi 

        if(str1.equals(str2)){                     
            System.out.println("Strings are equal");
        }
        else{                                      
            System.out.println("Strings are not equal");
        }   
        */
        // Strings are IMMUTABLE - in original string we can't change anything becoz of interning concept 
    
        /* 
        Scanner sc = new Scanner(System.in);
        String name1 ;
        // name1 = sc.next();          //only takes single word if we use space or next line it will return onlt before that
        name1 = sc.nextLine();
        System.out.println(name1);

        String fullName = "Tony Strak";
        System.out.println(fullName.length());    //here length is function and in array length is property
        */

        /*
        // Concatenation
        String firstName = "Khushi";
        String lastName = "Jain";
        String fN = firstName + " " + lastName;
        System.out.println(fN);
        System.out.println(fN.charAt(0));         //to find out the character at index specified
        

        String str = "racecar";
        System.out.println(checkPalindrome(str));
        String dir = "WNEENESENNN";
        System.out.println(shortestPath(dir));
        */
    
        /* 
        //String Function Substring 
        String str = "HelloWorld";
        // System.out.println(subString(str, 0, 6));       //we have built this method but there exist a function in string already
        System.out.println(str.substring(0, 6));                 // ending index not included 
    
        // Largest String in Lexicographic Order -
        String fruits[] = {"apple","mango","banana","papaya"};
        
        String largest = fruits[0];
        for(int i= 1;i<fruits.length;i++){               //Tc = O(x*n)   we have compared n str and their length is x
            if(largest.compareTo(fruits[i]) < 0){           // if value of compareTo is 0 then it means both strings are equal, if it is < 0 ->then str1<str2 ,if it is > 0 ->then str1>str2.  Its has another function which ignores the case also that is "compareToIgnoreCase"
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    */

        // String Builder  :  Its default size is 16 
        StringBuilder sb = new StringBuilder("");     //this is ot of String type but we can convert it to string using ".toString" function. For this we have to use only Class of data type(INTEGER)
    
        // for adding char in string
        for(char ch= 'a';ch<='z';ch++){       //TC = O(26)
            sb.append(ch);
        } 
        // System.out.println(sb);

        // Ques - Convert first letter of each world to uppercase
        // We will use Character.toUpperCase(ch)
        String str = "hi, i am khushi";
        System.out.println(toUpperCase(str));

        // String Compresion
        String string1 = "aaabbcccdd";
        System.out.println(stringCompress(string1));
    }
}