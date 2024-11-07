package polymorphism.lab.animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return "I am %s and my favourite food is %s".formatted(name, favouriteFood);
    }

}
