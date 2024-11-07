package Encapsulation.exercise.pizzacalories;

public enum ToppingsModifiers {
    MEAT (1.2),
    VEGGIES (0.8),
    CHEESE (1.1),
    SAUCE (0.9);

    private double modifiers;

    ToppingsModifiers(double modifiers) {
        this.modifiers = modifiers;
    }

    public double getModifiers() {
        return modifiers;
    }
}
