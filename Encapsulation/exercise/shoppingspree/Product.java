package Encapsulation.exercise.shoppingspree;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }
}
