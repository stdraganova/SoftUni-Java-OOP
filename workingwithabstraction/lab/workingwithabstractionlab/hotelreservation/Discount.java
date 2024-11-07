package workingwithabstraction.lab.workingwithabstractionlab.hotelreservation;

public enum Discount {
    VIP (0.8),
    SECOND_VISIT (0.9),
    NONE (1.00);

    private double discount;
    Discount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
