package polymorphism.lab.wildfarme2;

public abstract class Food {
    protected Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
