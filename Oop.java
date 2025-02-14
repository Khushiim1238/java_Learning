
public class Oop {
    // NOTE - In java class is neither private nor protected as they become unusable and we cant cretae there obj

    // Any thing or we can say that instance of a class that has state and behavior is an object.
    // And blueprint or template for creating objects is class. 

    // object creation has three parts:
        /* 
        Declaration: The code Student student; declarations that associate a variable name with 
        an object type. 
        Instantiation: The new keyword is a Java operator that creates the object. 
        Initialization: The new operator is followed by a call to a constructor, which initializes the 
        new object.
        */

    //Object - entities in the real world which have some property or its function
    // class - group of these entities they have attribute and behaviour

    //Compiler will first see this main function in the public class
    
    // Static Keyword - in java it is used to share the same variable or method of a given class(we want that to be vaise ki vaise jaise starting mai declare kra tha)
                    //- properties(variables), Function, Blocks({ int a = b+c; syso(a);}), Nested Classes(multiple classes in a single class)
                    //- if we change value of static variable for one object then it is changed for all
                    //- and its space is allocated for once in the memory and all obj will refer to this(storage optimiszation) 
                    //- we want main function single hi rhe iss liye static keyword usse krte hai
    public static void main(String[] args) {
        Pen p1 = new Pen();                //created a new object of pen class
        p1.setColor("Blue");
        p1.setTip("8");  

        p1.color = "Yellow";
        System.out.println(p1.color);
        System.out.println(p1.tip);

        BankAccount myAcc = new BankAccount();
        myAcc.userName = "Khushi";
        // myAcc.password = "abc";              //not accessible as it is private
        myAcc.setPassword("abc");
        System.out.println(myAcc.getPassword("abcd"));
    
        // Student s1 = new Student("Khushi");          //In java if we don't create a constructor it will automatically creates a constructor by default but in that we can intialize value
        // Student s2 = new Student();
        // Student s3 = new Student(123);                    //Constructor overloading  -- Polymorphism
        // System.out.println(s1.name);

        Student s1 = new Student();
        s1.name = "Khushi";
        s1.roll = 123;
        s1.Password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);              //Copy constructor  - after some time if we change the value of marks in s1 then it should not be changed in s2 but it is changed
        s2.Password = "xyz";
        s1.marks[2] = 100;
        for(int i =0;i<3;i++){
            System.out.println(s2.marks[i]);
        }

    }
}

class BankAccount{
    // Access Modifiers
        /*
         * Private - (within class) - YES   ,   (within package) - NO   ,   (outside package by subclass only) - NO    ,    (outside package) - NO
         * Default - (within class) - YES   ,   (within package) - YES   ,   (outside package by subclass only) - NO    ,    (outside package) - NO
         * Protected - (within class) - YES   ,   (within package) - YES   ,   (outside package by subclass only) - YES    ,    (outside package) - NO
         * Public - (within class) - YES   ,   (within package) - YES   ,   (outside package by subclass only) - YES    ,    (outside package) - YES
         */
    public String userName;
    private String password;

    // Setter - used to set the value or change the values of the attributes that are private
    public void setPassword(String pwd){
        password = pwd;
    }

    // Getters -used to return the values of the attribute . this : it is a keyword used to refer the current object , used for refrence to which object is calling insude the function 
    String getPassword(String password){
        this.password = password;      //this ke sath vala password class ka attribute hai jiske andar function vale password ki value daal rhe hai
        return password;
    }
}
class Pen{
    String color;
    int tip;

     
    void setColor(String newColor){
        color = newColor;
    }
    void setTip(String newTip){
        color = newTip;
    }
}

/*
  Encapsulation - wrapping up data & methods under a signle unit, also implements data hiding 

  Inheritance - it is when properties & method of BASE class are passed on to a DERIVED class  
                It is of four types - 1). Single Level   2).Multilevel Inheritance   3). Hierarchical Inheritance   4). Hybrid Inheritance
                
  Abstraction - Hiding all the unnecessary details and showing only the important parts to the user
                1). Abstract Classes  2). Interfaces
                Abstract means we give only ideas not the implimentation
  
  Polymorphism -* -Compile time polymorphism = Method overloading (static)
                * - Run time polymorphism = Method overriding (dynamic)

  Constructor - it is a special method which is invoked automatically at the time of object creation. It's working is like first constructor is called and after that memory is allocated to the object (object is initialised) 
                - it have the same name as class or structure
                - Don't have return type. (Not even void)
                - are only called once , at the object creation
                - Memory allocation happens when constructor is called ,  mean object ke properties ko store krne ki space constructor ke call hone ke baad hi milti hai
 */

 class Student{
    String name;
    int roll;
    String Password;
    int marks[];

    Student(String name){           // Parameterized Constructor
        marks = new int[3];
        this.name = name;
    }

    Student(){           // Non-Parameterized Constructor
        marks = new int[3];
        System.out.println("Constructor is called");;
    }

    Student(int roll){           // Parameterized Constructor
        marks = new int[3];
        this.roll = roll;
    }


    // Student(Student s1){           //Shallow Copy Constructor  - the change in s1 will also affect s2 becoz (see this.marks)
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;        //in this line are not copying the complete array we are giving the refrence of the array
    // }

    // Deep Copy Constructor
    Student(Student s1){
        marks = new int[3];
        this.roll = s1.roll;
        this.name = s1.name;
        for(int i = 0;i < marks.length;i++){
            this.marks[i] = s1.marks[i];
        }
    }
 }

/*
 Shallow Copy = it is that in which are only copying to the refrences we dont create new variable
             In this the change in older variable or obj will reflect the new one

 Deep Copy = we make new variable or object and copy the complete details of older ones.
             In this the change in older variable or obj won't reflect the new one
 */

/*
  * Destructors - destroy objects. it is done by garbage collector that deletes the unused array variable object from the program by ensuring that they are not in use
                  so we don't write destructor the garbage collector will automatically do that
*/