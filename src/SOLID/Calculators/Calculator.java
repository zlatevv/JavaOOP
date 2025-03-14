package SOLID.Calculators;

import SOLID.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);
    public double average(List<Product> products);
}
