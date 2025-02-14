

public class Inheritance {
    // Inheritance is when properties and
   // methods of base class are passed on to a derived class

    public static void main(String args[]) {
        Fish shark = new Fish();

        // inherited properties
        shark.color = "blue";
        shark.eat();
        // self properties
        shark.fins = 5;

        Mammal whale = new Mammal();

        whale.color = "black";
        whale.eat();

        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);

    }
}

// main class or parent class

class Animal{
    String color;
    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathes");
    }
}

// derived class or child class

// Single inherited class
    //  base claas
   //      |
   //      |
  //  Derived class / sub class   
 
class Fish extends Animal {
    int fins;
    void swim() {
        System.out.println("Swims");
    }
}

//hierarchical Inheritance
 //            base claas
 //             /      \
 //            /        \
  //   Derived class      Derived class
class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
}
class Peecock extends Bird{
    String name;
}

// Double inherited class
class Mammal extends Animal {             
    int legs;
    void walk() {
        System.out.println("walks");
    }
}
//Multilevel inheritance
//  base claas
//      |
//      |
//  Derived class
//      |
//      |
//  Derived class

class Dog extends Mammal {
    String breed;
}
class Cat extends Mammal{
    void meow(){
        System.out.println("Cat is meowing");
    }
}
class Human extends Mammal{
    void talk(){
        System.out.println("Human is Talking");
    }
}