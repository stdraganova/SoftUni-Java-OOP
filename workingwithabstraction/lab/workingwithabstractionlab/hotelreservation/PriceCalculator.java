package workingwithabstraction.lab.workingwithabstractionlab.hotelreservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private int multiplier;
    private double discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, int multiplier, double discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.multiplier = multiplier;
        this.discount = discount;
    }

    public double calculate(){
        double result = pricePerDay * multiplier * numberOfDays * discount;

        return result;
    }
}
