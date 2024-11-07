package inheritance.exercise.person.needforspeed;

public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double neededFuel = kilometers * fuelConsumption;

        if (neededFuel > fuel){
            return;
        }

        fuel -= neededFuel;
    }
}
