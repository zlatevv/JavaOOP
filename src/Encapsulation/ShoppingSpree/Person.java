package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.money -= product.getCost();
            this.products.add(product);
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return this.name + " - Nothing bought";
        } else {
            StringBuilder productNames = new StringBuilder();
            for (int i = 0; i < products.size(); i++) {
                productNames.append(products.get(i).getName());
                if (i < products.size() - 1) {
                    productNames.append(", ");
                }
            }
            return String.format("%s - %s", this.name, productNames);
        }
    }
}
