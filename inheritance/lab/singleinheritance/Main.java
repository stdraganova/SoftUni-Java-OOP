package inheritance.lab.singleinheritance;

public class Main {

    public static void main(String[] args) {
        //Single inheritance
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        //Hierarchical inheritance (we have two child classes of the parent class)
        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
