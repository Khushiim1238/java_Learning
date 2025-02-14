public class Abstraction {
    /*
     *Abstract Class - cannot create an instance(obj) of abstract class
     *can have abstract/non-abstract method
     *can have constructor
     */
    public static void main(String[] args) {
        Mustang myHorse = new Mustang();
        //  Animal -> Horse -> Mustang
        
        Horse h = new Horse();
        h.eat();
        h.walk();
        

        Chicken c = new Chicken();
        c.eat();
        c.walk();

        // Animal a = new Animal();            //It will show error as we cannot instantiate the object of Animal as it is abstract class 
       
        // parent refrence = child obj     (child ka obj parent ke refrence variable ke andar assign kr sakte hai)
        Animal a = new Horse();
    }
}

abstract class Animal{
    String color;
    void eat(){
        System.out.println("animal eats");
    }

    abstract void walk();    //abstarct method becoz we have only written idea not written it's implementation and also paramenters are also not given here, it is defined in its subclass

//Constructors - Its use is to give default values to the subclasses
// it is also used to initialise the value of its child class also 
    Animal(){                         // It will be called first even when we call child class obj is created beco first parent class constructor is called
        System.out.println("Animal Constructor is called"); 
    }
}

class Horse extends Animal{
    // it is neccessary to impliment the abstarct method in in the subclass
    Horse(){
        super();    //if we dont write this java will by default call its
        System.out.println("Horse constructor is called");
        super.color = "dark-brown";      // another method of changing variable in child class
    }
    void walk(){
        System.out.println("Walks on 4 legs");
    }
    void changeColor(){
        color = "dark-brown" ;
    }
    
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor is called");
    }
}

class Chicken extends Animal{
    Chicken(){
        System.out.println("Chicken constructor is called");
    }
    void walk(){
        System.out.println("Walks on 2 legs");
    }
    void changeColor(){
        color = "yellow" ;
    }
}
// Constructor chaining
