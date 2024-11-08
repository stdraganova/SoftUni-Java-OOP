package Encapsulation.exercise.pizzacalories;

public enum DoughModifiers {
    WHITE (1.5),
    WHOLEGRAIN (1.0),
    CRISPY (0.9),
    CHEWY (1.1),
    HOMEMADE (1.0);

    private double modifier;

    DoughModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
