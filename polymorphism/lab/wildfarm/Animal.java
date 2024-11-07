package polymorphism.lab.wildfarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected String getAnimalWeight() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(0);  // Minimum 0 digits after decimal
        df.setMaximumFractionDigits(10); // Maximum up to 10 digits after decimal (adjust as needed)

        String formated = df.format(animalWeight);

        return formated;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();
    public void eat(Food food) {
        foodEaten += food.getQuantity();
    }
}
