package inheritance.exercise.person.needforspeed;

public class SportCar extends Car {

    public SportCar (double fuel, int horsePower) {
        super(fuel,horsePower);
        this.setFuelConsumption(10);
    }
}
