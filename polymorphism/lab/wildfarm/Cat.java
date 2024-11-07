package polymorphism.lab.wildfarm;

public class Cat extends Feline{

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {

        super.eat(food);
    }

    @Override
    public String toString() {
        return "[%s, %s, %s, %s, %d]".formatted(getAnimalName(), this.breed, getAnimalWeight(), getLivingRegion(), getFoodEaten());
    }
}
