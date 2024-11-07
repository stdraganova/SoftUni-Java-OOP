package polymorphism.lab.wildfarm;

public class Tiger extends Feline{

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            System.out.println("Tigers are not eating that type of food!");
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
