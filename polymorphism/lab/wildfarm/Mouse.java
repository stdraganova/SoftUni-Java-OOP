package polymorphism.lab.wildfarm;

public class Mouse extends Mammal{

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Mice are not eating that type of food!");
            return;
        } else {
            super.eat(food);
        }
    }

    @Override
    public String toString() {
        return "[%s, %s, %s, %d]".formatted(getAnimalName(), getAnimalWeight(), getLivingRegion(), getFoodEaten());
    }
}
