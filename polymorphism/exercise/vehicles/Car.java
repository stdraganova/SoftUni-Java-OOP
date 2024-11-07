package polymorphism.exercise.vehicles;


public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelCostPerKm, double tankCapacity) {
        super(fuelQuantity, fuelCostPerKm + 0.9, tankCapacity);
    }
}
