package Encapsulation.exercise.shoppingspree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name ;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct (Product product) {
        if (product.getCost()  > money){
            String message = "%s can't afford %s%n".formatted(this.getName(), product.getName());
            throw new IllegalArgumentException(message);
        }

        this.products.add(product);
        this.money -= product.getCost();
        //System.out.printf("%s bought %s%n", this.getName(), product.getName());
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
