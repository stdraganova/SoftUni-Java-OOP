package inheritance.exercise.person.needforspeed;

public class RaceMotorcycle extends  Motorcycle{

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(8);
    }
}
