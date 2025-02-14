public class Polymorphism {
    
    /* Poly means "many" and morphism means "forms" , so when we try to do multiple works in similar form
     * -Compile time polymorphism = Method overloading (static)
     * - Run time polymorphism = Method overriding (dynamic)
     
     Method overloading/Function Overloading - multiple functions with same name but diff parameters
     Method overriding - parent and child class both contain the same function with a diff definition
     */

     public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1,2));
        System.out.println(calc.sum((float)1.5, (float)2.3));
        System.out.println(calc.sum(1,2,5));

        Deer d = new Deer();
        d.eat();
    }
}

// Method overloading/Function Overloading
class Calculator{
    int sum(int a,int b){
        return a + b;
    }

    float sum(float a,float b){
        return a + b;
    }
    
    int sum(int a,int b, int c){
        return a + b + c;
    }
}

// Method overriding
class Animal{
    void eat(){
        System.out.println("Eats anything");
    }
}
class Deer extends Animal{
    void eat(){
        System.out.println("Eats grass");
    }
}