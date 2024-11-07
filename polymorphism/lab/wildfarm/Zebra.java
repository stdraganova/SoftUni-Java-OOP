package polymorphism.lab.wildfarm;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Zebras are not eating that type of food!");
            return;
        }else {
            super.eat(food);
        }
    }

    @Override
    public String toString() {
        return "[%s, %s, %s, %d]".formatted(getAnimalName(), getAnimalWeight(), getLivingRegion(), getFoodEaten());
    }
}
