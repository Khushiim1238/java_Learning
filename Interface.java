public class Interface {
    //Blueprint of class 
    // used to achive multiple inheritance, having properties of class a and class b in child class
    // to achive total abstraction - in abstraction we don't have 100% abstraction as we can have abstract / non abstract methods both but in interface we have 100% abstraction 
    // it is compulsory that all methods are publlic, abstract, and without implimentation
    // variable in interfaces are final, public and static(class ke liye ek baar declare hote hai)
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.eats();
    }
}

interface Herbivore{
    void eats();
}

interface Carnivore{
    void eats();
}

class Bear implements Herbivore, Carnivore{
    public void eats(){
        System.out.println("Eats both grass and meat");
    }
}

interface ChessPlayer{         //blue print
    void moves();          //it is by default public, abstract and without implementation
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal (in all direction)");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right,diagonal(by 1 step) ");
    }
}

